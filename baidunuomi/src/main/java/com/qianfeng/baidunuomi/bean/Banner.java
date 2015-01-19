package com.qianfeng.baidunuomi.bean;

import java.io.Serializable;

public class Banner implements Serializable {
   private static final long serialVersionUID = 1L;
   private int banner_id;
   private String picture_url;
   private int goto_type;
   private String cont;

   public int getBanner_id() {
       return banner_id;
   }

   public void setBanner_id(int banner_id) {
       this.banner_id = banner_id;
   }

   public String getPicture_url() {
       return picture_url;
   }

   public void setPicture_url(String picture_url) {
       this.picture_url = picture_url;
   }

   public int getGoto_type() {
       return goto_type;
   }

   public void setGoto_type(int goto_type) {
       this.goto_type = goto_type;
   }

   public String getCont() {
       return cont;
   }

   public void setCont(String cont) {
       this.cont = cont;
   }

   public static long getSerialversionuid() {
       return serialVersionUID;
   }


	
	
}
