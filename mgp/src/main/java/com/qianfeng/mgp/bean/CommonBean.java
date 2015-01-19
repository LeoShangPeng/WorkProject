package com.qianfeng.mgp.bean;

import java.io.Serializable;
import java.util.List;

public class CommonBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String state;
    private Page page;
    private List<T> info;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<T> getInfo() {
        return info;
    }

    public void setInfo(List<T> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CommonBean{" +
                "state='" + state + '\'' +
                ", page=" + page +
                ", info=" + info +
                '}';
    }
}
