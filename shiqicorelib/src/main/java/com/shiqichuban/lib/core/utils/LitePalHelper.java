package com.shiqichuban.lib.core.utils;/**
 * Created by shiqichuban on 16/12/8.
 */

import android.content.Context;
import android.os.Environment;
import android.provider.ContactsContract;

import com.lqk.framework.util.ExceptionHandler;
import com.lqk.framework.util.FileUtils;
import com.lqk.framework.util.SdCardUtils;
import com.shiqichuban.lib.core.entity.Article;
import com.shiqichuban.lib.core.entity.BookShelf;
import com.shiqichuban.lib.core.entity.LogDetail;
import com.shiqichuban.lib.core.entity.LogURL;
import com.shiqichuban.lib.core.entity.MediaRecord;
import com.shiqichuban.lib.core.entity.Proflie;

import org.litepal.LitePal;
import org.litepal.LitePalDB;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2016-12-08
 * Time: 14:31
 * Company: 拾柒网络
 * description:
 */
public class LitePalHelper {
    //数据库版本
    public static final int DBVersion=18;
    static Context mContext;
    /**初始化*/
    public static void initialize(Context context){
        mContext=context;
        LitePal.initialize(context);
    }
    public static void changeDB(){
        String dbName=(String)SPUtils.get(mContext, SPConstants.DBNAME,"shiqichuban");
        if(!dbName.endsWith(".db"))dbName=dbName+".db";
        try {
            LitePalDB litePalDB = new LitePalDB(SdCardUtils.getFilePath(mContext, dbName), DBVersion);
            litePalDB.addClassName(Proflie.class.getName());
            litePalDB.addClassName(Article.class.getName());
            litePalDB.addClassName(BookShelf.class.getName());
            litePalDB.addClassName(MediaRecord.class.getName());
            litePalDB.addClassName(LogURL.class.getName());
            litePalDB.addClassName(LogDetail.class.getName());
            LitePal.use(litePalDB);
        }catch (Exception e){e.printStackTrace();}
    }
}
