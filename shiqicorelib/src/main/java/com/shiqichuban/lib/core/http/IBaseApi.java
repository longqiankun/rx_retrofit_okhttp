package com.shiqichuban.lib.core.http;/**
 * Created by shiqichuban on 17/4/14.
 */

import com.shiqichuban.lib.core.entity.AppVersion;
import com.shiqichuban.lib.core.entity.ResultEntity;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-14
 * Time: 18:17
 * Company: 拾柒网络
 * description:
 */
public interface IBaseApi {
    @GET
    Object get(@Url String url, @QueryMap Map<String, String> params);

    @POST
    <T>  Observable<ResultEntity<T>> post(@Url String url, @QueryMap Map<String, String> params);

    @POST
    <T>  Observable<ResultEntity<T>> json(@Url String url, @Body RequestBody requestBody);

    @Streaming/*大文件需要加入这个判断，防止下载过程中写入到内存中*/
    @GET
    <T>  Observable<ResultEntity<T>> download(@Url String url,@Header("RANGE") String start);

    @Multipart
    @POST
    <T>  Observable<ResultEntity<T>> upload(@Url String url, @FieldMap Map<String,String> params,@Part MultipartBody.Part file);

}
