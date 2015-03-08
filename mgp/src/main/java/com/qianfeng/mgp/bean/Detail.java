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
public class Detail implements Serializable {
    private String id;
    private String name;
    private String icon;
    private String banner;
    private String img;
    private String ver;
    private String pubdate;
    private String gameinfo;
    private String anddown;
    private String iosdown;
    private String gtype;
    private String gltypeid;
    private String tstrategy;
    private String strategyid;
    private String integral;
    private String mdown;
    private String downloads;
    private String size;
    private int issub;

    private Strategy strategy;

    private NewsNotice newsNotice;
    private Recommand1 recommand;

    public Recommand1 getRecommand() {
        return recommand;
    }

    public void setRecommand(Recommand1 recommand) {
        this.recommand = recommand;
    }

    public NewsNotice getNewsNotice() {
        return newsNotice;
    }

    public void setNewsNotice(NewsNotice newsNotice) {
        this.newsNotice = newsNotice;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
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

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getGameinfo() {
        return gameinfo;
    }

    public void setGameinfo(String gameinfo) {
        this.gameinfo = gameinfo;
    }

    public String getAnddown() {
        return anddown;
    }

    public void setAnddown(String anddown) {
        this.anddown = anddown;
    }

    public String getIosdown() {
        return iosdown;
    }

    public void setIosdown(String iosdown) {
        this.iosdown = iosdown;
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype;
    }

    public String getGltypeid() {
        return gltypeid;
    }

    public void setGltypeid(String gltypeid) {
        this.gltypeid = gltypeid;
    }

    public String getTstrategy() {
        return tstrategy;
    }

    public void setTstrategy(String tstrategy) {
        this.tstrategy = tstrategy;
    }

    public String getStrategyid() {
        return strategyid;
    }

    public void setStrategyid(String strategyid) {
        this.strategyid = strategyid;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getMdown() {
        return mdown;
    }

    public void setMdown(String mdown) {
        this.mdown = mdown;
    }

    public String getDownloads() {
        return downloads;
    }

    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getIssub() {
        return issub;
    }

    public void setIssub(int issub) {
        this.issub = issub;
    }


}
