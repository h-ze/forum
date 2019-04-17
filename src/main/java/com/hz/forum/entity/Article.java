package com.hz.forum.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 11022 on 2019/3/4 0004.
 */
public class Article implements Serializable {
    private String articleId;
    private String articleName;
    private String articleAuthor;
    @JSONField(format = "yyyy-MM-dd")
    private Date articleDate;

    public Article() {
    }

    public Article(String articleId, String articleName, String articleAuthor, Date articleDate) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleAuthor = articleAuthor;
        this.articleDate = articleDate;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleDate=" + articleDate +
                '}';
    }
}
