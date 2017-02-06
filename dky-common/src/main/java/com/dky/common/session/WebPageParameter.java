package com.dky.common.session;

import com.dky.common.constats.GlobConts;

/**
 * Created by wonpera on 2017/1/6.
 */
public class WebPageParameter extends SessionParameter {

    private Integer requestOffset;
    private Integer requestCount;
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

    /**
     * 计算分页起始行
     */
    public void calculatePageLimit() {
        if (pageNo == null) {
            pageNo = 1;
        }
        if (pageSize == null) {
            pageSize = GlobConts.DEFUALT_PAGE_SIZE;
        }
        this.requestOffset = (pageNo - 1) * pageSize + 1;
        this.requestCount = pageNo * pageSize;
    }
}
