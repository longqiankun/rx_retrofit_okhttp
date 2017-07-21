package com.shiqichuban.lib.core.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
* @author :longqiankun
* @email :longqiankun@shiqichuban.com
* @time :2016/3/8  12:25
* @description :
*/
public class BookShelf extends DataSupport implements Parcelable {
    /**图书编号*/
    public int book_id;
    /**图书缩略图*/
    public String thumbnail;
    /**图书总页数*/
    public int page_count;
    public String price;
    public float ebook_price;
    public long number = 1;
    /**书名*/
    public String title;
    public String author;
    public String cover;
    public String edited;
    public String content_theme_type;
    public String read_cnt;
    public boolean ebook_download;
    public String book_tips;
    public String ebook_tips;
    public String updated_at;
    public String is_share;
    public String size_verified;
    public String  type;
    public String permit_edit;          // 0为不允许编辑，1为允许编辑
    public String edit_state;          // 0为不允许编辑，1为允许编辑
    public String audit_state;        // 0为免审核，1为需要审核
    public String audit_article_count; // 待审核的文章数
    public String invite_url;      // 邀请url
    public String invite_msg;      // 邀请说明文案
    public String unread_count;
    public String role;
    public String invite_state;
    public String platform;
    public int    width;
    public int height;
    public String  size_id;
    public String  is_default;
    public String  author_count;
    public String  article_count;
    public String  create_time;
    public String  cur_user;
    public String  bg_url;

    public String getBg_url() {
        return bg_url;
    }

    public void setBg_url(String bg_url) {
        this.bg_url = bg_url;
    }

    public String getCur_user() {
        return cur_user;
    }

    public void setCur_user(String cur_user) {
        this.cur_user = cur_user;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getAuthor_count() {
        return author_count;
    }

    public void setAuthor_count(String author_count) {
        this.author_count = author_count;
    }

    public String getArticle_count() {
        return article_count;
    }

    public void setArticle_count(String article_count) {
        this.article_count = article_count;
    }

    public String getPermit_edit() {
        return permit_edit;
    }

    public void setPermit_edit(String permit_edit) {
        this.permit_edit = permit_edit;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isEbook_download() {
        return ebook_download;
    }

    public void setEbook_download(boolean ebook_download) {
        this.ebook_download = ebook_download;
    }

    public String getBook_tips() {
        return book_tips;
    }

    public void setBook_tips(String book_tips) {
        this.book_tips = book_tips;
    }

    public String getEbook_tips() {
        return ebook_tips;
    }

    public void setEbook_tips(String ebook_tips) {
        this.ebook_tips = ebook_tips;
    }

    public String getIs_share() {
        return is_share;
    }

    public void setIs_share(String is_share) {
        this.is_share = is_share;
    }

    public String getAudit_state() {
        return audit_state;
    }

    public void setAudit_state(String audit_state) {
        this.audit_state = audit_state;
    }

    public String getInvite_url() {
        return invite_url;
    }

    public void setInvite_url(String invite_url) {
        this.invite_url = invite_url;
    }

    public String getInvite_msg() {
        return invite_msg;
    }

    public void setInvite_msg(String invite_msg) {
        this.invite_msg = invite_msg;
    }

    public String getAudit_article_count() {
        return audit_article_count;
    }

    public void setAudit_article_count(String audit_article_count) {
        this.audit_article_count = audit_article_count;
    }

    public String getInvite_state() {
        return invite_state;
    }

    public void setInvite_state(String invite_state) {
        this.invite_state = invite_state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUnread_count() {
        return unread_count;
    }

    public void setUnread_count(String unread_count) {
        this.unread_count = unread_count;
    }

    public String getEdit_state() {
        return edit_state;
    }

    public void setEdit_state(String edit_state) {
        this.edit_state = edit_state;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }


    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

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

    public String getSize_id() {
        return size_id;
    }

    public void setSize_id(String size_id) {
        this.size_id = size_id;
    }

    public String getSize_verified() {
        return size_verified;
    }

    public void setSize_verified(String size_verified) {
        this.size_verified = size_verified;
    }

    public float getEbook_price() {
        return ebook_price;
    }

    public void setEbook_price(float ebook_price) {
        this.ebook_price = ebook_price;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getRead_cnt() {
        return read_cnt;
    }

    public void setRead_cnt(String read_cnt) {
        this.read_cnt = read_cnt;
    }

    public String getContent_theme_type() {
        return content_theme_type;
    }

    public void setContent_theme_type(String content_theme_type) {
        this.content_theme_type = content_theme_type;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPage_count() {
        return page_count;
    }

    public void setPage_count(int page_count) {
        this.page_count = page_count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.book_id);
        dest.writeString(this.thumbnail);
        dest.writeInt(this.page_count);
        dest.writeString(this.price);
        dest.writeFloat(this.ebook_price);
        dest.writeLong(this.number);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.cover);
        dest.writeString(this.edited);
        dest.writeString(this.content_theme_type);
        dest.writeString(this.read_cnt);
        dest.writeString(this.book_tips);
        dest.writeString(this.ebook_tips);
        dest.writeString(this.updated_at);
        dest.writeString(this.is_share);
        dest.writeString(this.type);
        dest.writeString(this.unread_count);
        dest.writeString(this.edit_state);
        dest.writeString(this.invite_msg);
        dest.writeString(this.invite_url);
        dest.writeString(this.audit_article_count);
        dest.writeString(this.audit_state);
        dest.writeString(this.role);
        dest.writeString(this.invite_state);
        dest.writeString(this.platform);
        dest.writeInt(this.width);
        dest.writeInt(this.height);
        dest.writeString(this.size_id);
        dest.writeString(this.is_default);
        dest.writeString(this.permit_edit);
        dest.writeString(this.size_verified);
        dest.writeString(this.author_count);
        dest.writeString(this.article_count);
        dest.writeString(this.create_time);
        dest.writeString(this.cur_user);
        dest.writeString(this.bg_url);
    }

    public BookShelf() {
    }

    protected BookShelf(Parcel in) {
        this.book_id = in.readInt();
        this.thumbnail = in.readString();
        this.page_count = in.readInt();
        this.price = in.readString();
        this.ebook_price = in.readFloat();
        this.number = in.readLong();
        this.title = in.readString();
        this.author = in.readString();
        this.cover = in.readString();
        this.edited = in.readString();
        this.content_theme_type = in.readString();
        this.read_cnt = in.readString();
        this.book_tips = in.readString();
        this.ebook_tips = in.readString();
        this.updated_at = in.readString();
        this.is_share = in.readString();
        this.type = in.readString();
        this.unread_count = in.readString();
        this.edit_state = in.readString();
        this.invite_msg = in.readString();
        this.invite_url = in.readString();
        this.audit_article_count = in.readString();
        this.audit_state = in.readString();
        this.role = in.readString();
        this.invite_state = in.readString();
        this.platform = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.size_id = in.readString();
        this.is_share = in.readString();
        this.permit_edit = in.readString();
        this.size_verified = in.readString();
        this.author_count=in.readString();
        this.article_count=in.readString();
        this.create_time = in.readString();
        this.cur_user = in.readString();
        this.bg_url = in.readString();
    }

    public static final Creator<BookShelf> CREATOR = new Creator<BookShelf>() {
        @Override
        public BookShelf createFromParcel(Parcel source) {
            return new BookShelf(source);
        }

        @Override
        public BookShelf[] newArray(int size) {
            return new BookShelf[size];
        }
    };
}
