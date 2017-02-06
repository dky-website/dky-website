package com.dky.web.controller;

import com.dky.business.repository.biz.BootService;
import com.dky.common.bean.Boot;
import com.dky.common.param.BootQueryParam;
import com.dky.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wonpera on 2017/1/3.
 */
@RestController
@RequestMapping("boot")
public class BootController {

    @Autowired
    private BootService bootService;


    /**
     * 查询有效的启动页
     * @param param
     * @return
     */
    @RequestMapping(value = "queryValid",name = "查询有效的启动页")
    public ReturnT<List<Boot>> queryValid(BootQueryParam param){
        return bootService.queryValid(param);
    }

    @RequestMapping("getById")
    public ReturnT<Boot> getById(){
        return new ReturnT<>().sucessData(bootService.selectByPrimaryKey(1L));
    }

    @RequestMapping(value = "insert",name = "新增启动页")
    public ReturnT inert(Boot boot){
        bootService.insertSelective(boot);
        return new ReturnT().sucessData(boot);
    }
}
