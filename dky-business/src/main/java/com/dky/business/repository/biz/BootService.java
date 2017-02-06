package com.dky.business.repository.biz;

import com.dky.common.bean.Boot;
import com.dky.common.param.BootQueryParam;
import com.dky.common.response.ReturnT;

import java.util.List;

/**
 * Created by wonpera on 2017/1/3.
 */
public interface BootService {


    int insert(Boot record);

    int insertSelective(Boot record);

    Boot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Boot record);

    int updateByPrimaryKey(Boot record);


    /**
     * 查询可用的启动页
     * @param param
     * @return
     */
    ReturnT<List<Boot>> queryValid(BootQueryParam param);
}
