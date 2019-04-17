package com.hz.forum.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 11022 on 2019/3/4 0004.
 */
public class Notice implements Serializable {
    private String noticeId;
    private String noticeName;
    private String noticeStatus;
    private String noticeIntroduce;
    @JSONField(format = "yyyy-MM-dd")
    private Date noticeDate;

    public Notice() {
    }

    public Notice(String noticeId, String noticeName, String noticeStatus, String noticeIntroduce, Date noticeDate) {
        this.noticeId = noticeId;
        this.noticeName = noticeName;
        this.noticeStatus = noticeStatus;
        this.noticeIntroduce = noticeIntroduce;
        this.noticeDate = noticeDate;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    public String getNoticeIntroduce() {
        return noticeIntroduce;
    }

    public void setNoticeIntroduce(String noticeIntroduce) {
        this.noticeIntroduce = noticeIntroduce;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId='" + noticeId + '\'' +
                ", noticeName='" + noticeName + '\'' +
                ", noticeStatus='" + noticeStatus + '\'' +
                ", noticeIntroduce='" + noticeIntroduce + '\'' +
                ", noticeDate=" + noticeDate +
                '}';
    }
}
