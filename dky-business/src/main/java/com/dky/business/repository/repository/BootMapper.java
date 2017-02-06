package com.dky.business.repository.repository;

import com.dky.common.bean.Boot;

import java.util.List;

@MyBatisRepository
public interface BootMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Boot record);

    int insertSelective(Boot record);

    Boot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Boot record);

    int updateByPrimaryKey(Boot record);


    /**
     * 查询可用的启动页
     * @param boot
     * @return
     */
    List<Boot> queryValid(Boot boot);
}