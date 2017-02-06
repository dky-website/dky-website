package com.dky.common.bean;

import java.io.Serializable;

/**
 * Created by wangpeng on 2017/1/4.
 */
public class SessionUser implements Serializable {

    private String email;

    private Long cStoreId;

    private Long cCustomerId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getcStoreId() {
        return cStoreId;
    }

    public void setcStoreId(Long cStoreId) {
        this.cStoreId = cStoreId;
    }

    public Long getcCustomerId() {
        return cCustomerId;
    }

    public void setcCustomerId(Long cCustomerId) {
        this.cCustomerId = cCustomerId;
    }
}
