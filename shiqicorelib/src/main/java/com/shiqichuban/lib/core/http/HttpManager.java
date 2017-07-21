package com.shiqichuban.lib.core.http;

import com.shiqichuban.lib.core.dao.imp.BaseDaoImp;
import com.shiqichuban.lib.core.entity.AppVersion;
import com.shiqichuban.lib.core.entity.RequestEntity;
import com.shiqichuban.lib.core.entity.ResultEntity;
import com.shiqichuban.lib.core.http.converter.CustomConverterFactory;
import com.shiqichuban.lib.core.http.exception.RetryWhenNetworkException;
import com.shiqichuban.lib.core.http.interceptors.HeaderInterceptor;
import com.shiqichuban.lib.core.http.interceptors.LoggingInterceptor;
import com.shiqichuban.lib.core.http.subscribers.ProgressSubscriber;
import com.shiqichuban.lib.core.utils.LG;
import com.shiqichuban.lib.core.utils.SConstantUtils;
import com.trello.rxlifecycle.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * http交互处理类
 * Created by WZG on 2016/7/16.
 */
public class HttpManager {
    private volatile static HttpManager INSTANCE;

    //构造方法私有
    private HttpManager() {
        setRetrofit();
    }

    //获取单例
    public static HttpManager getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpManager();
                }
            }
        }
        return INSTANCE;
    }

    private Retrofit retrofit;

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HeaderInterceptor());
        builder.addInterceptor(new LoggingInterceptor());
        builder.retryOnConnectionFailure(true);

        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.writeTimeout(60*10, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);

        /*创建retrofit对象*/
         retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                 .baseUrl(SConstantUtils.DOMAINAPI)
                .build();
    }

    /**
     * 处理http请求

     */
    public <T> void doHttpDeal(BaseDaoImp baseDaoImp, Observable<ResultEntity<T>> observables, RequestEntity requestEntity) {
        /*rx处理*/
        ProgressSubscriber subscriber = new ProgressSubscriber(baseDaoImp,requestEntity);
        Observable<RequestEntity> observable = observables
                /*失败后的retry配置*/
                .retryWhen(new RetryWhenNetworkException())
                /*生命周期管理*/
//                .compose(basePar.getRxAppCompatActivity().bindToLifecycle())
                .compose(baseDaoImp.getLifecycleProvider().bindUntilEvent(ActivityEvent.DESTROY))
                /*http请求线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                /*回调线程*/
                .observeOn(AndroidSchedulers.mainThread())
                /*结果判断*/
                .map(baseDaoImp);

        /*数据回调*/
        observable.subscribe(subscriber);
    }
}
