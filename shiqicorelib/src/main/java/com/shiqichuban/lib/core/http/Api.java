package com.shiqichuban.lib.core.http;/**
 * Created by shiqichuban on 17/4/15.
 */

import android.text.TextUtils;

import com.lqk.framework.util.Handler_System;
import com.shiqichuban.lib.core.entity.AppVersion;
import com.shiqichuban.lib.core.entity.Proflie;
import com.shiqichuban.lib.core.entity.ResultEntity;
import com.shiqichuban.lib.core.utils.AppHelper;
import com.shiqichuban.lib.core.utils.SConstantUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;
import rx.Subscriber;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-15
 * Time: 15:15
 * Company: 拾柒网络
 * description:
 */
public class Api {
    private ApiParams baseApi;

    public Api(ApiParams baseApi) {
        this.baseApi = baseApi;
    }

   public Observable<AppVersion>  checkVersion(){
       return baseApi.checkVersion(SConstantUtils.SERVERURL+"/app/version?platform=android");
   }


   public Observable<ResultEntity> login(String account, String password, String openID, String accessToken, String code, String uid){
        Map<String, String> params = new HashMap<>();
        String type = "0";
        if (!TextUtils.isEmpty(account)) {
            if (account.contains("@")) {
                params.put("email", account);
                type = "0";
            } else {
                params.put("mobile", account);
                type = "1";
            }
            params.put("password", password);
        }
        if (!TextUtils.isEmpty(openID)) {
            type = "4";
            params.put("openid", openID);
            params.put("access_token", accessToken);
        }
        if (!TextUtils.isEmpty(code)) {
            type = "2";
            params.put("code", code);
        }
        if (!TextUtils.isEmpty(uid)) {
            type = "3";
            params.put("uid", uid);
            params.put("access_token", accessToken);
        }
        params.put("type", type);
        params.put("device_id", Handler_System.getDeviceId(AppHelper.getContext()));
        params.put("device_type", "android");
        params.put("version", Handler_System.getAppVersionNumber());
        params.put("app_Id", AppHelper.getContext().getPackageName());
        return baseApi.login(SConstantUtils.SERVERURL + "/user/login",params);
    };

   public Observable<Proflie>  getProfile(){
        return baseApi.getProfile(SConstantUtils.SERVERURL + "/user/profile");
    };
}
