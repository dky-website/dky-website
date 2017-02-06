package com.dky.business.repository.cache;

import com.dky.business.repository.redis.client.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by wangpeng on 2016/9/30.
 */
@Component
public class RedisCacheManager {

    @Autowired
    private JedisClient jedisClient;

    public void put(Object key,Object value){
        jedisClient.add(key,value);
    }

    public void put(Object key,Object value,Long expireTime){
        jedisClient.add(key,expireTime,value);
    }

    public Object get(Object key){
        if(isExist(key)){
            return jedisClient.get(key);
        }
        return null;
    }

    public String getString(Object key){
        Object value = get(key);
        return value != null ? (String)value : null;
    }

    public Integer getInt(Object key){
        Object value = get(key);
        return value != null ? (Integer) key : null;
    }

    public Long getLong(Object key){
        Object value = get(key);
        return value != null ? Long.parseLong(String.valueOf(value)) : null;
    }

    public boolean isExist(Object key){
        if(jedisClient.hasKey(key)){
            return true;
        }
        return false;
    }

    public void delete(Object key){
        jedisClient.del(key);
    }



}
