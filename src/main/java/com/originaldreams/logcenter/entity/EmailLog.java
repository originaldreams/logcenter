package com.originaldreams.logcenter.entity;

import java.util.Date;
import java.util.List;

public class EmailLog {
    /**
    * id
    */
     private Integer id;
    /**
    * 邮件发送类型
    */
     private String type;
    /**
    * 收件人
    */
     private String recipients;
    /**
    * 标题
    */
     private String title;
    /**
    * 内容
    */
     private String content;
    /**
    * 发送时间
    */
     private String sendDate;
     public Integer getId(){
           return this.id;
     }
     public void setId(Integer id){
           this.id = id;
     }
     public String getType(){
           return this.type;
     }
     public void setType(String type){
           this.type = type;
     }
     public String getRecipients(){
           return this.recipients;
     }
     public void setRecipients(String recipients){
           this.recipients = recipients;
     }
     public String getTitle(){
           return this.title;
     }
     public void setTitle(String title){
           this.title = title;
     }
     public String getContent(){
           return this.content;
     }
     public void setContent(String content){
           this.content = content;
     }
     public String getSendDate(){
           return this.sendDate;
     }
     public void setSendDate(String sendDate){
           this.sendDate = sendDate;
     }


@Override
    public String toString() {
        return "EmailLog{" +
            "  id:" + id + "  type:" + type + "  recipients:" + recipients + "  title:" + title + "  content:" + content + "  sendDate:" + sendDate + 
        "}";
    }
  }
