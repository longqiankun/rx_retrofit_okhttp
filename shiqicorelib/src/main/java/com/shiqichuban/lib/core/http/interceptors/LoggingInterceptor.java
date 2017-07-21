package com.shiqichuban.lib.core.http.interceptors;

import android.text.TextUtils;
import android.util.Log;

import com.shiqichuban.lib.core.entity.LogDetail;
import com.shiqichuban.lib.core.entity.LogURL;
import com.shiqichuban.lib.core.utils.JsonFormat;
import com.shiqichuban.lib.core.utils.LG;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoggingInterceptor implements Interceptor {

    public static final String TAG = "NetWorkLogger";

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        String bodyString = responseBody.string();
        MediaType contentType = responseBody.contentType();
        if (LG.isDebug) {
            Map<String, String> params = new HashMap<>();
            RequestBody body = request.body();
            if (body != null && body instanceof FormBody) {
                FormBody formBody = ((FormBody) body);
                if (formBody != null) {
                    for (int i = 0; i < formBody.size(); i++) {
                        params.put(formBody.name(i), formBody.value(i));
                    }
                }
            }
            saveRequetLog(request.url().url().toString(), params, bodyString, "");
        }
        return response.newBuilder().body(ResponseBody.create(contentType, bodyString)).build();
    }


    //保存Log
    private void saveRequetLog(String url, Map<String, String> params, String result, String crashMsg) {
        if (!LG.isDebug) return;
        StringBuffer param = new StringBuffer();
        if (!TextUtils.isEmpty(url) && url.contains("?")) {
            param.append(url.substring(url.indexOf("?"), url.length()));
            url = url.substring(0, url.indexOf("?"));
        }
        String time = com.lqk.framework.util.DateUtil.currentDatetime();
        LogURL logURL = new LogURL();
        logURL.setUrl(url);
        logURL.setTime(time);
        if (!logURL.saveIfNotExist("url = ?", logURL.getUrl())) {
            DataSupport.deleteAll(LogURL.class, "url = ?", logURL.getUrl());
            logURL.save();
        }


        if (params != null) {
            if (params.size() > 0) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    param.append("key = " + entry.getKey() + " --- value = " + JsonFormat.iJsonFormat(entry.getValue()) + "\n");
                }
            }
        }
        LogDetail logDetail = new LogDetail();
        logDetail.setTime(time);
        logDetail.setUrl(url);
        logDetail.setCrashMsg(crashMsg);
        logDetail.setParams(param.toString());
        logDetail.setResult(JsonFormat.iJsonFormat(result));
        logDetail.save();

        LG.e("Http", "url=" + url);
        LG.e("Http", "params=" + param.toString());
        LG.e("Http", "result=" + result);
        DataSupport.deleteAll(LogURL.class, "time < ?", com.lqk.framework.util.DateUtil.getbeforeday(com.lqk.framework.util.DateUtil.currentDatetime()));
        DataSupport.deleteAll(LogDetail.class, "time < ?", com.lqk.framework.util.DateUtil.getbeforeday(com.lqk.framework.util.DateUtil.currentDatetime()));
    }
}