package com.shiqichuban.lib.core.entity;/**
 * Created by shiqichuban on 17/3/23.
 */

import org.litepal.crud.DataSupport;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-03-23
 * Time: 17:37
 * Company: 拾柒网络
 * description:
 */
public class LogDetail extends DataSupport {
    public   int id;
    public   int urlId;
    public   String url="";
    public    String params="";
    public    String result="";
    public    String time="";
    public    String crashMsg="";

    public String getCrashMsg() {
        return crashMsg;
    }

    public void setCrashMsg(String crashMsg) {
        this.crashMsg = crashMsg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
