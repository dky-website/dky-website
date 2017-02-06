package com.dky.common.utils;

import com.dky.common.bean.SessionUser;
import com.dky.common.constats.GlobConts;

/**
 * Dky工具类
 * Created by wangpeng on 2017/1/6.
 */
public class DkyUtils {

    /**
     * 加入到登陆用户到当前线程
     * @param sessionUser
     */
    public static void putCurrentUser(SessionUser sessionUser){
        ThreadLocalUtils.put(GlobConts.CURRENT_SESSION_KEY,sessionUser);
    }

    /**
     * 获取当前登陆用户
     * @return
     */
    public static SessionUser getCurrentUser(){
        return (SessionUser) ThreadLocalUtils.getObj(GlobConts.CURRENT_SESSION_KEY);
    }
}
