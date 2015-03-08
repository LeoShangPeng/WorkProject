package com.qianfeng.mgp.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.ClassifyPagerAdapter;
import com.qianfeng.mgp.constant.AppStates;
import com.qianfeng.mgp.fragment.ClassifyTypeFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_classify)
public class ClassifyActivity extends ActionBarActivity {
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        type = getIntent().getStringExtra(AppStates.INTENT_TYPE);
        initViewPager();
    }

    /**
     * 初始化ViewPager
     */
    private void initViewPager() {
        fragments.add(ClassifyTypeFragment.newInstance(type, "rmtj"));
        fragments.add(ClassifyTypeFragment.newInstance(type, "mdown"));
        fragments.add(ClassifyTypeFragment.newInstance(type, "integral"));
        FragmentPagerAdapter adapter = new ClassifyPagerAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);
    }
}
