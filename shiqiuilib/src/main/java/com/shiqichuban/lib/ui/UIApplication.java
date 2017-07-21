package com.shiqichuban.lib.ui;/**
 * Created by shiqichuban on 17/4/27.
 */

import android.util.DisplayMetrics;

import com.lqk.framework.util.ToastUtils;
import com.shiqichuban.lib.core.CoreApplication;
import com.shiqichuban.lib.core.utils.AppHelper;
import com.shiqichuban.lib.ui.view.ProgressImp;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-27
 * Time: 14:36
 * Company: 拾柒网络
 * description:
 */
public class UIApplication extends CoreApplication {
    /**
     * 屏幕宽度

     */
    public int screenW;
    /**
     * 屏幕高度
     */
    public int screenH;

    @Override
    public void onCreate() {
        super.onCreate();

        getScreenWH();

        initToastStyle();
        
        initProgress();
    }

    private void initProgress() {
        AppHelper.setmIProgress(new ProgressImp());
    }


    //获取屏幕宽高
    private void getScreenWH(){
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();
        screenW = dm.widthPixels;      // 屏幕宽（像素，如：480px）
        screenH = dm.heightPixels;     // 屏幕高（像素，如：800px）
    }

    private void initToastStyle(){
        ToastUtils.setBg(R.drawable.toast_bg);
        ToastUtils.setTextsize(13);
    }
}
