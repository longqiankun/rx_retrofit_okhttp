package com.shiqichuban.lib.core.http;/**
 * Created by shiqichuban on 17/4/15.
 */

import com.shiqichuban.lib.core.entity.ResultEntity;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-15
 * Time: 12:42
 * Company: 拾柒网络
 * description:
 */
public class BaseApi {
   private IBaseApi iBaseApi;

    public BaseApi(IBaseApi iBaseApi) {
        this.iBaseApi = iBaseApi;
    }

  Object get(String url){
        return iBaseApi.get(url,new HashMap<String, String>());
    }

   Object get(String url, Map<String, String> params){
       return iBaseApi.get(url,params);
    }

    <T> Observable<ResultEntity<T>> post(String url,  Map<String, String> params){
        return iBaseApi.post(url,params);
    }

    <T> Observable<ResultEntity<T>>json(String url, String json){
        RequestBody requestBody=    RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json);
        return iBaseApi.json(url,requestBody);
    };

    <T> Observable<ResultEntity<T>> download(String url,String start){
        return iBaseApi.download(url,"bytes=" + start + "-");
    };


    <T> Observable<ResultEntity<T>> upload(String url,Map<String,String> params,MultipartBody.Part files){
        return iBaseApi.upload(url,params,files);
    };

}
