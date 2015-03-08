package com.qianfeng.mgp.bean;

import java.io.Serializable;

/**
 * @Package com.qianfeng.mgp.bean
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/11
 * @修 改 人:
 * @日 期:
 */
public class Hot implements Serializable {
    private String id;
    private String icon;
    private String name;
    private String flag;
    private String tag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
