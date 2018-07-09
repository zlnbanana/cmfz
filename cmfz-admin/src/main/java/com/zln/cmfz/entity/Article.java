package com.zln.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhanglijiao on 2018/7/8.
 */
public class Article implements Serializable {

    private Integer articleId;
    private String articleName;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date articleTime;
    private String introduction;
    private String articlePic;
    private Integer masterID;
    private String articleStatus;

    public Article() {
        super();
    }

    public Article(Integer articleId, String articleName, Date articleTime, String introduction, String articlePic, Integer masterID, String articleStatus) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleTime = articleTime;
        this.introduction = introduction;
        this.articlePic = articlePic;
        this.masterID = masterID;
        this.articleStatus = articleStatus;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public Integer getMasterID() {
        return masterID;
    }

    public void setMasterID(Integer masterID) {
        this.masterID = masterID;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articleTime=" + articleTime +
                ", introduction='" + introduction + '\'' +
                ", articlePic='" + articlePic + '\'' +
                ", masterID=" + masterID +
                ", articleStatus='" + articleStatus + '\'' +
                '}';
    }
}

