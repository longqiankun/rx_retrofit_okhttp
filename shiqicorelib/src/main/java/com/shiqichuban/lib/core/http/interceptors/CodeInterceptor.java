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
public class CodeInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Response response=null;
        Response.Builder builder= null ;
        try {
             response = chain.proceed(request);
            if(!response.isSuccessful()){

            }
            builder=  response.newBuilder();

        }catch (Throwable throwable){
//            response.
        }

        return response;
    }
}
