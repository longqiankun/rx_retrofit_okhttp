package com.shiqichuban.lib.core.entity;

/**
 * @author :longqiankun
 * @email :longqiankun@shiqichuban.com
 * @company : Shiqi Network
 * @time :2016/9/27  18:34
 * @description :
 */

public class AppVersion extends BaseEntity{
    public String version;
    public String latest_version;
    public String force_upgrade;
    public String url;
    public String upgrade_desc;

    @Override
    public String toString() {
        return "AppVersion{" +
                "version='" + version + '\'' +
                ", latest_version='" + latest_version + '\'' +
                ", force_upgrade='" + force_upgrade + '\'' +
                ", url='" + url + '\'' +
                ", upgrade_desc='" + upgrade_desc + '\'' +
                '}';
    }
}
