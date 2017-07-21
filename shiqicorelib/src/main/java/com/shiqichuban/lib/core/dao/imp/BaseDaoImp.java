package com.shiqichuban.lib.core.dao.imp;/**
 * Created by shiqichuban on 17/4/14.
 */

import android.app.Activity;
import android.support.v4.util.LruCache;

import com.shiqichuban.lib.core.dao.ICallable;
import com.shiqichuban.lib.core.dao.IDao;
import com.shiqichuban.lib.core.entity.BaseResultEntity;
import com.shiqichuban.lib.core.entity.RequestEntity;
import com.shiqichuban.lib.core.entity.ResultEntity;
import com.shiqichuban.lib.core.http.Api;
import com.shiqichuban.lib.core.http.ApiParams;
import com.shiqichuban.lib.core.http.BaseApi;
import com.shiqichuban.lib.core.http.HttpManager;
import com.shiqichuban.lib.core.http.IBaseApi;
import com.trello.rxlifecycle.LifecycleProvider;

import java.lang.ref.SoftReference;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-14
 * Time: 18:49
 * Company: 拾柒网络
 * description:
 */
public abstract class BaseDaoImp implements IDao {

    private LifecycleProvider lifecycleProvider;
    private ICallable iCallable;
    protected HttpManager httpManager;
    protected Api api;
    protected Activity mActivity;


    public BaseDaoImp(LifecycleProvider lifecycleProvider, ICallable iCallable) {
        setLifecycleProvider(lifecycleProvider);
        setiCallable(iCallable);

        if(lifecycleProvider!=null && lifecycleProvider instanceof Activity){
            mActivity=((Activity)lifecycleProvider);
        }

        httpManager=HttpManager.getInstance();

        Retrofit retrofit= httpManager.getRetrofit();
        ApiParams iBaseApi=  retrofit.create(ApiParams.class);
         api=new Api(iBaseApi);
    }

    public Activity getActivity() {
        return mActivity;
    }

    @Override
    public ResultEntity call(ResultEntity resultEntity) {
        return resultEntity;
    }

    public LifecycleProvider getLifecycleProvider() {
        return lifecycleProvider;
    }

    public void setLifecycleProvider(LifecycleProvider lifecycleProvider) {
        this.lifecycleProvider = lifecycleProvider;
    }

    public ICallable getiCallable() {
        return iCallable;
    }

    public void setiCallable(ICallable iCallable) {
        this.iCallable = iCallable;
    }


    public  <T> void request(Observable observable, RequestEntity requestEntity){
        httpManager.doHttpDeal(this,observable,requestEntity);
    }

}
