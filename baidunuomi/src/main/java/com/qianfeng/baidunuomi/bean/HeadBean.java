package com.qianfeng.baidunuomi.bean;

import java.io.Serializable;

public class HeadBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int errno;
	private String errmsg;
	private String msg;
	private long timestamp;
	private int cached;
	private int serverstatus;

	private Data data;

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getCached() {
		return cached;
	}

	public void setCached(int cached) {
		this.cached = cached;
	}

	public int getServerstatus() {
		return serverstatus;
	}

	public void setServerstatus(int serverstatus) {
		this.serverstatus = serverstatus;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HeadBean [errno=" + errno + ", errmsg=" + errmsg + ", msg=" + msg + ", timestamp=" + timestamp + ", cached=" + cached + ", serverstatus=" + serverstatus
				+ ", data=" + data + "]";
	}

}
