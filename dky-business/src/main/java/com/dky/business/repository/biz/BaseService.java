package com.dky.business.repository.biz;

import com.dky.common.response.PageList;

/**
 * Created by wangpeng on 2016/12/13.
 */
public interface BaseService<T,K> {

    /**
     * 分页查询
     *
     * @param t
     * @return
     */
    public PageList<T> findByPage(T t);
}
