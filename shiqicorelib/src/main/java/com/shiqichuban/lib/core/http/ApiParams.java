package com.shiqichuban.lib.core.http;/**
 * Created by shiqichuban on 17/4/15.
 */

import com.shiqichuban.lib.core.entity.AppVersion;
import com.shiqichuban.lib.core.entity.Proflie;
import com.shiqichuban.lib.core.entity.ResultEntity;
import com.shiqichuban.lib.core.utils.SConstantUtils;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-15
 * Time: 15:15
 * Company: 拾柒网络
 * description:
 */
public interface ApiParams {

    @GET
    Observable<AppVersion>  checkVersion(@Url String url);

    @POST
    Observable<ResultEntity> login(@Url String url, @QueryMap Map<String, String> params);

    @GET
    Observable<Proflie>  getProfile(@Url String url);

}
