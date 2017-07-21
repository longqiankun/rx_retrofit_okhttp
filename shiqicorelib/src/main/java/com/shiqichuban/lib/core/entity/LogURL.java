package com.shiqichuban.lib.core.entity;/**
 * Created by shiqichuban on 17/3/23.
 */

import org.litepal.crud.DataSupport;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-03-23
 * Time: 17:34
 * Company: 拾柒网络
 * description:
 */
public class LogURL extends DataSupport {
    public  int id;
    public  String url="";
    public  String time="";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
