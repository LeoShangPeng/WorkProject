package com.qianfeng.mgp.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ScrollView;

import com.alibaba.fastjson.TypeReference;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;

import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.ManitoAdapter;
import com.qianfeng.mgp.apapter.ViewPagerAdapter;
import com.qianfeng.mgp.bean.Banner;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.bean.Manitio;
import com.qianfeng.mgp.connect.ConnectUtils;
import com.qianfeng.mgp.constant.AppConstant;
import com.qianfeng.mgp.widget.AutoScrollViewPager;
import com.qianfeng.mgp.widget.ListViewForScrollView;

import java.util.ArrayList;


/**
 * 大神圈
 * http://mobileapi.72g.com/index.php?tp=andv4/quan&op=qinfo
 */
public class ManitoFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<ScrollView> {
    @ViewInject(R.id.manito_listview)
    private ListViewForScrollView listView;
    private ManitoAdapter adapter;
    private ArrayList<Manitio> list = new ArrayList<Manitio>();
    private BitmapUtils bitmapUtils;

    @ViewInject(R.id.manito_viewpager)
    private AutoScrollViewPager viewPager;
    private ArrayList<View> views = new ArrayList<View>();
    private ViewPagerAdapter pagerAdapter;

    public ManitoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bitmapUtils = new BitmapUtils(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manito, container, false);
        ViewUtils.inject(this, view);
        //添加headView
        listView.setDividerHeight(8);
        adapter = new ManitoAdapter(activity, list);
        listView.setAdapter(adapter);
        httpHandler = ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, AppConstant.MANITO_LIST_URL, new TypeReference<CommonBean<Manitio>>() {
        }, adapter, list);
        initHeadPager(AppConstant.MANITO_HEAD_URL, viewPager);
        return view;
    }

    @OnItemClick(R.id.manito_listview)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {

    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {

    }
}
