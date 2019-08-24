package cn.smart4j.framework.util;

/**
 * 类型转换工具类
 */
public final class CastUtil {

    /**
     * 对象转成字符串（设置默认值）
     * @param obj
     * @param defaultValue
     * @return
     */
    public static String objToStr(Object obj,String defaultValue){
        return obj==null?defaultValue:String.valueOf(obj);
    }

    /**
     * 对象转为字符串
     * @param obj
     * @return
     */
    public static String objToStr(Object obj){
        return objToStr(obj,"");
    }

    /**
     * 对象转成int（设置默认值）
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int objToInt(Object obj,int defaultValue){
        int intValue=defaultValue;
        if(obj!=null){
          String value=objToStr(obj);
          try {
              intValue = Integer.parseInt(value);
          }catch (NumberFormatException e){
              intValue=defaultValue;
          }
        }
        return intValue;
    }

    /**
     * 对象转成int
     * @param obj
     * @return
     */
    public static int objToInt(Object obj){
        return objToInt(obj,0);
    }

    /**
     * 对象转成double（设置默认值）
     * @param obj
     * @param defaultValue
     * @return
     */
    public static double objToDouble(Object obj,double defaultValue){
        double doubleValue=defaultValue;
        if(obj!=null){
            String value=objToStr(obj);
            try {
                doubleValue = Double.parseDouble(value);
            }catch (NumberFormatException e){
                doubleValue=defaultValue;
            }
        }
        return doubleValue;
    }

    /**
     * 对象转成double
     * @param obj
     * @return
     */
    public static double objToDouble(Object obj){
        return objToDouble(obj,0);
    }

    /**
     * 对象转成long（设置默认值）
     * @param obj
     * @param defaultValue
     * @return
     */
    public static long objToLong(Object obj,long defaultValue){
        long longValue=defaultValue;
        if(obj!=null){
            String value=objToStr(obj);
            try {
                longValue= Long.parseLong(value);
            }catch (NumberFormatException e){
                longValue=defaultValue;
            }
        }
        return longValue;
    }

    /**
     * 对象转成long
     * @param obj
     * @return
     */
    public static long objToLong(Object obj){
        return objToLong(obj,0);
    }

    /**
     * 对象转成boolean（设置默认值）
     * @param obj
     * @param defaultValue
     * @return
     */
    public static boolean objToBoolean(Object obj,boolean defaultValue){
        boolean booleanValue=defaultValue;
        if(obj!=null){
            String value=objToStr(obj);
            try {
                booleanValue= Boolean.parseBoolean(value);
            }catch (NumberFormatException e){
                booleanValue=defaultValue;
            }
        }
        return booleanValue;
    }
    /**
     * 对象转成boolean
     * @param obj
     * @return
     */
    public static boolean objToBoolean(Object obj){
        return objToBoolean(obj,false);
    }
}
