package com.bjfu.inspect.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class ProjectNotice {
    private int pId;
    private String pTitle;
    private String pImage;
    private String pAddress;
    private String pType;
    private int pHnum;
    private int pWage;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp pTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp pCreatTime;
    private String pRemark;
    private int pAuthor;

    public ProjectNotice() {
    }

    public ProjectNotice(int pId, String pTitle, String pImage, String pAddress, String pType, int pHnum, int pWage, Timestamp pTime, Timestamp pCreatTime, String pRemark, int pAuthor) {
        this.pId = pId;
        this.pTitle = pTitle;
        this.pImage = pImage;
        this.pAddress = pAddress;
        this.pType = pType;
        this.pHnum = pHnum;
        this.pWage = pWage;
        this.pTime = pTime;
        this.pCreatTime = pCreatTime;
        this.pRemark = pRemark;
        this.pAuthor = pAuthor;
    }

    public ProjectNotice(String pTitle, String pImage, String pAddress, String pType, int pHnum, int pWage, Timestamp pTime, Timestamp pCreatTime, String pRemark, int pAuthor) {
        this.pTitle = pTitle;
        this.pImage = pImage;
        this.pAddress = pAddress;
        this.pType = pType;
        this.pHnum = pHnum;
        this.pWage = pWage;
        this.pTime = pTime;
        this.pCreatTime = pCreatTime;
        this.pRemark = pRemark;
        this.pAuthor = pAuthor;
    }

    public int getpAuthor() {
        return pAuthor;
    }

    public void setpAuthor(int pAuthor) {
        this.pAuthor = pAuthor;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public int getpHnum() {
        return pHnum;
    }

    public void setpHnum(int pHnum) {
        this.pHnum = pHnum;
    }

    public int getpWage() {
        return pWage;
    }

    public void setpWage(int pWage) {
        this.pWage = pWage;
    }

    public Timestamp getpTime() {
        return pTime;
    }

    public void setpTime(Timestamp pTime) {
        this.pTime = pTime;
    }

    public String getpRemark() {
        return pRemark;
    }

    public void setpRemark(String pRemark) {
        this.pRemark = pRemark;
    }

    public Timestamp getpCreatTime() {
        return pCreatTime;
    }

    public void setpCreatTime(Timestamp pCreatTime) {
        this.pCreatTime = pCreatTime;
    }

    @Override
    public String toString() {
        return
                "工程地点：" + pAddress +
                ", 工程项目类型：" + pType +
                ", 工程所需人数：" + pHnum +
                ", 工资：" + pWage +
                ", 报名时间：" + pCreatTime +
                ", 补充说明：" + pRemark + "。";
    }
}
