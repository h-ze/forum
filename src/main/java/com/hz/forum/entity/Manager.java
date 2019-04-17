package com.hz.forum.entity;

import java.io.Serializable;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
public class Manager implements Serializable{
    private String forumId;
    private String forumName;
    private String forumPassword;
    private String forumSalt;
    private String forumStatus;

    public Manager() {
    }

    public Manager(String forumId, String forumName, String forumPassword, String forumSalt, String forumStatus) {
        this.forumId = forumId;
        this.forumName = forumName;
        this.forumPassword = forumPassword;
        this.forumSalt = forumSalt;
        this.forumStatus = forumStatus;
    }

    public String getForumId() {
        return forumId;
    }

    public void setForumId(String forumId) {
        this.forumId = forumId;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getForumPassword() {
        return forumPassword;
    }

    public void setForumPassword(String forumPassword) {
        this.forumPassword = forumPassword;
    }

    public String getForumSalt() {
        return forumSalt;
    }

    public void setForumSalt(String forumSalt) {
        this.forumSalt = forumSalt;
    }

    public String getForumStatus() {
        return forumStatus;
    }

    public void setForumStatus(String forumStatus) {
        this.forumStatus = forumStatus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "forumId='" + forumId + '\'' +
                ", forumName='" + forumName + '\'' +
                ", forumPassword='" + forumPassword + '\'' +
                ", forumSalt='" + forumSalt + '\'' +
                ", forumStatus='" + forumStatus + '\'' +
                '}';
    }
}
