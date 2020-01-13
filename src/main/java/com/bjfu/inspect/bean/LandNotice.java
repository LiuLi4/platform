package com.bjfu.inspect.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class LandNotice {
    private int ltId;
    private String ltTitle;
    private String ltImage;
    private String ltType;
    private double ltPrice;
    private String ltRegion;
    private String ltPosition;
    private int ltArea;
    private int ltYear;
    private String ltName;
    private String ltTelephone;
    private String ltAddress;
    private String ltRemark;
    private int ltAuthor;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp ltTime;

    public LandNotice() {
    }

    public LandNotice(int ltId, String ltTitle, String ltImage, String ltType, double ltPrice, String ltRegion, String ltPosition, int ltArea, int ltYear, String ltName, String ltTelephone, String ltAddress, String ltRemark, int ltAuthor, Timestamp ltTime) {
        this.ltId = ltId;
        this.ltTitle = ltTitle;
        this.ltImage = ltImage;
        this.ltType = ltType;
        this.ltPrice = ltPrice;
        this.ltRegion = ltRegion;
        this.ltPosition = ltPosition;
        this.ltArea = ltArea;
        this.ltYear = ltYear;
        this.ltName = ltName;
        this.ltTelephone = ltTelephone;
        this.ltAddress = ltAddress;
        this.ltRemark = ltRemark;
        this.ltAuthor = ltAuthor;
        this.ltTime = ltTime;
    }

    public LandNotice(String ltTitle, String ltImage, String ltType, double ltPrice, String ltRegion, String ltPosition, int ltArea, int ltYear, String ltName, String ltTelephone, String ltAddress, String ltRemark, int ltAuthor, Timestamp ltTime) {
        this.ltTitle = ltTitle;
        this.ltImage = ltImage;
        this.ltType = ltType;
        this.ltPrice = ltPrice;
        this.ltRegion = ltRegion;
        this.ltPosition = ltPosition;
        this.ltArea = ltArea;
        this.ltYear = ltYear;
        this.ltName = ltName;
        this.ltTelephone = ltTelephone;
        this.ltAddress = ltAddress;
        this.ltRemark = ltRemark;
        this.ltAuthor = ltAuthor;
        this.ltTime = ltTime;
    }

    public String getLtTitle() {
        return ltTitle;
    }

    public void setLtTitle(String ltTitle) {
        this.ltTitle = ltTitle;
    }

    public int getLtId() {
        return ltId;
    }

    public void setLtId(int ltId) {
        this.ltId = ltId;
    }

    public String getLtImage() {
        return ltImage;
    }

    public void setLtImage(String ltImage) {
        this.ltImage = ltImage;
    }

    public String getLtType() {
        return ltType;
    }

    public void setLtType(String ltType) {
        this.ltType = ltType;
    }

    public double getLtPrice() {
        return ltPrice;
    }

    public void setLtPrice(int ltPrice) {
        this.ltPrice = ltPrice;
    }

    public String getLtRegion() {
        return ltRegion;
    }

    public void setLtRegion(String ltRegion) {
        this.ltRegion = ltRegion;
    }

    public String getLtPosition() {
        return ltPosition;
    }

    public void setLtPosition(String ltPosition) {
        this.ltPosition = ltPosition;
    }

    public int getLtArea() {
        return ltArea;
    }

    public void setLtArea(int ltArea) {
        this.ltArea = ltArea;
    }

    public int getLtYear() {
        return ltYear;
    }

    public void setLtYear(int ltYear) {
        this.ltYear = ltYear;
    }

    public String getLtName() {
        return ltName;
    }

    public void setLtName(String ltName) {
        this.ltName = ltName;
    }

    public String getLtTelephone() {
        return ltTelephone;
    }

    public void setLtTelephone(String ltTelephone) {
        this.ltTelephone = ltTelephone;
    }

    public String getLtAddress() {
        return ltAddress;
    }

    public void setLtAddress(String ltAddress) {
        this.ltAddress = ltAddress;
    }

    public String getLtRemark() {
        return ltRemark;
    }

    public void setLtRemark(String ltRemark) {
        this.ltRemark = ltRemark;
    }

    public int getLtAuthor() {
        return ltAuthor;
    }

    public void setLtAuthor(int ltAuthor) {
        this.ltAuthor = ltAuthor;
    }

    public void setLtPrice(double ltPrice) {
        this.ltPrice = ltPrice;
    }

    public Timestamp getLtTime() {
        return ltTime;
    }

    public void setLtTime(Timestamp ltTime) {
        this.ltTime = ltTime;
    }

    @Override
    public String toString() {
        return  "流转类型：" + ltType +
                ", 土地价格：" + ltPrice +
                ", 区域：" + ltRegion +
                ", 位置：" + ltPosition +
                ", 面积：" + ltArea +
                ", 交易年限：" + ltYear +
                ", 联系人姓名" + ltName +
                ", 电话：" + ltTelephone +
                ", 地址：" + ltAddress +
                ", 补充说明：" + ltRemark + "。";
    }
}
