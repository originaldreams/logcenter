package com.originaldreams.logcenter.entity;

import java.util.Date;
import java.util.List;

public class SigninLog {
    /**
    * id
    */
     private Integer id;
    /**
    * 登录时间
    */
     private Date signinDate;
    /**
    * 登录用户id
    */
     private String signinUserId;
    /**
    * 登录类型
    */
     private String signinType = "SIGNIN";
    /**
    * 登录方式
    */
     private String signinWay;
    /**
    * 登录时的ip
    */
     private String ip;
    /**
    * 登录设备
    */
     private String signDevice;
     public Integer getId(){
           return this.id;
     }
     public void setId(Integer id){
           this.id = id;
     }
     public Date getSigninDate(){
           return this.signinDate;
     }
     public void setSigninDate(Date signinDate){
           this.signinDate = signinDate;
     }
     public String getSigninUserId(){
           return this.signinUserId;
     }
     public void setSigninUserId(String signinUserId){
           this.signinUserId = signinUserId;
     }
     public String getSigninType(){
           return this.signinType;
     }
     public void setSigninType(String signinType){
           this.signinType = signinType;
     }
     public String getSigninWay(){
           return this.signinWay;
     }
     public void setSigninWay(String signinWay){
           this.signinWay = signinWay;
     }
     public String getIp(){
           return this.ip;
     }
     public void setIp(String ip){
           this.ip = ip;
     }
     public String getSignDevice(){
           return this.signDevice;
     }
     public void setSignDevice(String signDevice){
           this.signDevice = signDevice;
     }


@Override
    public String toString() {
        return "SigninLog{" +
            "  id:" + id + "  signinDate:" + signinDate + "  signinUserId:" + signinUserId + "  signinType:" + signinType + "  signinWay:" + signinWay + "  ip:" + ip + "  signDevice:" + signDevice + 
        "}";
    }
  }
