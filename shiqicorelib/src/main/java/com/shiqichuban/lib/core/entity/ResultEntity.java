package com.shiqichuban.lib.core.entity;/**
 * Created by shiqichuban on 17/4/14.
 */

import org.litepal.annotation.Column;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-14
 * Time: 18:33
 * Company: 拾柒网络
 * description:
 */
public class ResultEntity<T> extends BaseResultEntity<T>{
    @Column(ignore = true)
    //请求码
    public int request_code;
    @Column(ignore = true)
    //结果码
    public int result_code;

    @Column(ignore = true)
   public RequestEntity requestEntity;

}
