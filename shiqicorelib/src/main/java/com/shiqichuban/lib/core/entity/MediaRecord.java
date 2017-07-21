package com.shiqichuban.lib.core.entity;/**
 * Created by shiqichuban on 17/1/11.
 */

import org.litepal.crud.DataSupport;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-01-11
 * Time: 16:35
 * Company: 拾柒网络
 * description:
 */
public class MediaRecord extends DataSupport {
    public static final String TEXT="1";
    public static final String PIC="2";
    public static final String AUDIO="3";
    public static final String VIDEO="4";
    public static final String BOOTRUE="true";
    public static final String BOOFALSE="false";
    public String unique_id;
    public String ctime;
    public String showPath;
    public String localPath;
    public String remotePath;
    public String type;
    public String uploadProgress="0";
    public String isUpload;
    public int width;
    public int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getShowPath() {
        return showPath;
    }

    public void setShowPath(String showPath) {
        this.showPath = showPath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public String getRemotePath() {
        return remotePath;
    }

    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUploadProgress() {
        return uploadProgress;
    }

    public void setUploadProgress(String uploadProgress) {
        this.uploadProgress = uploadProgress;
    }

    public String getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload;
    }
}
