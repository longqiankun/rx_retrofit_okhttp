package com.shiqichuban.lib.core;/**
 * Created by shiqichuban on 17/4/27.
 */

import android.app.Application;

import com.shiqichuban.lib.core.utils.AppHelper;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-27
 * Time: 14:33
 * Company: 拾柒网络
 * description:
 */
public class CoreApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        AppHelper.init(this);
    }
}
