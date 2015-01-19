package com.qianfeng.baidunuomi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * @类名称：FragmentViewPagerAdapter
 * @类描述： 为ViewPager添加布局（Fragment），绑定和处理fragments和viewpager之间的逻辑关系
 * @创建人：张唯
 * @创建时间：2013-12-19 下午12:49:48
 * @修改人：
 * @修改时间：2013-12-19 下午12:49:48
 * @修改备注：
 */

public class FragmentViewPagerAdapter extends PagerAdapter {
    private List<Fragment> fragments; // 每个Fragment对应一个Page
    private FragmentManager fragmentManager;
    private int currentPageIndex = 0; // 当前page索引（切换之前）

    public FragmentViewPagerAdapter(FragmentManager fragmentManager,List<Fragment> fragments) {
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
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
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(fragments.get(position).getView()); // 移出viewpager两边之外的page布局
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) { // 如果fragment还没有added
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(fragment, ((Object) fragment).getClass().getName());
            ft.commit();
            /**
             * 在用FragmentTransaction.commit()方法提交FragmentTransaction对象后
             * 会在进程的主线程中，用异步的方式来执行。 如果想要立即执行这个等待中的操作，就要调用这个方法（只能在主线程中调用）。
             * 要注意的是，所有的回调和相关的行为都会在这个调用中被执行完成，因此要仔细确认这个方法的调用位置。
             */
            fragmentManager.executePendingTransactions();
        }

        if (fragment.getView().getParent() == null) {
            container.addView(fragment.getView()); // 为viewpager增加布局
        }
        return fragment.getView();
    }

    /**
     * 当前page索引（切换之前）
     *
     * @return
     */
    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

}
