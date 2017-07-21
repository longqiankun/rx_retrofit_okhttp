package com.shiqichuban.lib.ui.activity;/**
 * Created by shiqichuban on 17/4/27.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.shiqichuban.lib.ui.UIApplication;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-27
 * Time: 14:23
 * Company: 拾柒网络
 * description:
 */
public class BaseAppActivity extends RxAppCompatActivity {

    /**
     * 屏幕宽度
     */
    protected int screenW;
    /**
     * 屏幕高度
     */
    protected int screenH;

    public boolean isShow=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initScreenWH();
        isShow=true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isShow=false;
    }

    private void initScreenWH(){
        if(getApplication() instanceof UIApplication){
            UIApplication uiApplication=(UIApplication) getApplication();
            screenW =uiApplication.screenW;
            screenH =uiApplication.screenH;
        }
    }
}
