package com.qianfeng.baidunuomi.bean;

import java.io.Serializable;

public class Special implements Serializable {
	private int special_id;
	private String picture_url;
	private int goto_type;
	private String cont;

	public int getSpecial_id() {
		return special_id;
	}

	public void setSpecial_id(int special_id) {
		this.special_id = special_id;
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

	@Override
	public String toString() {
		return "HomeSpecial [special_id=" + special_id + ", picture_url=" + picture_url + ", goto_type=" + goto_type + ", cont=" + cont + "]";
	}

}
