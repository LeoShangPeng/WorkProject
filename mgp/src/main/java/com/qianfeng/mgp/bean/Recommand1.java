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
public class Recommand1 implements Serializable {
    private String id;
    private String name;
    private String icon;

    private List<Recommand1> info;

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<Recommand1> getInfo() {
        return info;
    }

    public void setInfo(List<Recommand1> info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
