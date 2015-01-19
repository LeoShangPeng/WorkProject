package com.qianfeng.baidunuomi.bean;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	private String hotword;
	// 分类
	private List<Category> category;
	// 达人
	private List<Recommend> recommend;
	// 广告
	private List<Banner> banners;
	// 特色
	private List<Special> special;

	public String getHotword() {
		return hotword;
	}

	public void setHotword(String hotword) {
		this.hotword = hotword;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public List<Recommend> getRecommend() {
		return recommend;
	}

	public void setRecommend(List<Recommend> recommend) {
		this.recommend = recommend;
	}

	public List<Banner> getBanners() {
		return banners;
	}

	public void setBanners(List<Banner> banners) {
		this.banners = banners;
	}

	public List<Special> getSpecial() {
		return special;
	}

	public void setSpecial(List<Special> special) {
		this.special = special;
	}

	@Override
	public String toString() {
		return "Data [hotword=" + hotword + ", category=" + category + ", recommend=" + recommend + ", banners=" + banners + ", special=" + special + "]";
	}

}
