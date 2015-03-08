package com.qianfeng.mgp.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.alibaba.fastjson.TypeReference;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.HomeJfAdapter;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.bean.HomeBean;
import com.qianfeng.mgp.connect.ConnectUtils;
import com.qianfeng.mgp.constant.AppConstant;
import com.qianfeng.mgp.utils.XutilsHepler;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;

/**
 *
 *
 *
 */
public class ClassifyTypeFragment extends BaseFragment implements PullToRefreshBase.OnRefreshListener2<ListView> {
    private static final String ARG_TYPE = "type";
    private static final String ARG_ORDER = "order";
    //游戏类型
    private String type;
    //1.rmtj 热门推荐  2. mdown  下载最多 3.integral 金币最多
    private String order;

    private HomeJfAdapter jiFenAdapter;
    @ViewInject(R.id.app_ptrlistview)
    private PullToRefreshListView ptrListView;

    @ViewInject(R.id.empty)
    private ImageView emptyView;

    private ArrayList<HomeBean> homeBeans = new ArrayList<>();
    private String url;
    private int page = 1;

    public static ClassifyTypeFragment newInstance(String type, String order) {
        ClassifyTypeFragment fragment = new ClassifyTypeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TYPE, type);
        args.putString(ARG_ORDER, order);
        fragment.setArguments(args);
        return fragment;
    }

    public ClassifyTypeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(ARG_TYPE);
            order = getArguments().getString(ARG_ORDER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify_type, container, false);
        ViewUtils.inject(this, view);
        initView();
        return view;
    }

    /**
     * 初始化ui
     */
    private void initView() {
        ptrListView.setEmptyView(emptyView);
        ptrListView.setOnRefreshListener(this);
        jiFenAdapter = new HomeJfAdapter(activity, homeBeans);
        ptrListView.setAdapter(jiFenAdapter);
        ptrListView.setRefreshing();
    }


    /**
     * 获取联网数据
     */
    private void sendRequest() {
        httpHandler = ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, AppConstant.getTypeUrl(type, order, page), new TypeReference<CommonBean<HomeBean>>() {
        }, jiFenAdapter, homeBeans, ptrListView, page);
    }

    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        page = 1;
        sendRequest();
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        page++;
        sendRequest();
    }

}
