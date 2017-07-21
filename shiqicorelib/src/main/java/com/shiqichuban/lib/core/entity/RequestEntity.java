package com.shiqichuban.lib.core.entity;/**
 * Created by shiqichuban on 17/4/24.
 */

import android.app.Activity;

import com.trello.rxlifecycle.LifecycleProvider;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-24
 * Time: 18:38
 * Company: 拾柒网络
 * description:
 */
public class RequestEntity {

    //提示方式是Toast
    public final static int TOAST=1;
    //提示方式是Dialog
    public final static int DIALOG=2;

    public boolean isShowLoading;
    public int tag;
    public int promptStyle=TOAST;
    public int successRes;
    public int failRes;
    public boolean isCancle;
    public String progressText;
    public Object lifecycleProvider;

    public RequestEntity() {
    }

    public RequestEntity(int tag) {
        this.tag = tag;
    }

    public RequestEntity(boolean isShowLoading, int tag) {
        this.isShowLoading = isShowLoading;
        this.tag = tag;
    }
}
