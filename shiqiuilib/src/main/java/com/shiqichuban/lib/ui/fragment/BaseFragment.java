package com.shiqichuban.lib.ui.fragment;/**
 * Created by shiqichuban on 17/4/27.
 */

import android.app.Activity;

import com.shiqichuban.lib.ui.UIApplication;
import com.trello.rxlifecycle.components.support.RxFragment;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-27
 * Time: 14:25
 * Company: 拾柒网络
 * description:
 */
public class BaseFragment extends RxFragment {

    /**
     * 屏幕宽度
     */
    protected int screenW;
    /**
     * 屏幕高度
     */
    protected int screenH;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        initScreenWH();
    }

    private void initScreenWH(){
        if(getActivity().getApplication() instanceof UIApplication){
            UIApplication uiApplication=(UIApplication) getActivity().getApplication();
            screenW =uiApplication.screenW;
            screenH =uiApplication.screenH;
        }
    }
}
