package cn.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件工具类
 */
public final class PropsUtil {

    private static final Logger LOGGER= LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     * @param name
     * @return
     */
    public static Properties loadProps(String name){
        Properties props=null;
        InputStream is=null;
        try{
           is=Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
           if(is==null){
               throw  new FileNotFoundException(name+" file is not found");
           }
           props=new Properties();
           props.load(is);
        }catch (IOException e) {
            LOGGER.error("load properties file failure",e);
        } catch (Exception e) {
            LOGGER.error("load properties file failure",e);
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close input stream failure",e);
                }
            }
        }
        return props;
    }

    public static String getString(Properties props,String key,String defaultValue){
        if(props.containsKey(key)){
            return props.getProperty(key);
        }
        return defaultValue;
    }
    public static String getString(Properties props,String key){
        return getString(props,key,"");
    }
    public static int getInt(Properties props,String key,int defaultValue){
        int value=defaultValue;
        if(props.containsKey(key)){
            try {
                value = Integer.parseInt(props.getProperty(key));
            }catch (NumberFormatException e){
            }
        }
        return value;
    }
    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }

    public static boolean getBoolean(Properties props,String key,boolean defaultValue){
        boolean value=defaultValue;
        if(props.containsKey(key)){
            try {
                value =Boolean.getBoolean(props.getProperty(key));
            }catch (NumberFormatException e){
            }
        }
        return value;
    }

    public static boolean getBoolean(Properties props,String key){
        return getBoolean( props, key,false);
    }
}
