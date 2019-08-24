package cn.smart4j.framework.helper;

import cn.smart4j.framework.annotation.Inject;
import cn.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.logging.FileHandler;

/**
 * 依赖注入助手类
 */
public final class IocHelper {

    static{
        Map<Class<?>,Object> beanMap=BeanHelper.getBeanMap();
        if(beanMap!=null&&beanMap.size()>0){
                for(Map.Entry<Class<?>,Object>  beanEntry:beanMap.entrySet()){
                    Class<?> beanClass=beanEntry.getKey();
                    Object beanInstance=beanEntry.getValue();
                    Field[] fields=beanClass.getDeclaredFields();
                    if(fields!=null&&fields.length>0){
                        for(Field field:fields){
                            if(field.isAnnotationPresent(Inject.class)){
                                Class<?> beanFieldClass=field.getType();
                                Object beanFieldInstance=beanMap.get(beanFieldClass);
                                if(beanFieldInstance!=null){
                                    ReflectionUtil.setField(beanInstance,field,beanFieldInstance);
                                }
                            }
                        }
                    }
                }
        }
    }
}
