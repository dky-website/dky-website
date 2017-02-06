package com.dky.business.repository.biz.impl;

import com.dky.business.repository.biz.BaseService;
import com.dky.business.repository.repository.BaseDao;
import com.dky.common.bean.PojoObjectBase;
import com.dky.common.constats.GlobConts;
import com.dky.common.response.PageList;

/**
 * Created by wangpeng on 2016/12/13.
 */
public abstract class BaseServiceImpl<T,K> implements BaseService<T,K> {

    protected abstract BaseDao<T,K> getDao();

    public PageList<T> findByPage(T t) {
        if (this.getDao() != null && this.getDao() instanceof BaseDao) {
            if(t instanceof PojoObjectBase){
               if(((PojoObjectBase) t).getRequestOffset() == null && ((PojoObjectBase) t).getRequestCount() == null){
                   ((PojoObjectBase) t).setRequestOffset(0);
                   ((PojoObjectBase) t).setRequestCount(GlobConts.DEFUALT_PAGE_SIZE);
               }
            }
            return new PageList<T>(getDao().query(t), getDao().count(t), 0, 0);
        }
        return null;
    }
}
