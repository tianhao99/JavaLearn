package com.tianhao.utils;

import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ClassName WebUtils
 * @Description TODO:
 * @Author sth_199509@163.com
 * @Date 2021/11/12 11:14
 * @Version 1.0
 */
public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性
     * @param value
     * @param bean
     */
    public static <T>T copyParamToBean(Map value, T bean){
        try {
            // 把对象的参数 注入到 bean对象中
            BeanUtils.populate(bean,value);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成int类型的数据
     * 主要统一写，减少重复代码， 因为这个过程要处理异常，代码比较啰嗦
     * @param str
     * @param defaultValue
     * @return
     */
    public static int parseInt(String str,int defaultValue){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
