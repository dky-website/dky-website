package com.dky.common.session;

import com.dky.common.bean.SessionUser;

import java.io.Serializable;

/**
 * Created by wangpeng on 2016/11/7.
 */
public class SessionParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accessToken;

    private SessionUser sessionUser;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public SessionUser getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(SessionUser sessionUser) {
        this.sessionUser = sessionUser;
    }
}
