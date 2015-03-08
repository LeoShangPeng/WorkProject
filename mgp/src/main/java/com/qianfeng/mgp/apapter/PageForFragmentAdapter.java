package com.qianfeng.mgp.apapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/3/8
 * @修 改 人:
 * @日 期:
 */
public class PageForFragmentAdapter extends PagerAdapter {
    private List<Fragment> fragments;
    private FragmentManager fragmentManager;
    private String[] titles;

    public PageForFragmentAdapter(List<Fragment> fragments, FragmentManager fragmentManager) {
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    public PageForFragmentAdapter(List<Fragment> fragments, FragmentManager fragmentManager, String[] titles) {
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return fragments != null && !fragments.isEmpty() ? fragments.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = fragments.get(position);
        if (!fragment.isAdded()) {
            fragmentManager.beginTransaction().add(fragment, fragment.getClass().getName()).commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        if (fragment.getView().getParent() != null) {
            container.addView(fragment.getView());
        }
        return fragment.getView();
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(fragments.get(position).getView());
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles != null && titles.length > 0 ? titles[position % titles.length] : super.getPageTitle(position);
    }


}
