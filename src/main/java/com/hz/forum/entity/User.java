package com.hz.forum.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by 11022 on 2019/2/22 0022.
 */
public class User implements Serializable{
    @Excel(name = "userId")
    private String userId;
    @Excel(name = "userName")
    private String userName;
    @Excel(name = "userLevel")
    private String userLevel;
    @Excel(name = "userStatus")
    private String userStatus;
    @Excel(name = "userIntroduce")
    private String userIntroduce;

    public User() {
    }

    public User(String userId, String userName, String userLevel, String userStatus, String userIntroduce) {
        this.userId = userId;
        this.userName = userName;
        this.userLevel = userLevel;
        this.userStatus = userStatus;
        this.userIntroduce = userIntroduce;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserIntroduce() {
        return userIntroduce;
    }

    public void setUserIntroduce(String userIntroduce) {
        this.userIntroduce = userIntroduce;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userLevel='" + userLevel + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userIntroduce='" + userIntroduce + '\'' +
                '}';
    }
}
