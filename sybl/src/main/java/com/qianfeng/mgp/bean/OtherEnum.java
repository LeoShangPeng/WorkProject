package com.qianfeng.mgp.bean;

import com.qianfeng.mgp.R;

import java.util.ArrayList;

/**
 * @Package com.qianfeng.mgp.bean
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/12
 * @修 改 人:
 * @日 期:
 */
public enum OtherEnum {
    Lottery("抽奖", R.drawable.ic_home_lottery),
    Sign("签到", R.drawable.ic_check_in),
    Gift("礼包", R.drawable.ic_gift),
    List("合集", R.drawable.ic_home_list);
    String text;
    int icon;

    private OtherEnum(String text, int icon) {
        this.icon = icon;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public static ArrayList<OtherEnum> getDatas() {
        ArrayList<OtherEnum> others = new ArrayList<OtherEnum>();
        for (OtherEnum other : OtherEnum.values()) {
            others.add(other);
        }
        return others;
    }

}
