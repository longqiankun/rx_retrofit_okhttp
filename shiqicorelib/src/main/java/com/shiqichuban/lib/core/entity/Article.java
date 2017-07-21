package com.shiqichuban.lib.core.entity;

import com.lqk.framework.util.JSONUtils;

import org.json.JSONObject;
import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * 此类与ArticlesEntity类获取到的数据是一样的
 * Created by wangjian on 16/4/8.
 */
public class Article extends DataSupport implements Serializable{
    private int id;
    private int acticle_id;
    private String ctime;
    private String mtime;
    private String title;
    private String weather;
    private String abstractX;
    private String localImages;
    private String tags;
    private String content;
    private String articeContentUrlJson;
    private String change="false";
    private String read_cnt;
    private String tempContent;
    private String is_share;
    private String share_ids;
    private String word_count;
    private String bookIds;

    public String getBookIds() {
        return bookIds;
    }

    public void setBookIds(String bookIds) {
        this.bookIds = bookIds;
    }

    public String getWord_count() {
        return word_count;
    }

    public void setWord_count(String word_count) {
        this.word_count = word_count;
    }

    public String getShare_ids() {
        return share_ids;
    }

    public void setShare_ids(String share_ids) {
        this.share_ids = share_ids;
    }

    public String getIs_share() {
        return is_share;
    }

    public void setIs_share(String is_share) {
        this.is_share = is_share;
    }

    public String getTempContent() {
        return tempContent;
    }

    public void setTempContent(String tempContent) {
        this.tempContent = tempContent;
    }

    public String getRead_cnt() {
        return read_cnt;
    }

    public void setRead_cnt(String read_cnt) {
        this.read_cnt = read_cnt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article() {
    }

    public Article(int acticle_id, String ctime, String mtime, String title, String weather, String abstractX, String localImages) {
        this.acticle_id = acticle_id;
        this.ctime = ctime;
        this.mtime = mtime;
        this.title = title;
        this.weather = weather;
        this.abstractX = abstractX;
        this.localImages = localImages;
    }
    public Article(int acticle_id, String ctime, String title, String abstractX) {
        this.acticle_id = acticle_id;
        this.ctime = ctime;
        this.title = title;
        this.abstractX = abstractX;
    }

    public Article(int acticle_id, String ctime, String mtime, String title, String weather, String localImages, String tags, String content) {
        this.acticle_id = acticle_id;
        this.ctime = ctime;
        this.mtime = mtime;
        this.title = title;
        this.weather = weather;
        this.tags = tags;
        this.content = content;
    }



    public int getActicle_id() {
        return acticle_id;
    }

    public void setActicle_id(int acticle_id) {
        this.acticle_id = acticle_id;
    }

    //    public int getActicle_id() {
//        return acticle_id;
//    }
//
//    public void setActicle_id(int acticle_id) {
//        this.acticle_id = id;
//    }


    public String getLocalImages() {
        return localImages;
    }

    public void setLocalImages(String localImages) {
        this.localImages = localImages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }


    public int getId() {
        return id;
    }

    public String getCtime() {
        return ctime;
    }

    public String getMtime() {
        return mtime;
    }

    public String getTitle() {
        return title;
    }

    public String getWeather() {
        return weather;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public String getArticeContentUrlJson() {
        return articeContentUrlJson;
    }

    public void setArticeContentUrlJson(String articeContentUrlJson) {
        this.articeContentUrlJson = articeContentUrlJson;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public static Article parseArticle(String json){
 if(JSONUtils.getJSONType(json)== JSONUtils.JSON_TYPE.JSON_TYPE_OBJECT){
     try {
         JSONObject jsonObject = new JSONObject(json);
         Article articlesEntityCopy = new Article();
         articlesEntityCopy.setActicle_id(Integer.valueOf(jsonObject.optString("id")));
         articlesEntityCopy.setCtime(jsonObject.optString("ctime"));
         articlesEntityCopy.setLocalImages(jsonObject.optString("images"));
         articlesEntityCopy.setAbstractX(jsonObject.optString("abstract"));
         articlesEntityCopy.setMtime(jsonObject.optString("mtime"));
         articlesEntityCopy.setTags(jsonObject.optString("tags"));
         articlesEntityCopy.setTitle(jsonObject.optString("title"));
         articlesEntityCopy.setWeather(jsonObject.optString("weather"));
         articlesEntityCopy.setContent(jsonObject.optString("content"));
         articlesEntityCopy.setRead_cnt(jsonObject.optString("read_cnt"));
         articlesEntityCopy.setIs_share(jsonObject.optString("is_share"));
         articlesEntityCopy.setShare_ids(jsonObject.optString("share_ids"));
         articlesEntityCopy.setWord_count(jsonObject.optString("word_count"));
         articlesEntityCopy.setBookIds(jsonObject.optString("book_ids"));
         return articlesEntityCopy;
     }catch (Exception e){e.printStackTrace();}
 }
   return null;
    }
 /*   public static List<Article> parseArticles(String json){
        List<Article> articlesEntitys=new ArrayList<>();
if(new RequestStatus().isSuccess(json)){
    try {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.optJSONArray("articles");
        if(jsonArray!=null&&jsonArray.length()>0){
            for (int i=0;i<jsonArray.length();i++){
                String objStr=jsonArray.optString(i);
                Article articlesEntityCopy=parseArticle(objStr);
                if(null!=articlesEntityCopy){
                    articlesEntitys.add(articlesEntityCopy);
                }
            }
        }
    }catch (JSONException e){e.printStackTrace();}
}
        return articlesEntitys;
    }*/
}
