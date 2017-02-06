package com.dky.common.bean;

import java.io.Serializable;

/**
 * Created by wangpeng on 2016/12/13.
 */
public class PageObjectBase implements Serializable {

    private static final long serialVersionUID = 1L;
    public Integer requestOffset;
    public Integer requestCount;

    private Integer pageNo;
    private Integer pageSize;

    public Integer getRequestOffset() {
        return requestOffset;
    }

    public void setRequestOffset(Integer requestOffset) {
        this.requestOffset = requestOffset;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
