package com.dky.business.repository.repository;


import java.util.List;

/**
 * Created by wangpeng on 2016/12/13.
 */
public interface BaseDao<T,K> {

    void add(T var1);

    int update(T var1);

    T get(T var1);

    T getById(K var1);

    List<T> query(T var1);

    int delete(K var1);

    int count(T var1);


    int deleteByPrimaryKey(K id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(K id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
