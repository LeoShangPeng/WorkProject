package com.qianfeng.mgp.apapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/22
 * @修 改 人:
 * @日 期:
 */
public class ClassifyPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    private String[] titles = {"热门推荐", "下载最多", "金币最多",};

    public ClassifyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null && !fragments.isEmpty() ? fragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position % titles.length];
    }
}
