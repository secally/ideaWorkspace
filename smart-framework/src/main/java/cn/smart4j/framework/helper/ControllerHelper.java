package cn.smart4j.framework.helper;

import cn.smart4j.framework.annotation.Action;
import cn.smart4j.framework.bean.Handler;
import cn.smart4j.framework.bean.Request;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 */
public final  class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP=new HashMap<Request, Handler>();

    static{
        Set<Class<?>> classSet=ClassHelper.getControllerClassSet();
        if(classSet!=null&&classSet.size()>0){
            for(Class<?> cls:classSet){
                Method[] methods=cls.getMethods();
                if(methods!=null&&methods.length>0){
                    for(Method method:methods){
                        if(method.isAnnotationPresent(Action.class)){
                            Action action=method.getAnnotation(Action.class);
                            String mapping=action.values();
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] arraydata=mapping.split("\\:");
                                if(arraydata!=null&&arraydata.length>0&&arraydata.length==2){
                                    String requestMethod=arraydata[0];
                                    String requestPath=arraydata[1];
                                    Request request=new Request(requestMethod,requestPath);
                                    Handler handler=new Handler(cls,method);
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }
        }

    }



}