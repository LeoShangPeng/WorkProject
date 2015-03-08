package com.qianfeng.mgp.bean;

import java.io.Serializable;

/**
 * @Package com.qianfeng.mgp.bean
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/25
 * @修 改 人:
 * @日 期:
 */
public class ActInfo implements Serializable {
    private String id;
    private String aname;
    private String shortname;
    private String apic;
    private String usinginp;
    private String inp;
    private String actorder;
    private String total;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getApic() {
        return apic;
    }

    public void setApic(String apic) {
        this.apic = apic;
    }

    public String getUsinginp() {
        return usinginp;
    }

    public void setUsinginp(String usinginp) {
        this.usinginp = usinginp;
    }

    public String getInp() {
        return inp;
    }

    public void setInp(String inp) {
        this.inp = inp;
    }

    public String getActorder() {
        return actorder;
    }

    public void setActorder(String actorder) {
        this.actorder = actorder;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ActInfo{" +
                "id='" + id + '\'' +
                ", aname='" + aname + '\'' +
                ", shortname='" + shortname + '\'' +
                ", apic='" + apic + '\'' +
                ", usinginp='" + usinginp + '\'' +
                ", inp='" + inp + '\'' +
                ", actorder='" + actorder + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
