package com.qianfeng.baidunuomi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * @version v1.0
 * @类描述：
 * @项目名称：StudyDemo
 * @包 名： com.qianfeng.studydemo.adapter
 * @类名称：VolleyPagerAdapter
 * @创建人：张唯
 * @创建时间：14-10-1
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class MePagerFragmentAdapter extends PagerAdapter {
    private ArrayList<Fragment> fragments;

    private FragmentManager manager;


    public MePagerFragmentAdapter(ArrayList<Fragment> fragments, FragmentManager manager) {
        this.fragments = fragments;
        this.manager = manager;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(fragment, ((Object) fragment).getClass().getName());
            transaction.addToBackStack(((Object) fragment).getClass().getSimpleName());
            //立即执行
            transaction.commitAllowingStateLoss();
            manager.executePendingTransactions();
        }
        if (fragment.getView().getParent() == null) {
            container.addView(fragment.getView());
        }
        return fragment.getView();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(fragments.get(position).getView());
    }
}
