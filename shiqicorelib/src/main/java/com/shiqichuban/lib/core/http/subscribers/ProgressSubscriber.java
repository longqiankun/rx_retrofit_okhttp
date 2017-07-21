package com.shiqichuban.lib.core.http.subscribers;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.util.Log;

import com.lqk.framework.util.JSONUtils;
import com.lqk.framework.util.StringUtils;
import com.shiqichuban.lib.core.dao.ICallable;
import com.shiqichuban.lib.core.dao.imp.BaseDaoImp;
import com.shiqichuban.lib.core.entity.RequestEntity;
import com.shiqichuban.lib.core.entity.ResultEntity;
import com.shiqichuban.lib.core.other.BaseProgress;
import com.shiqichuban.lib.core.utils.AppHelper;
import com.shiqichuban.lib.core.utils.LG;
import com.shiqichuban.lib.core.utils.StatusCode;
import com.trello.rxlifecycle.LifecycleProvider;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.net.UnknownHostException;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * 用于在Http请求开始时，自动显示一个ProgressDialog
 * 在Http请求结束是，关闭ProgressDialog
 * 调用者自己对请求数据进行处理
 * Created by WZG on 2016/7/16.
 */
public class ProgressSubscriber<T> extends Subscriber<ResultEntity<T>> {
    //    是否弹框
    private boolean showPorgress = true;
    // 软引用回调接口
    private ICallable mLcallable;
    // 软引用反正内存泄露
    private LifecycleProvider mLifecycle;
    //加载框可自己定义
    private Dialog pd;
    // 请求数据
    private BaseDaoImp api;

    private RequestEntity requestEntity;

    private ResultEntity resultEntity;

    private int tag;

    /**
     * 构造
     *
     * @param api
     */

    public ProgressSubscriber(BaseDaoImp api, RequestEntity requestEntity) {
        this.api = api;

        this.mLcallable = api.getiCallable();
        this.mLifecycle = api.getLifecycleProvider();

        this.requestEntity = requestEntity;
        if (requestEntity != null) {
            showPorgress = requestEntity.isShowLoading;
            tag = requestEntity.tag;
        }

        setShowPorgress(showPorgress);
        if (showPorgress) {
            initProgressDialog(requestEntity!=null?requestEntity.isCancle:true);
        }
    }


    /**
     * 初始化加载框
     */
    private void initProgressDialog(boolean cancel) {
        Activity context = api.getActivity();
        if (pd == null && context != null) {
            pd=AppHelper.getmIProgress().getDialog(context);
            if(pd ==null){
                pd = new ProgressDialog(context);
            }
            pd.setCancelable(cancel);
            if (cancel) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        if (mLcallable != null) {
                            mLcallable.onCancel(tag);
                        }
                        onCancelProgress();
                    }
                });
            }
        }
    }


    /* *
      * 显示加载框
      */
    private void showProgressDialog() {
        if (!isShowPorgress()) return;
        Context context = AppHelper.getContext();
        if (pd == null || context == null) return;
        if (!pd.isShowing()) {
            if(pd instanceof BaseProgress){
                ((BaseProgress)pd).showDialog(requestEntity!=null&&!StringUtils.isEmpty(requestEntity.progressText)?requestEntity.progressText:"");
            }else {
                pd.show();
            }

        }
    }


   /* *
     * 隐藏*/

    private void dismissProgressDialog() {
        if (!isShowPorgress()) return;
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }


    /* *
      * 订阅开始时调用
      * 显示ProgressDialog
      */
    @Override
    public void onStart() {
        showProgressDialog();
        if (mLcallable!= null) {
            mLcallable.onStart(tag);
        }
    }

    /**
     * 完成，隐藏ProgressDialog
     */
    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    /**
     * 对错误进行统一处理
     * 隐藏ProgressDialog
     *
     * @param e
     */

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        // 需要緩存并且本地有缓存才返回
        if (mLcallable != null) {
            if (resultEntity == null) {
                resultEntity = new ResultEntity();
            }
            if (e instanceof HttpException) {
                HttpException httpException = ((HttpException) e);
                retrofit2.Response response = httpException.response();
                resultEntity.err_code = response.code();
                if (response.body() != null) {
                    String err_msg = "";
                    ResponseBody body = response.errorBody();
                    if (body != null) {
                        try {
                            String bodyResult = body.string();
                            if (JSONUtils.getJSONType(bodyResult) == JSONUtils.JSON_TYPE.JSON_TYPE_OBJECT) {
                                JSONObject jsonObject = new JSONObject(bodyResult);
                                err_msg = jsonObject.optString("err_msg");
                            }
                        } catch (IOException e1) {

                        } catch (JSONException jsonE) {

                        }
                    }
                    if (StringUtils.isEmpty(err_msg)) {
                        resultEntity.err_msg = AppHelper.getContext().getString(StatusCode.getStatus(resultEntity.err_code));
                    }
                }
            } else if (e instanceof UnknownHostException) {
                resultEntity.err_code = StatusCode.CODE1002;
                resultEntity.err_msg = AppHelper.getContext().getString(StatusCode.getStatus(resultEntity.err_code));
            }
            resultEntity.request_code = tag;
            resultEntity.requestEntity = requestEntity;
            mLcallable.onFail(resultEntity);
        }
        e.printStackTrace();
    }


    /* *
      * 将onNext方法中的返回结果交给Activity或Fragment自己处理
      *
      * @param t 创建Subscriber时的泛型类型
      */
    @Override
    public void onNext(com.shiqichuban.lib.core.entity.ResultEntity<T> t) {
        resultEntity = t;
        if (resultEntity != null) {
            resultEntity.requestEntity = requestEntity;
            resultEntity.request_code = tag;
        }
        if (mLcallable != null) {
            mLcallable.onSuccess(t);
        }
    }

    /* *
      * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
      */
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }


    public boolean isShowPorgress() {
        return showPorgress;
    }

   /* *
     * 是否需要弹框设置
     *
     * @param showPorgress*/

    public void setShowPorgress(boolean showPorgress) {
        this.showPorgress = showPorgress;
    }
}