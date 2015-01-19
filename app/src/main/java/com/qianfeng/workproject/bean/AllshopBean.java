package com.qianfeng.workproject.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class AllshopBean implements Serializable{
	private String id;
	private String code;
	private String title;
//	private String attr;
//	private int stock;
//	private float price;
	//现在商品的人民币价格
	private float rmb_price;
	//差价
	private float discount_price;
	private float weight;
//	private float freight;
//	private String jcate;
//	private int ts;
//	private boolean butStatus;
	private List<Map<String, String>> images;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getRmb_price() {
		return rmb_price;
	}
	public void setRmb_price(float rmb_price) {
		this.rmb_price = rmb_price;
	}
	public float getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(float discount_price) {
		this.discount_price = discount_price;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public List<Map<String, String>> getImages() {
		return images;
	}
	public void setImages(List<Map<String, String>> images) {
		this.images = images;
	}
	@Override
	public String toString() {
		return "AllshopBean [id=" + id + ", code=" + code + ", title=" + title
				+ ", rmb_price=" + rmb_price + ", discount_price="
				+ discount_price + ", weight=" + weight + ", images=" + images
				+ "]";
	}
	
	
	
	
}
