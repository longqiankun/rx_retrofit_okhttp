package com.shiqichuban.lib.core.entity;/**
 * Created by shiqichuban on 17/4/14.
 */

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * name: longqiankun
 * email: longqiankun@shiqichuban.com
 * Date: 2017-04-14
 * Time: 18:51
 * Company: 拾柒网络
 * description:
 */
public class Proflie extends BaseEntity implements Parcelable{

    private String uid;
    private String nick;
    private String mobile;
    private String email;
    private int articles;
    private int words;
    private String avatar;
    private int books;
    private int total_read_cnt;
    private int score;
    private List<String> tags=new ArrayList<>();
    private String portal_bg;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotal_read_cnt() {
        return total_read_cnt;
    }

    public void setTotal_read_cnt(int total_read_cnt) {
        this.total_read_cnt = total_read_cnt;
    }

    public String getPortal_bg() {
        return portal_bg;
    }

    public void setPortal_bg(String portal_bg) {
        this.portal_bg = portal_bg;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getArticles() {
        return articles;
    }

    public void setArticles(int articles) {
        this.articles = articles;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getBooks() {
        return books;
    }

    public void setBooks(int books) {
        this.books = books;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.uid);
        dest.writeString(this.nick);
        dest.writeString(this.mobile);
        dest.writeString(this.email);
        dest.writeInt(this.articles);
        dest.writeInt(this.words);
        dest.writeString(this.avatar);
        dest.writeInt(this.books);
        dest.writeInt(this.err_code);
        dest.writeString(this.err_msg);
        dest.writeStringList(this.tags);
        dest.writeInt(this.total_read_cnt);
        dest.writeInt(this.score);
    }

    public Proflie() {
    }

    protected Proflie(Parcel in) {
        this.uid = in.readString();
        this.nick = in.readString();
        this.mobile = in.readString();
        this.email = in.readString();
        this.articles = in.readInt();
        this.words = in.readInt();
        this.avatar = in.readString();
        this.books = in.readInt();
        this.err_code = in.readInt();
        this.err_msg = in.readString();
        this.tags = in.createStringArrayList();
        this.total_read_cnt = in.readInt();
        this.score = in.readInt();
    }

    public static final Parcelable.Creator<Proflie> CREATOR = new Parcelable.Creator<Proflie>() {
        @Override
        public Proflie createFromParcel(Parcel source) {
            return new Proflie(source);
        }

        @Override
        public Proflie[] newArray(int size) {
            return new Proflie[size];
        }
    };
    public class Score extends DataSupport implements Serializable {
        public int article;
        public int share;
        public  int order;
        public int total;

        public int getArticle() {
            return article;
        }

        public void setArticle(int article) {
            this.article = article;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    @Override
    public String toString() {
        return "Proflie{" +
                "uid='" + uid + '\'' +
                ", nick='" + nick + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", articles=" + articles +
                ", words=" + words +
                ", avatar='" + avatar + '\'' +
                ", books=" + books +
                ", total_read_cnt=" + total_read_cnt +
                ", score=" + score +
                ", tags=" + tags +
                ", portal_bg='" + portal_bg + '\'' +
                '}';
    }
}
