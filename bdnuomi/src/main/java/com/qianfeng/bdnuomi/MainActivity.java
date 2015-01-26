package com.qianfeng.bdnuomi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.ViewParent;

import com.qianfeng.bdnuomi.fragment.ClassifyFragment;
import com.qianfeng.bdnuomi.fragment.HomeFragment;

import java.util.ArrayList;

/**
 * Actionbar
 * Viewpager
 * Fragment
 */
public class MainActivity extends BaseActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
    private ActionBar actionBar;

    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initActionBar();
        initViewPager();
    }

    private void initActionBar() {
        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("首页").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("分类").setTabListener(this));
    }

    /**
     * 容器控件
     * adapter
     * 监听
     */
    private void initViewPager() {
        fragments.add(new HomeFragment());
        fragments.add(new ClassifyFragment());
        viewPager = (ViewPager) this.findViewById(R.id.view);
        MainPageAdapter adapter = new MainPageAdapter(fragments, getSupportFragmentManager());
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        AppManager.getAppManager().AppExit(BaseApp.getInstance());
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        //设置导航条切换
        actionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
