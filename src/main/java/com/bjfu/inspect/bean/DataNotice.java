package com.bjfu.inspect.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class DataNotice {
    private int adId;
    private String adName;
    private String adAddress;
    private String adImage;
    private String adInfor;
    private String adType;
    private double adPrice;
    private String adPosition;
    private int adPower;
    private String adRemark;
    private int adAuthor;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp adTime;

    public DataNotice() {
    }


    public DataNotice(int adId, String adName, String adAddress, String adImage, String adInfor, String adType, double adPrice, String adPosition, int adPower, String adRemark, int adAuthor, Timestamp adTime) {
        this.adId = adId;
        this.adName = adName;
        this.adAddress = adAddress;
        this.adImage = adImage;
        this.adInfor = adInfor;
        this.adType = adType;
        this.adPrice = adPrice;
        this.adPosition = adPosition;
        this.adPower = adPower;
        this.adRemark = adRemark;
        this.adAuthor = adAuthor;
        this.adTime = adTime;
    }

    public DataNotice(String adName, String adAddress, String adImage, String adInfor, String adType, double adPrice, String adPosition, int adPower, String adRemark, int adAuthor, Timestamp adTime) {
        this.adName = adName;
        this.adAddress = adAddress;
        this.adImage = adImage;
        this.adInfor = adInfor;
        this.adType = adType;
        this.adPrice = adPrice;
        this.adPosition = adPosition;
        this.adPower = adPower;
        this.adRemark = adRemark;
        this.adAuthor = adAuthor;
        this.adTime = adTime;
    }


    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdAddress() {
        return adAddress;
    }

    public void setAdAddress(String adAddress) {
        this.adAddress = adAddress;
    }

    public String getAdImage() {
        return adImage;
    }

    public void setAdImage(String adImage) {
        this.adImage = adImage;
    }

    public String getAdInfor() {
        return adInfor;
    }

    public void setAdInfor(String adInfor) {
        this.adInfor = adInfor;
    }

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public double getAdPrice() {
        return adPrice;
    }

    public void setAdPrice(double adPrice) {
        this.adPrice = adPrice;
    }

    public String getAdPosition() {
        return adPosition;
    }

    public void setAdPosition(String adPosition) {
        this.adPosition = adPosition;
    }

    public int getAdPower() {
        return adPower;
    }

    public void setAdPower(int adPower) {
        this.adPower = adPower;
    }

    public String getAdRemark() {
        return adRemark;
    }

    public void setAdRemark(String adRemark) {
        this.adRemark = adRemark;
    }

    public int getAdAuthor() {
        return adAuthor;
    }

    public void setAdAuthor(int adAuthor) {
        this.adAuthor = adAuthor;
    }

    public Timestamp getAdTime() {
        return adTime;
    }

    public void setAdTime(Timestamp adTime) {
        this.adTime = adTime;
    }

    @Override
    public String toString() {
        return  "数据名称：" + adName +
                ", 地址：" + adAddress +
                ", 农机详细信息：" + adInfor +
                ", 流转类型：" + adType +
                ", 价格：" + adPrice +
                ", 位置：" + adPosition +
                ", 功率：" + adPower + "。";
    }
}
