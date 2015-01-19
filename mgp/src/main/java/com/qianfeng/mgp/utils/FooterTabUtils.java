package com.qianfeng.mgp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;


import java.util.List;

/**
 * 主界面 底部切换tab工具类
 *
 * @Package com.qianfeng.mgp.utils
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/12
 * @修 改 人:
 * @日 期:
 */
public class FooterTabUtils implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup rgs;//底部RadioGroup
    private int fragmentContentId;//替换fragment的容器id
    private List<Fragment> fragments; //切换的fragment
    private FragmentManager fragmentManager;//FragmentManager管理类

    public FooterTabUtils(FragmentManager fragmentManager, List<Fragment> fragments, int fragmentContentId, RadioGroup rgs) {
        this.fragmentContentId = fragmentContentId;
        this.rgs = rgs;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0; i < rgs.getChildCount(); i++) {
            if (rgs.getChildAt(i).getId() == checkedId) {
               Fragment fragment = fragments.get(i);
               FragmentTransaction transaction = fragmentManager.beginTransaction();

               if (fragment.isAdded()){

               }else {
                  
               }
            }
        }
    }
}
