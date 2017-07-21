package com.shiqichuban.lib.ui.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.lqk.framework.util.Handler_System;
import com.shiqichuban.lib.core.utils.SPUtils;

import java.util.List;

public class GuideUtil {
    private Context context;
    private ImageView imgView;
    private WindowManager windowManager;
    private static GuideUtil instance = null;
    /**
     * 是否第一次进入该程序
     **/
    int width;
    int height;

    /**
     * 采用私有的方式，只保证这种通过单例来引用，同时保证这个对象不会存在多个
     **/
    private GuideUtil() {
    }

    /**
     * 采用单例的设计模式，同时用了同步锁
     **/
    public static GuideUtil getInstance() {
        synchronized (GuideUtil.class) {
            if (null == instance) {
                instance = new GuideUtil();
            }
        }
        return instance;
    }

    private Handler handler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    // 设置LayoutParams参数
                    final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
                    // 设置显示的类型，TYPE_PHONE指的是来电话的时候会被覆盖，其他时候会在最前端，显示位置在stateBar下面，其他更多的值请查阅文档
//                    params.type = WindowManager.LayoutParams.TYPE_PHONE;
                    // 设置显示格式
                    params.format = PixelFormat.RGBA_8888;
                    // 设置对齐方式
                    params.gravity = Gravity.LEFT | Gravity.TOP;
                    // 设置宽高
                    params.width = width;
                    params.height = height- Handler_System.getBarHeight();
                    // 设置动画
//                params.windowAnimations = R.style.;

                    // 添加到当前的窗口上
                    windowManager.addView(imgView, params);
                    break;
            }
        }

        ;
    };

    /**
     * @param context
     * @param drawableRourcesIds：引导图片的资源Id
     * @方法说明:初始化
     * @方法名称:initGuide
     * @返回值:void
     */
    public void initGuide(Activity context, String tag, final List<Integer> drawableRourcesIds) {
        /**如果不是第一次进入该界面**/
        int guideTimes = (Integer) SPUtils.get(context, tag, 0);

        if (guideTimes > 1 || drawableRourcesIds == null || drawableRourcesIds.size() == 0) return;

        if (height == 0) {
            height = getDisPlayMetrics(context).heightPixels;
            width = getDisPlayMetrics(context).widthPixels;
        }
        this.context = context;
        windowManager = context.getWindowManager();

        /** 动态初始化图层**/
        imgView = new ImageView(context);
        imgView.setLayoutParams(new WindowManager.LayoutParams(
                android.view.ViewGroup.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT));
        imgView.setScaleType(ImageView.ScaleType.FIT_XY);
        imgView.setImageResource(drawableRourcesIds.get(0));
        /**这里我特意用了一个handler延迟显示界面，主要是为了进入界面后，你能看到它淡入得动画效果，不然的话，引导界面就直接显示出来**/
        handler.sendEmptyMessageDelayed(1, 1000);

        imgView.setOnClickListener(new View.OnClickListener() {
            int currentGuide = 0;
            @Override
            public void onClick(View v) {
                currentGuide++;
                if (currentGuide < drawableRourcesIds.size()) {
                    imgView.setImageResource(drawableRourcesIds.get(currentGuide));
                } else {
                    /** 点击图层之后，将图层移除**/
                    windowManager.removeView(imgView);
                }

            }
        });
        SPUtils.put(context,tag, guideTimes + 1);
    }

    public static DisplayMetrics getDisPlayMetrics(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        if (null != context) {
            ((Activity) context).getWindowManager().getDefaultDisplay()
                    .getMetrics(metric);
        }
        return metric;
    }
}