package com.qianfeng.mgp.bean;

import java.io.Serializable;

/**
 * @Package com.qianfeng.mgp.bean
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/13
 * @修 改 人:
 * @日 期:
 */
public class Manitio implements Serializable {

    private String id;
    private String gid;
    private String qname;
    private String godname;
    private String mcount;
    private String flag;
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public String getGodname() {
        return godname;
    }

    public void setGodname(String godname) {
        this.godname = godname;
    }

    public String getMcount() {
        return mcount;
    }

    public void setMcount(String mcount) {
        this.mcount = mcount;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Manitio{" +
                "id='" + id + '\'' +
                ", gid='" + gid + '\'' +
                ", qname='" + qname + '\'' +
                ", godname='" + godname + '\'' +
                ", mcount='" + mcount + '\'' +
                ", flag='" + flag + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
