package com.qianfeng.mgp.bean;

import java.io.Serializable;

/**
 * @Package com.qianfeng.mgp.bean
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/3/8
 * @修 改 人:
 * @日 期:
 *
 *
 */
public class Bag implements Serializable {
    private String id;
    private String attention;
    private String gid;
    private String name;
    private String stime;
    private String etime;
    private String icon;
    private String remain;
    private String consume;
    private String btn_status;
    private String remind;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public String getConsume() {
        return consume;
    }

    public void setConsume(String consume) {
        this.consume = consume;
    }

    public String getBtn_status() {
        return btn_status;
    }

    public void setBtn_status(String btn_status) {
        this.btn_status = btn_status;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
    }
}
