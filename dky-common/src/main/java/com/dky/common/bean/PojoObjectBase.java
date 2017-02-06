package com.dky.common.bean;

/**
 * Created by wangpeng on 2016/12/13.
 */
public class PojoObjectBase extends PageObjectBase {

    private static final long serialVersionUID = 1L;
    public Object extendedParameter;

    public Object getExtendedParameter() {
        return extendedParameter;
    }

    public void setExtendedParameter(Object extendedParameter) {
        this.extendedParameter = extendedParameter;
    }
}
