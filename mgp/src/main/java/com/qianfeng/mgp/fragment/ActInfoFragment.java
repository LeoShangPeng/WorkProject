package com.qianfeng.mgp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.TypeReference;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListFragment;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;
import com.lidroid.xutils.bitmap.core.BitmapSize;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.ActInofAdapter;
import com.qianfeng.mgp.bean.ActInfo;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.connect.ConnectUtils;
import com.qianfeng.mgp.utils.XutilsHepler;

import java.util.ArrayList;


public class ActInfoFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<ListView> {
    public static final String URL = "URL";
    private String url;
    @ViewInject(R.id.app_ptrlistview)
    private PullToRefreshListView ptrListView;
    @ViewInject(R.id.empty)
    private ImageView emptyView;

    private ActInofAdapter actInofAdapter;
    private ArrayList<ActInfo> actInfos = new ArrayList<>();
    private BitmapUtils bitmapUtils;
    private int page = 1;

    public static ActInfoFragment newInstance(String url) {
        ActInfoFragment fragment = new ActInfoFragment();
        Bundle args = new Bundle();
        args.putString(URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    public ActInfoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            url = getArguments().getString(URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actinfo, container, false);
        ViewUtils.inject(this, view);
        initView();
        return view;
    }

    /**
     * 初始化数据
     */
    private void initData() {
        ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, getUrl(page), new TypeReference<CommonBean<ActInfo>>() {
        }, actInofAdapter, actInfos, ptrListView, page);
    }

    /**
     * 初始化View
     */
    private void initView() {
        bitmapUtils = XutilsHepler.getBitmapUtils(getActivity());
        bitmapUtils.configDefaultLoadingImage(R.drawable.img_default_05);
        bitmapUtils.configDefaultLoadingImage(R.drawable.img_default_05);
        ptrListView.setMode(PullToRefreshBase.Mode.BOTH);
        ptrListView.setOnScrollListener(new PauseOnScrollListener(bitmapUtils, false, true));
        ptrListView.setOnRefreshListener(this);
        ptrListView.setEmptyView(emptyView);
        actInofAdapter = new ActInofAdapter(getActivity(), actInfos, bitmapUtils);
        ptrListView.setAdapter(actInofAdapter);
        ptrListView.setRefreshing();
    }

    private String getUrl(int page) {
        return url + "&page=" + page;
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        page = 1;
        initData();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        page++;
        initData();
    }
}
