package com.wxb.commontest.util;

import org.slf4j.LoggerFactory;

/**
 * @description: 日志工具类
 * @author: sjj
 * @create: 2018-12-04 16:00
 **/
public class LoggerUtil {
    public static void debug(Class<?> clazz, String str) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).debug(str);
    }

    public static void debug(Class<?> clazz, String str, Object obj) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).debug(str, obj);
    }

    public static void debug(Class<?> clazz, String str, Object[] objs) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).debug(str, objs);
    }

    public static void debug(Class<?> clazz, Throwable e) {
        LoggerFactory.getLogger(clazz).debug("异常抛出：", e);
    }

    public static void info(Class<?> clazz, String str) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).info(str);
    }

    public static void info(Class<?> clazz, String str, Object obj) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).info(str, obj);
    }

    public static void info(Class<?> clazz, String str, Object[] objs) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).info(str, objs);
    }

    public static void error(Class<?> clazz, String str) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).error(str);
    }

    public static void error(Class<?> clazz, String str, Object obj) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).error(str, obj);
    }

    public static void error(Class<?> clazz, String str, Object[] objs) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).error(str, objs);
    }

    public static void error(Class<?> clazz, String str, Throwable e) {
        str = str == null ? "" : str;
        LoggerFactory.getLogger(clazz).error(str, e);
    }

    public static void error(Class<?> clazz, Throwable e) {
        error(clazz, "", e);
    }
}
