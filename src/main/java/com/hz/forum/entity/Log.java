package com.hz.forum.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname test
 * @Description TODO
 * @Date 2019/3/10 0010 22:56
 * @Created by 11022
 * @Email hz15858@163.com
 */
public class Log implements Serializable {
    private String logId;
    private String logUsername;
    @JSONField(format = "yyyy-MM -dd hh:mm:ss")
    private Date logDate;

    private String logResource;
    private String logAction;
    private String logMessage;
    private String logResult;

    public Log() {
    }

    public Log(String logId, String logUsername, Date logDate, String logResource, String logAction, String logMessage, String logResult) {
        this.logId = logId;
        this.logUsername = logUsername;
        this.logDate = logDate;
        this.logResource = logResource;
        this.logAction = logAction;
        this.logMessage = logMessage;
        this.logResult = logResult;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUsername() {
        return logUsername;
    }

    public void setLogUsername(String logUsername) {
        this.logUsername = logUsername;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogResource() {
        return logResource;
    }

    public void setLogResource(String logResource) {
        this.logResource = logResource;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", logUsername='" + logUsername + '\'' +
                ", logDate=" + logDate +
                ", logResource='" + logResource + '\'' +
                ", logAction='" + logAction + '\'' +
                ", logMessage='" + logMessage + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }
}
