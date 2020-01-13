package com.bjfu.inspect.bean;

public class Users {
    private int uId;
    //用户昵称
    private String uName;
    private String uPassword;
    private int uGender;
    private int uAge;
    //用户的真实姓名
    private String uTrueName;
    //用户的身份证号码
    private String uNumber;
    //用户的电话号码
    private String telephoneNum;
    //用户类型，0表示普通用户，1表示管理员
    private int uType;


    public Users() {}

    public Users(int uId, String uName, String uPassword, int uGender, int uAge, String uTrueName, String uNumber, String telephoneNum, int uType) {
        this.uId = uId;
        this.uName = uName;
        this.uPassword = uPassword;
        this.uGender = uGender;
        this.uAge = uAge;
        this.uTrueName = uTrueName;
        this.uNumber = uNumber;
        this.telephoneNum = telephoneNum;
        this.uType = uType;
    }

    public Users(String uName, String uPassword, int uGender, int uAge, String uTrueName, String uNumber, String telephoneNum, int uType) {
        this.uName = uName;
        this.uPassword = uPassword;
        this.uGender = uGender;
        this.uAge = uAge;
        this.uTrueName = uTrueName;
        this.uNumber = uNumber;
        this.telephoneNum = telephoneNum;
        this.uType = uType;
    }

    public String getuTrueName() {
        return uTrueName;
    }

    public void setuTrueName(String uTrueName) {
        this.uTrueName = uTrueName;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public int getuGender() {
        return uGender;
    }

    public void setuGender(int uGender) {
        this.uGender = uGender;
    }

    public int getuAge() {
        return uAge;
    }

    public void setuAge(int uAge) {
        this.uAge = uAge;
    }

    public String getuNumber() {
        return uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uGender=" + uGender +
                ", uAge=" + uAge +
                ", uNumber='" + uNumber + '\'' +
                ", telephoneNum='" + telephoneNum + '\'' +
                ", uType=" + uType +
                '}';
    }
}
