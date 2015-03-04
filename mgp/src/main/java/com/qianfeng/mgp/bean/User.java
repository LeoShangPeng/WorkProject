package com.qianfeng.mgp.bean;

/**
 * @Package com.qianfeng.mgp.bean
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/2/27
 * @修 改 人:
 * @日 期:
 */
public class User {
    private int id;
    private String name;
    private String psw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}
