package cn.smart4j.framework.helper;

import cn.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean 助手类
 */
public final  class BeanHelper {

    private static final Map<Class<?>,Object> BEAN_MAP;

    static{
        BEAN_MAP=new HashMap<Class<?>, Object>();
        Set<Class<?>> classSet=ClassHelper.getBeanClassSet();
        for(Class<?> cls:classSet){
           BEAN_MAP.put(cls, ReflectionUtil.newInstance(cls));
        }
    }

    /**
     * 读取Bean映射关系
     * @return
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获取bean实例
     */
    public static<T> T getBean(Class<T> cls){
        if(!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class:"+cls);
        }        return (T) BEAN_MAP.get(cls);
    }



}
