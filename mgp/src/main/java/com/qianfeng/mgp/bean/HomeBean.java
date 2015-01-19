package com.qianfeng.mgp.bean;

import java.io.File;
import java.io.Serializable;

import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.Transient;
import com.lidroid.xutils.http.HttpHandler;

public class HomeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NoAutoIncrement
    private String id;
    private String name;
    private String mdown;
    private String icon;
    private String escore;
    private String ver;
    private String size;
    private String integral;
    private String anddown;
    @Transient
    private HttpHandler<File> handler;
    private HttpHandler.State state;
    private String fileSavePath;
    private String fileName;
    private long progress;
    private long fileLength;
    private boolean autoResume;
    private boolean autoRename;

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

    public String getMdown() {
        return mdown;
    }

    public void setMdown(String mdown) {
        this.mdown = mdown;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEscore() {
        return escore;
    }

    public void setEscore(String escore) {
        this.escore = escore;
    }

    public String getVer() {
        return ver;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getAnddown() {
        return anddown;
    }

    public void setAnddown(String anddown) {
        this.anddown = anddown;
    }

    @Override
    public String toString() {
        return "HomeBean [id=" + id + ", name=" + name + ", mdown=" + mdown + ", icon=" + icon + ", escore=" + escore + ", ver=" + ver + ", size=" + size + ", integral="
                + integral + ", anddown=" + anddown + "]";
    }

    public HttpHandler<File> getHandler() {
        return handler;
    }

    public void setHandler(HttpHandler<File> handler) {
        this.handler = handler;
    }

    public HttpHandler.State getState() {
        return state;
    }

    public void setState(HttpHandler.State state) {
        this.state = state;
    }

    public String getFileSavePath() {
        return fileSavePath;
    }

    public void setFileSavePath(String fileSavePath) {
        this.fileSavePath = fileSavePath;
    }

    public long getProgress() {
        return progress;
    }

    public void setProgress(long progress) {
        this.progress = progress;
    }

    public long getFileLength() {
        return fileLength;
    }

    public void setFileLength(long fileLength) {
        this.fileLength = fileLength;
    }

    public boolean isAutoResume() {
        return autoResume;
    }

    public void setAutoResume(boolean autoResume) {
        this.autoResume = autoResume;
    }

    public boolean isAutoRename() {
        return autoRename;
    }

    public void setAutoRename(boolean autoRename) {
        this.autoRename = autoRename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof HomeBean))
            return false;

        HomeBean that = (HomeBean) o;

        if (id != that.id)
            return false;

        return true;
    }

}
