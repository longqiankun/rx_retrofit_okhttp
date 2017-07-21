package com.shiqichuban.lib.core.http.interceptors;/**
 * Created by shiqichuban on 17/4/15.
 */

import android.text.TextUtils;

import com.shiqichuban.lib.core.utils.AppHelper;
import com.shiqichuban.lib.core.utils.SPConstants;
import com.shiqichuban.lib.core.utils.SPUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-15
 * Time: 13:52
 * Company: 拾柒网络
 * description:
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request()
                .newBuilder()
                .addHeader("Authorization", (String) SPUtils.get(AppHelper.getContext(), SPConstants.TOKEN,""))
                .addHeader("Cookie", (String) SPUtils.get(AppHelper.getContext(), SPConstants.Cookie,""))
                .addHeader("User-Agent",(String) SPUtils.get(AppHelper.getContext(), SPConstants.UserAgent,""))
                .build();


        Response response= chain.proceed(request);
        List<String> cookies = response.headers("Set-Cookie");
        String token=response.header("Authorization");
        if(!TextUtils.isEmpty(token)){
            SPUtils.put(AppHelper.getContext(), SPConstants.TOKEN,token);
        }
        String Cookie = "";
        for (int i = 0; i < cookies.size(); i++) {
            Cookie += ";" + cookies.get(i);
        }
        SPUtils.put(AppHelper.getContext(), SPConstants.Cookie, Cookie);
        return response;
    }
}
