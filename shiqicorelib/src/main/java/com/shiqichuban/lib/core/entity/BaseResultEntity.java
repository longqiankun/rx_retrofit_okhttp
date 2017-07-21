package com.shiqichuban.lib.core.entity;/**
 * Created by shiqichuban on 17/4/14.
 */

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-14
 * Time: 18:27
 * Company: 拾柒网络
 * description:
 */
public class BaseResultEntity<T> extends DataSupport{
    @Column(ignore = true)
    //错误码

    public int err_code=-1;
    @Column(ignore = true)
    //错误消息
    public String err_msg;
    @Column(ignore = true)
   // 真实数据
    protected T data;

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "BaseResultEntity{" +
                "err_code=" + err_code +
                ", err_msg='" + err_msg + '\'' +
                ", data=" + data +
                '}';
    }
}
