package com.shiqichuban.lib.core.utils;

import android.util.Log;

import com.lqk.framework.util.Handler_System;

/**
 * LOG 管理
 */
public class LG {

    /**
     * 是否开启debug
     */
    public static boolean isDebug = true;

    static {
        try {
            isDebug = "true".equalsIgnoreCase(Handler_System.getMetaDataValue("isDebug", "false")) ? true : false;
        }catch (Exception e){e.printStackTrace();}
    }
    /**
     * 错误
     * @param clazz
     * @param msg
     */
    public static void e(Class<?> clazz, String msg) {
        if (isDebug) {
           e(clazz.getSimpleName(), msg + "");
        }
    }
    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(tag, msg + "");
        }
    }

    /**
     * 信息
     * @param clazz
     * @param msg
     */
    public static void i(Class<?> clazz, String msg) {
        if (isDebug) {
            Log.i(clazz.getSimpleName(), msg + "");
        }
    }
    public static void i(String tag, String msg) {
        if (isDebug) {
            Log.i(tag, msg + "");
        }
    }
    /**
     * 信息
     * @param clazz
     * @param msg
     */
    public static void d(Class<?> clazz, String msg) {
        if (isDebug) {
            Log.d(clazz.getSimpleName(), msg + "");
        }
    }
    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg + "");
        }
    }

    /**
     * 警告
     * @param clazz
     * @param msg
     */
    public static void w(Class<?> clazz, String msg) {
        if (isDebug) {
            Log.w(clazz.getSimpleName(), msg + "");
        }
    }
}