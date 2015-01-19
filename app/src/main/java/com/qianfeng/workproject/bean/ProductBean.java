package com.qianfeng.workproject.bean;

import java.io.Serializable;

public class ProductBean implements Serializable {
    private String info;
    private DataBean data;
    private int code;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ProductBean [info=" + info + ", data=" + data + ", code="
                + code + "]";
    }

}
