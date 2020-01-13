package com.bjfu.inspect.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class AllianceNotice {
    private int aId;
    private String aTitle;
    private String aImage;
    private String aInfor;
    private String aType;
    private double aPrice;
    private String aPosition;
    private int aPower;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp aTime;
    private String aRemark;
    private int aAuthor;

    public AllianceNotice() {
    }

    public AllianceNotice(int aId, String aTitle, String aImage, String aInfor, String aType, double aPrice, String aPosition, int aPower, Timestamp aTime, String aRemark, int aAuthor) {
        this.aId = aId;
        this.aTitle = aTitle;
        this.aImage = aImage;
        this.aInfor = aInfor;
        this.aType = aType;
        this.aPrice = aPrice;
        this.aPosition = aPosition;
        this.aPower = aPower;
        this.aTime = aTime;
        this.aRemark = aRemark;
        this.aAuthor = aAuthor;
    }

    public AllianceNotice(String aTitle, String aImage, String aInfor, String aType, double aPrice, String aPosition, int aPower, Timestamp aTime, String aRemark, int aAuthor) {
        this.aTitle = aTitle;
        this.aImage = aImage;
        this.aInfor = aInfor;
        this.aType = aType;
        this.aPrice = aPrice;
        this.aPosition = aPosition;
        this.aPower = aPower;
        this.aTime = aTime;
        this.aRemark = aRemark;
        this.aAuthor = aAuthor;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaImage() {
        return aImage;
    }

    public void setaImage(String aImage) {
        this.aImage = aImage;
    }

    public String getaInfor() {
        return aInfor;
    }

    public void setaInfor(String aInfor) {
        this.aInfor = aInfor;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public double getaPrice() {
        return aPrice;
    }

    public void setaPrice(double aPrice) {
        this.aPrice = aPrice;
    }

    public String getaPosition() {
        return aPosition;
    }

    public void setaPosition(String aPosition) {
        this.aPosition = aPosition;
    }

    public int getaPower() {
        return aPower;
    }

    public void setaPower(int aPower) {
        this.aPower = aPower;
    }

    public Timestamp getaTime() {
        return aTime;
    }

    public void setaTime(Timestamp aTime) {
        this.aTime = aTime;
    }

    public String getaRemark() {
        return aRemark;
    }

    public void setaRemark(String aRemark) {
        this.aRemark = aRemark;
    }

    public int getaAuthor() {
        return aAuthor;
    }

    public void setaAuthor(int aAuthor) {
        this.aAuthor = aAuthor;
    }

    @Override
    public String toString() {
        return  "基本介绍：" + aInfor +
                ", 流转类型：" + aType +
                ", 价格：" + aPrice +
                ", 位置：" + aPosition +
                ", 功率：" + aPower +
                ", 备注：" + aRemark + "。";
    }
}
