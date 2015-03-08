package com.qianfeng.mgp.bean;

import java.io.Serializable;

/**
 * @Package com.qianfeng.baidunuomi.bean
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/19
 * @修 改 人:
 * @日 期:
 */
public class Classify implements Serializable {
    private String icon;
    private String type;
    private String total;

    public Classify() {
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
