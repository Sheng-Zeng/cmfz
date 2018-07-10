package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LogMessage {
    private String logId;

    private String logUser;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JSONField(format="yyyy-MM-dd")
    private Date logTime;

    private String logResource;

    private String logAction;

    private String logMessage;

    private String logResult;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser == null ? null : logUser.trim();
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogResource() {
        return logResource;
    }

    public void setLogResource(String logResource) {
        this.logResource = logResource == null ? null : logResource.trim();
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction == null ? null : logAction.trim();
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage == null ? null : logMessage.trim();
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult == null ? null : logResult.trim();
    }


    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", logUser='" + logUser + '\'' +
                ", logTime=" + logTime +
                ", logResource='" + logResource + '\'' +
                ", logAction='" + logAction + '\'' +
                ", logMessage='" + logMessage + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }
}