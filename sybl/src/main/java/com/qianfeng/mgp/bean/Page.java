package com.qianfeng.mgp.bean;

import java.io.Serializable;

public class Page  implements Serializable{
	private static final long serialVersionUID = 1L;
	private int page;
	private int total;
	private int size;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", total=" + total + ", size=" + size + "]";
	}
	
	
}
