package com.example.myapplication.utils;

import android.content.Context;

public class Utils {
    // 根据手机分辨率 将dp 转化为 px(像素)
    public static int dip2x(Context context, float dpValue){
        // 获取当前的手机像素密度 （一个1dp对应几个px）
        float scale = context.getResources().getDisplayMetrics().density;
        // +0.5f 是四舍五入取整
        return (int) (dpValue * scale + 0.5f);
    }
}
