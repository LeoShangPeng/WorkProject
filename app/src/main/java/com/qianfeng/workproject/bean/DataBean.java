package com.qianfeng.workproject.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class DataBean implements Serializable {
    private HashMap<String, AllshopBean> list;
//	private String category;
//	private int toal;
//	private List<SelectBean> select_val;

    public HashMap<String, AllshopBean> getList() {
        return list;
    }

    public void setList(HashMap<String, AllshopBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "DataBean [list=" + list + "]";
    }

}
