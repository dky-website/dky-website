package com.dky.common.utils;

import com.dky.common.constats.GlobConts;
import com.dky.common.response.PageList;
import com.dky.common.response.ReturnT;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * Created by wonpera on 2017/1/7.
 */
public class ConverImagePathUtils {

    private static final String URL_SPERATOR = "/";

    /**
     * imageUrl转换器
     * @param returnT
     */
    public static void transferImageUrl(ReturnT returnT){
        Object data = returnT.getData();
        if(data != null){
            if(data instanceof PageList){
                proccessPageList((PageList)data);
            }else if(data instanceof List){
                proccessList((List) data);
            }else if(data instanceof Map) {
                processMap((Map)data);
            }else {
                processNormalBean(data);
            }
        }
    }

    private static void processMap(Map map){
        if(map != null){
            Iterator it = map.keySet().iterator();
            while (it.hasNext()){
                Object key = it.next();
                Object value = map.get(key);
                processNormalBean(value);
            }
        }
    }

    private static void proccessPageList(PageList pageList){
        List item = pageList.getItems();
        if(item != null){
            proccessList(item);
        }
    }

    private static void proccessList(List list){
        if(list != null && list.size() > 0){
            for (Object obj : list){
                processNormalBean(obj);
            }
        }
    }


    private static void processNormalBean(Object object){
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            String name = field.getName();
            for (String s : GlobConts.PREFIX){
                if(name.startsWith(s) || name.endsWith(s)){
                    try {
                        Object oldValue = PropertyUtils.getProperty(object, name);
                        String path = oldValue == null ? "" : String.valueOf(oldValue);
                        PropertyUtils.setProperty(object,name,appendImageUrl( GlobConts.IMAGE_ROOT_URL,path));
                    } catch (Exception e) {
                    }
                }
            }

        }
    }

    private static String appendImageUrl(String root,String path){
        if(StringUtils.isEmpty(root)){
            root = GlobConts.IMAGE_ROOT_URL;
        }
        if(root.endsWith(URL_SPERATOR)){
            root = StringUtils.removeEnd(root,URL_SPERATOR);
        }
        if(path.startsWith(URL_SPERATOR)){
            path = StringUtils.removeStart(path,URL_SPERATOR);
        }

        return root+URL_SPERATOR+path;
    }




    /**
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
     *
     *@param clazz
     *            clazz The class to introspect
     * @param index
     *            the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be
     *         determined
     */
    @SuppressWarnings("unchecked")
    public static Class<Object> getSuperClassGenricType(final Class clazz, final int index) {

        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }

        return (Class) params[index];
    }
}
