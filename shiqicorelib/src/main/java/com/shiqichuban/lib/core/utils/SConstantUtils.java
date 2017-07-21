package com.shiqichuban.lib.core.utils;

import android.os.Environment;

import com.lqk.framework.util.Handler_System;

/**
 * Created by wangjian on 16/2/26.
 */
public class SConstantUtils {
    //    服务器地址
    public final static String UCHUBAN = "uchuban";
    public final static String SHIQICHUBAN = "shiqichuban";
    public  static String DOMAINNAME = SHIQICHUBAN;

    // 服务器地址
    public  static String DOMAIN;
    //服务器地址
    public  static String SERVERURL;
    public  static String DOMAINAPI;
    public  static String  DomainSocial;
    public  static String  PICSERVER;

    static {
        String currentDomin=DOMAINNAME;
        if(LG.isDebug) {
            String defaultDomin=DOMAINNAME;
            try{
                defaultDomin= Handler_System.getMetaDataValue("defaultDomin", DOMAINNAME);
        }catch (Exception e){e.printStackTrace();}
            currentDomin = (String) SPUtils.get(AppHelper.getContext(), SPConstants.DEBUGDOMAIN,defaultDomin);

        }
        updateEnvriment(currentDomin);
    }

    public static void updateEnvriment(String envName){
        DOMAINNAME=envName;
        DOMAIN = "https://www." + DOMAINNAME + ".com";
        SERVERURL = "https://api." + DOMAINNAME + ".com/v1";
        DOMAINAPI = "https://api." + DOMAINNAME + ".com";
        DomainSocial="https://"+(DOMAINNAME.equals(SHIQICHUBAN)?"":"stage-")+"social.shiqichuban.com";
        PICSERVER="https://"+(DOMAINNAME.equals(SHIQICHUBAN)?"":"stage-")+"res.shiqichuban.com";
    }


}
