package com.dky.common.constats;

import com.dky.common.utils.PropertieUtils;

/**
 * 全局常量
 * Created by wangpeng on 2016/12/13.
 */
public class GlobConts {

    public static final String DEFAULT_FORMATTER_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";


    public static final String DEFAULT_FORMATTER_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 默认分页大小
     */
    public static final int DEFUALT_PAGE_SIZE = 10;


    public static final Long MAX_EXPIRE_TIME = Long.valueOf(Long.parseLong(String.valueOf(2147483647)) * 1000L);


    /**
     * cookie前缀
     */
    public static final String COOKIE_PREFIX = "Bearer ";


    public static final String SESSION_COOKIE_KEY = "Authorization";


    /**
     * 当前登陆session
     */
    public static final String CURRENT_SESSION_KEY = "current_session";


    /**
     * 图片跟路径
     */
    public static final String IMAGE_ROOT_URL = PropertieUtils.getString("imageRootUrl");


    /**
     * 替换图片字段开头、结尾
     */
    public static final String[] PREFIX = {"imageurl","imageUrl","imgUrl","imgurl"};
}
