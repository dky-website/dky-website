package com.dky.web.aspect;


import com.dky.business.repository.session.SessionProcess;
import com.dky.common.bean.SessionUser;
import com.dky.common.constats.GlobConts;
import com.dky.common.enums.ResultCodeEnum;
import com.dky.common.response.ReturnT;
import com.dky.common.session.SessionParameter;
import com.dky.common.session.WebPageParameter;
import com.dky.common.utils.DkyUtils;
import com.dky.common.utils.ThreadLocalUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 用户会话切面
 * Created by wangpeng on 2016/11/7.
 */
@Aspect
@Component
public class SessionAspect implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionAspect.class);

    @Autowired
    private SessionProcess sessionProcess;

    @Around("execution(* com.dky.web.controller..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if(requestAttributes == null) {
            return pjp.proceed();
        }
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();//登陆方法
        if(method.getName().equals("loginUser")){
            return pjp.proceed();
        }
        HttpServletRequest request = requestAttributes.getRequest();//获取request
        String accessToken = sessionProcess.getAcessToken(request);
        if(StringUtils.isEmpty(accessToken)){
            return new ReturnT<>().failureData(ResultCodeEnum.NOLOGIN);
        }
        SessionUser user = sessionProcess.getSessionUser(accessToken);
        if(user == null){
            return new ReturnT<>().failureData(ResultCodeEnum.NOLOGIN);
        }
        DkyUtils.putCurrentUser(user);//加入当前登陆用户
        for (int i = 0; i< args.length;i++){//请求参数
            Object arg = args[i];
            if(arg instanceof SessionParameter){
                SessionParameter sessionParameter = (SessionParameter)arg;
                sessionParameter.setAccessToken(accessToken);
                sessionParameter.setSessionUser(user);
            }
            if(arg instanceof WebPageParameter){//分页
                WebPageParameter webPageParameter = (WebPageParameter)arg;
                //计算分页起始行数
                webPageParameter.calculatePageLimit();
            }
        }
        return pjp.proceed();
    }



    @Override
    public int getOrder() {
        return 1;
    }
}
