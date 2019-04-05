package com.app.movie.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JAIWEI
 * @company Thredim
 * @date on 2019/4/5.
 * @org www.thredim.com (宁波视睿迪光电有限公司)
 * @email thredim@thredim.com
 * @describe 添加描述
 */
public class SPUtils {
    private static final String CONFIG = "config";

    /**
     * 获取SharedPreferences实例对象
     *
     * @param fileName
     */
    private static SharedPreferences getSharedPreference(Context context,String fileName) {

        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    /**
     * 保存一个String类型的值！
     */
    public static void putString(Context context,String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference(context,CONFIG).edit();
        editor.putString(key, value).apply();
    }

    /**
     * 获取String的value
     */
    public static String getString(Context context,String key, String defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context,CONFIG);
        return sharedPreference.getString(key, defValue);
    }

    /**
     * 保存一个Boolean类型的值！
     */
    public static void putBoolean(Context context,String key, Boolean value) {
        SharedPreferences.Editor editor = getSharedPreference(context,CONFIG).edit();
        editor.putBoolean(key, value).apply();
    }

    /**
     * 获取boolean的value
     */
    public static boolean getBoolean(Context context,String key, Boolean defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context,CONFIG);
        return sharedPreference.getBoolean(key, defValue);
    }

    /**
     * 保存一个int类型的值！
     */
    public static void putInt(Context context,String key, int value) {
        SharedPreferences.Editor editor = getSharedPreference(context,CONFIG).edit();
        editor.putInt(key, value).apply();
    }

    /**
     * 获取int的value
     */
    public static int getInt(Context context,String key, int defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context,CONFIG);
        return sharedPreference.getInt(key, defValue);
    }

    /**
     * 保存一个float类型的值！
     */
    public static void putFloat(Context context,String fileName, String key, float value) {
        SharedPreferences.Editor editor = getSharedPreference(context,fileName).edit();
        editor.putFloat(key, value).apply();
    }

    /**
     * 获取float的value
     */
    public static float getFloat(Context context,String key, Float defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context,CONFIG);
        return sharedPreference.getFloat(key, defValue);
    }

    /**
     * 保存一个long类型的值！
     */
    public static void putLong(Context context,String key, long value) {
        SharedPreferences.Editor editor = getSharedPreference(context,CONFIG).edit();
        editor.putLong(key, value).apply();
    }

    /**
     * 获取long的value
     */
    public static long getLong(Context context,String key, long defValue) {
        SharedPreferences sharedPreference = getSharedPreference(context,CONFIG);
        return sharedPreference.getLong(key, defValue);
    }

    /**
     * 取出List<String>
     *
     * @param key     List<String> 对应的key
     * @return List<String>
     */
    public static List<String> getStrListValue(Context context,String key) {
        List<String> strList = new ArrayList<String>();
        int size = getInt(context,key + "size", 0);
        //Log.d("sp", "" + size);
        for (int i = 0; i < size; i++) {
            strList.add(getString(context,key + i, null));
        }
        return strList;
    }

    /**
     * 存储List<String>
     *
     * @param context
     * @param key     List<String>对应的key
     * @param strList 对应需要存储的List<String>
     */
    public static void putStrListValue(Context context,String key, List<String> strList) {
        if (null == strList) {
            return;
        }
        // 保存之前先清理已经存在的数据，保证数据的唯一性
        removeStrList(context,key);
        int size = strList.size();
        putInt(context,key + "size", size);
        for (int i = 0; i < size; i++) {
            putString(context,key + i, strList.get(i));
        }
    }

    /**
     * 清空List<String>所有数据
     *
     * @param key     List<String>对应的key
     */
    public static void removeStrList(Context context,String key) {
        int size = getInt(context,key + "size", 0);
        if (0 == size) {
            return;
        }
        remove(context,key + "size");
        for (int i = 0; i < size; i++) {
            remove(context,key + i);
        }
    }

    /**
     * 清空对应key数据
     */
    public static void remove(Context context,String key) {
        SharedPreferences.Editor editor = getSharedPreference(context,CONFIG).edit();
        editor.remove(key).apply();
    }

    public static boolean getNightMode(Context context) {
        return SPUtils.getBoolean(context,Constants.KEY_MODE_NIGHT, false);
    }

    public static void setNightMode(Context context,boolean nightMode) {
        SPUtils.putBoolean(context,Constants.KEY_MODE_NIGHT, nightMode);
    }
}
