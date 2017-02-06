package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.BootService;
import com.dky.business.repository.repository.BootMapper;
import com.dky.common.bean.Boot;
import com.dky.common.param.BootQueryParam;
import com.dky.common.response.ReturnT;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wonpera on 2017/1/3.
 */
@Service
@Transactional
public class BootServiceImpl implements BootService {

    @Autowired
    private BootMapper bootMapper;


    @Override
    public int insert(Boot record) {
        return bootMapper.insert(record);
    }

    @Override
    public int insertSelective(Boot record) {
        return bootMapper.insertSelective(record);
    }

    @Override
    public Boot selectByPrimaryKey(Long id) {
        return bootMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Boot record) {
        return bootMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Boot record) {
        return bootMapper.updateByPrimaryKey(record);
    }


    /**
     * 查询有效的启动页
     * @param param
     * @return
     */
    @Override
    public ReturnT<List<Boot>> queryValid(BootQueryParam param) {
        Boot boot = new Boot();
        BeanUtils.copyProperties(param,boot);
        List<Boot> list = bootMapper.queryValid(boot);
        return new ReturnT<>().sucessData(list);
    }


}
