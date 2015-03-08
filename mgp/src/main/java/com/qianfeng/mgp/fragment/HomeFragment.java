package com.qianfeng.mgp.fragment;


import com.alibaba.fastjson.TypeReference;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.ActindexAdapter;
import com.qianfeng.mgp.apapter.HomeJfAdapter;
import com.qianfeng.mgp.apapter.HotAdapter;
import com.qianfeng.mgp.apapter.OtherAdapter;
import com.qianfeng.mgp.apapter.RecommendAdapter;
import com.qianfeng.mgp.apapter.ViewPagerAdapter;
import com.qianfeng.mgp.bean.Actindex;
import com.qianfeng.mgp.bean.Banner;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.bean.HomeBean;
import com.qianfeng.mgp.bean.Hot;
import com.qianfeng.mgp.bean.OtherEnum;
import com.qianfeng.mgp.bean.Recommand;
import com.qianfeng.mgp.connect.ConnectUtils;
import com.qianfeng.mgp.constant.AppConstant;
import com.qianfeng.mgp.ui.DetailsActivity;
import com.qianfeng.mgp.widget.AutoScrollViewPager;
import com.qianfeng.mgp.widget.GridViewForScrollView;
import com.qianfeng.mgp.widget.ListViewForScrollView;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements ViewPager.OnPageChangeListener {
    /**
     * 广告
     */
    @ViewInject(R.id.home_banners_viewpager)
    private AutoScrollViewPager bannerViewPager;
    private ArrayList<View> bannerViews = new ArrayList<View>();
    private ViewPagerAdapter bannerAdapter;
    private int curIndex = 0;

    /**
     * 其他功能
     */
    @ViewInject(R.id.home_other_gridview)
    private GridViewForScrollView otherGridView;
    private OtherAdapter otherAdapter;
    /**
     * 推荐
     */
    @ViewInject(R.id.home_recommend_gridview)
    private GridViewForScrollView recommendGridView;
    private ArrayList<Recommand> recommends = new ArrayList<Recommand>();
    private RecommendAdapter recommendAdapter;
    @ViewInject(R.id.home_recommend_more_text)
    private TextView recommendTextView;

    /**
     * 热门
     */
    @ViewInject(R.id.home_hot_gridview)
    private GridViewForScrollView hotGridView;
    private HotAdapter hotAdapter;
    private ArrayList<Hot> hotes = new ArrayList<Hot>();

    /**
     * 活动
     */
    @ViewInject(R.id.home_actindex_listView)
    private ListViewForScrollView actindexeListView;
    private ActindexAdapter actindexAdapter;
    private ArrayList<Actindex> actindexes = new ArrayList<Actindex>();

    /**
     * 100积分
     */
    @ViewInject(R.id.home_listview)
    private ListViewForScrollView jfListView;
    private HomeJfAdapter adapter;
    private ArrayList<HomeBean> list = new ArrayList<HomeBean>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化工具类
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //注解方式初始化控件
        ViewUtils.inject(this, view);
        initBannerView();
        initOtherView();
        initRecommenView();
        initHotView();
        initActindexView();
        initJfView();
        sendRequest();
        return view;
    }

    //初始化公告控件
    private void initBannerView() {
        bannerViewPager.startAutoScroll();
        bannerAdapter = new ViewPagerAdapter(bannerViews);
        bannerViewPager.setOnPageChangeListener(this);
        bannerViewPager.setAdapter(bannerAdapter);
    }

    //初始化本地其他功能控件
    private void initOtherView() {
        otherAdapter = new OtherAdapter(activity, OtherEnum.getDatas());
        otherGridView.setAdapter(otherAdapter);
    }

    //初始化达人控件
    private void initRecommenView() {
        recommendAdapter = new RecommendAdapter(activity, recommends);
        recommendGridView.setAdapter(recommendAdapter);
    }


    private void initHotView() {
        hotAdapter = new HotAdapter(activity, hotes);
        hotGridView.setAdapter(hotAdapter);
    }

    //活动ui
    private void initActindexView() {
        actindexAdapter = new ActindexAdapter(activity, actindexes);
        actindexeListView.setAdapter(actindexAdapter);
    }


    //初始化积分控件
    private void initJfView() {
        adapter = new HomeJfAdapter(activity, list);
        jfListView.setAdapter(adapter);
    }

    /**
     *
     */
    private void sendRequest() {
        //广告栏请求
        ConnectUtils.getInstance().sendRequestForViewPager(activity, HttpRequest.HttpMethod.GET, AppConstant.getUrl(AppConstant.HOME_BANNER_URL), new TypeReference<CommonBean<Banner>>() {
        }, bannerViews, bannerAdapter, new ImageOnClickLinstner());
        //数据源请求
        ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, AppConstant.HOME_RECOMMEND_URL, new TypeReference<CommonBean<Recommand>>() {
        }, recommendAdapter, recommends);

        ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, AppConstant.HOME_HOT_URL, new TypeReference<CommonBean<Hot>>() {
        }, hotAdapter, hotes);

        ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, AppConstant.HOME_ACTINDEX_URL, new TypeReference<CommonBean<Actindex>>() {
        }, actindexAdapter, actindexes);

        //联网加载积分数据
        ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, AppConstant.HOME_JFENG_URL, new TypeReference<CommonBean<HomeBean>>() {
        }, adapter, list);
    }

    /**
     * 初始化积分100的参数
     *
     * @return
     */
    private RequestParams getRequestParams() {
        RequestParams params = new RequestParams();
        params.addBodyParameter("op", "jifeng");
        params.addBodyParameter("point", "100");
        params.addBodyParameter("compare", "0fc734030f398bd9187279687632fa19");
        return params;
    }

    @OnItemClick({R.id.home_hot_gridview, R.id.home_recommend_gridview, R.id.home_actindex_listView, R.id.home_jifeng_listview, R.id.home_other_gridview})
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.home_jifeng_listview:
                break;
            case R.id.home_recommend_gridview:
                break;
            case R.id.home_actindex_listView:
                break;
            case R.id.home_hot_gridview:
                break;
            case R.id.home_other_gridview:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.home_recommend_more_text})
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.home_recommend_more_text:
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        curIndex = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class ImageOnClickLinstner implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), DetailsActivity.class);
//            intent.putExtra("id", );
            startActivity(intent);
        }
    }

}
