package com.example.dayrecords.Bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordUser {
    private int userId;
    private String userName;
    private String userPass;
    private String userMail;
    private String userRecord;
    private String code;
    private int userLoginResolveTime;
    @JsonFormat(pattern = "yyyy-MM-dd mm:hh:ss")
    private Date userLoginUpdate;
    private int userLoginGrant;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserRecord() {
        return userRecord;
    }

    public void setUserRecord(String userRecord) {
        this.userRecord = userRecord;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getUserLoginResolveTime() {
        return userLoginResolveTime;
    }

    public void setUserLoginResolveTime(int userLoginResolveTime) {
        this.userLoginResolveTime = userLoginResolveTime;
    }

    public Date getUserLoginUpdate() {
        return userLoginUpdate;
    }

    public void setUserLoginUpdate(Date userLoginUpdate) {
        this.userLoginUpdate = userLoginUpdate;
    }

    public int getUserLoginGrant() {
        return userLoginGrant;
    }

    public void setUserLoginGrant(int userLoginGrant) {
        this.userLoginGrant = userLoginGrant;
    }


}
