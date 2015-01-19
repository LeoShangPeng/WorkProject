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
public class Recommend implements Serializable {
        private  String id;

    private  String bname;
    private  String bimg;
    private  String url;
    private  String border;
    private  String pos;
    private  String linkto;
    private  String lid;
    private  String isdy;
    private  String pt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getLinkto() {
        return linkto;
    }

    public void setLinkto(String linkto) {
        this.linkto = linkto;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getIsdy() {
        return isdy;
    }

    public void setIsdy(String isdy) {
        this.isdy = isdy;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "id='" + id + '\'' +
                ", bname='" + bname + '\'' +
                ", bimg='" + bimg + '\'' +
                ", url='" + url + '\'' +
                ", border='" + border + '\'' +
                ", pos='" + pos + '\'' +
                ", linkto='" + linkto + '\'' +
                ", lid='" + lid + '\'' +
                ", isdy='" + isdy + '\'' +
                ", pt='" + pt + '\'' +
                '}';
    }
}
