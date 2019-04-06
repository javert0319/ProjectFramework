package com.app.movie.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * @author JAIWEI
 * @company Thredim
 * @date on 2019/4/6.
 * @org www.thredim.com (宁波视睿迪光电有限公司)
 * @email thredim@thredim.com
 * @describe 添加描述
 */
public class ToastUtil {
    public static void toast(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
    public static void toastLong(Context context,String text){
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
