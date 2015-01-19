package com.qianfeng.mgp.bean;

/**
 * @Package com.qianfeng.mgp.bean
 * @作 用: 广告栏实体bean
 * @创 建 人: zhangwei
 * @日 期: 14/12/10
 * @修 改 人:
 * @日 期:
 */
public class Banner extends BaseBean {
    private String id;
    private String bname;

    private String bimg;

    private String linkto;
    private String lid;

    private String url;

    private String border;

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
}
