package com.qianfeng.bdnuomi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * @Package com.qianfeng.bdnuomi
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/26
 * @修 改 人:
 * @日 期:
 */
public class MainPageAdapter extends PagerAdapter {
    private ArrayList<Fragment> fragments;
    private FragmentManager manager;

    public MainPageAdapter(ArrayList<Fragment> fragments, FragmentManager manager) {
        this.fragments = fragments;
        this.manager = manager;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(fragment, fragment.getClass().getName());
            //插队
            transaction.commitAllowingStateLoss();
            //立即执行事务
            manager.executePendingTransactions();
        }
        view = fragment.getView();
        if (view != null && view.getParent() == null) {
            container.addView(view);
        }
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(fragments.get(position).getView());


    }
}
