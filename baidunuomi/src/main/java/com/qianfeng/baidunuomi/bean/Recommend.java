package com.qianfeng.baidunuomi.bean;

import java.io.Serializable;

public class Recommend implements Serializable {
	private static final long serialVersionUID = 1L;
	private int recommend_id;
	private String recommend_title;
	private String recommend_image;
	private String man_pic;
	private String man_name;
	private String man_desc;

	public int getRecommend_id() {
		return recommend_id;
	}

	public void setRecommend_id(int recommend_id) {
		this.recommend_id = recommend_id;
	}

	public String getRecommend_title() {
		return recommend_title;
	}

	public void setRecommend_title(String recommend_title) {
		this.recommend_title = recommend_title;
	}

	public String getRecommend_image() {
		return recommend_image;
	}

	public void setRecommend_image(String recommend_image) {
		this.recommend_image = recommend_image;
	}

	public String getMan_pic() {
		return man_pic;
	}

	public void setMan_pic(String man_pic) {
		this.man_pic = man_pic;
	}

	public String getMan_name() {
		return man_name;
	}

	public void setMan_name(String man_name) {
		this.man_name = man_name;
	}

	public String getMan_desc() {
		return man_desc;
	}

	public void setMan_desc(String man_desc) {
		this.man_desc = man_desc;
	}

	@Override
	public String toString() {
		return "Homerecommend [recommend_id=" + recommend_id + ", recommend_title=" + recommend_title + ", recommend_image=" + recommend_image + ", man_pic=" + man_pic
				+ ", man_name=" + man_name + ", man_desc=" + man_desc + "]";
	}
}
