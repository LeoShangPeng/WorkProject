package com.qianfeng.mgp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Package com.qianfeng.mgp.bean
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/3/7
 * @修 改 人:
 * @日 期:
 */
public class Strategy implements Serializable {
    private String id;
    private String title;
    private List<Strategy> info;
    private Page page;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<Strategy> getInfo() {
        return info;
    }

    public void setInfo(List<Strategy> info) {
        this.info = info;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
