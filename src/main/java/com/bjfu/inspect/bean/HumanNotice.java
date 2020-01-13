package com.bjfu.inspect.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class HumanNotice {
    private int hrId;
    private String hrTitle;
    private String hrSkill;
    private int hrWage;
    private String hrAddress;
    private String hrRequest;
    private String hrName;
    private String hrTelephone;
    private String hrRemark;
    private int hrAuthor;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp hrTime;

    public HumanNotice() {
    }

    public HumanNotice(int hrId, String hrTitle, String hrSkill, int hrWage, String hrAddress, String hrRequest, String hrName, String hrTelephone, String hrRemark, Timestamp hrTime, int hrAuthor) {
        this.hrId = hrId;
        this.hrTitle = hrTitle;
        this.hrSkill = hrSkill;
        this.hrWage = hrWage;
        this.hrAddress = hrAddress;
        this.hrRequest = hrRequest;
        this.hrName = hrName;
        this.hrTelephone = hrTelephone;
        this.hrRemark = hrRemark;
        this.hrTime = hrTime;
        this.hrAuthor = hrAuthor;
    }

    public HumanNotice(String hrTitle, String hrSkill, int hrWage, String hrAddress, String hrRequest, String hrName, String hrTelephone, String hrRemark, int hrAuthor, Timestamp hrTime) {
        this.hrTitle = hrTitle;
        this.hrSkill = hrSkill;
        this.hrWage = hrWage;
        this.hrAddress = hrAddress;
        this.hrRequest = hrRequest;
        this.hrName = hrName;
        this.hrTelephone = hrTelephone;
        this.hrRemark = hrRemark;
        this.hrAuthor = hrAuthor;
        this.hrTime = hrTime;
    }


    public int getHrId() {
        return hrId;
    }

    public int getHrAuthor() {
        return hrAuthor;
    }

    public void setHrAuthor(int hrAuthor) {
        this.hrAuthor = hrAuthor;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public String getHrTitle() {
        return hrTitle;
    }

    public void setHrTitle(String hrTitle) {
        this.hrTitle = hrTitle;
    }

    public String getHrSkill() {
        return hrSkill;
    }

    public void setHrSkill(String hrSkill) {
        this.hrSkill = hrSkill;
    }

    public int getHrWage() {
        return hrWage;
    }

    public void setHrWage(int hrWage) {
        this.hrWage = hrWage;
    }

    public String getHrAddress() {
        return hrAddress;
    }

    public void setHrAddress(String hrAddress) {
        this.hrAddress = hrAddress;
    }

    public String getHrRequest() {
        return hrRequest;
    }

    public void setHrRequest(String hrRequest) {
        this.hrRequest = hrRequest;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getHrTelephone() {
        return hrTelephone;
    }

    public void setHrTelephone(String hrTelephone) {
        this.hrTelephone = hrTelephone;
    }

    public String getHrRemark() {
        return hrRemark;
    }

    public void setHrRemark(String hrRemark) {
        this.hrRemark = hrRemark;
    }

    public Timestamp getHrTime() {
        return hrTime;
    }

    public void setHrTime(Timestamp hrTime) {
        this.hrTime = hrTime;
    }

    @Override
    public String toString() {
        return  "技能要求：" + hrSkill +
                ", 工资待遇：" + hrWage +
                ", 工作地点：" + hrAddress +
                ", 人员要求：" + hrRequest +
                ", 联系人：" + hrName +
                ", 联系方式：" + hrTelephone +
                ", 补充说明：" + hrRemark + "。";
    }
}
