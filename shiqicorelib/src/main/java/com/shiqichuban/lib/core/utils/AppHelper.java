package com.shiqichuban.lib.core.utils;/**
 * Created by shiqichuban on 17/4/15.
 */

import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.lqk.framework.app.Ioc;
import com.lqk.framework.util.Handler_System;
import com.shiqichuban.lib.core.other.IProgress;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-15
 * Time: 16:16
 * Company: 拾柒网络
 * description:
 */
public class AppHelper {
    private static Application application;
    private static Context mContext;
    private static IProgress mIProgress;

    public static void init(Application app){
        setApplication(app);
        LitePalHelper.initialize(mContext);
        LitePalHelper.changeDB();
        Ioc.getIoc().init(app,false);
        setUserAgent();
    }

    public static Application getApplication() {
        return application;
    }

    private static void setApplication(Application application) {
        AppHelper.application = application;
        mContext=application.getApplicationContext();
    }

    public static IProgress getmIProgress() {
        return mIProgress;
    }

    public static void setmIProgress(IProgress mIProgress) {
        AppHelper.mIProgress = mIProgress;
    }

    public static Context getContext() {
        return mContext;
    }

    private static void setUserAgent(){
        String agent="/"+ Build.MANUFACTURER+"/"+ Build.DEVICE+"/"+ Build.MODEL+"/"+Build.VERSION.SDK_INT+"/android/"+mContext.getPackageName()+"/"+ Handler_System.getAppVersionNumber();
        String userAgent= agent;
        LG.e("SHIQIApplication", "user-agent" + userAgent);
        SPUtils.put(mContext, SPConstants.UserAgent, userAgent);
    }
}
