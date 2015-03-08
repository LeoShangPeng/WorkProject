package com.qianfeng.mgp.ui;


import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.TabUtils;
import com.qianfeng.mgp.constant.AppConstant;
import com.qianfeng.mgp.fragment.ActInfoFragment;
import com.qianfeng.mgp.fragment.ClassifyFragment;
import com.qianfeng.mgp.fragment.HomeFragment;
import com.qianfeng.mgp.fragment.ManitoFragment;
import com.qianfeng.mgp.fragment.MeFragment;
import java.util.ArrayList;

@ContentView(R.layout.activity_main)
public class MainActivity extends ActionBarActivity implements TabUtils.OnRgsExtraCheckedChangedListener {
    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    @ViewInject(R.id.main_footer_rgs)
    private RadioGroup rgs;
    private TabUtils tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar 替代Actionbar;

        ViewUtils.inject(this);
        fragments.add(new HomeFragment());
        fragments.add(new ManitoFragment());
        fragments.add(new MeFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(ActInfoFragment.newInstance(AppConstant.ACTINFO_LIST_URL));
        tabAdapter = new TabUtils(getSupportFragmentManager(), fragments, R.id.main_container_id, rgs);
        tabAdapter.setOnRgsExtraCheckedChangedListener(this);
    }

    /**
     * 按钮点击回调接口
     *
     * @param radioGroup
     * @param checkedId
     * @param index
     */
    @Override
    public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {

    }
}
