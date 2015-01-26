package com.qianfeng.mgp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.alibaba.fastjson.TypeReference;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.ClassifysAdapter;
import com.qianfeng.mgp.bean.Classify;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.connect.ConnectUtils;
import com.qianfeng.mgp.constant.AppConstant;
import com.qianfeng.mgp.ui.ClassifyActivity;
import com.qianfeng.mgp.widget.AutoScrollViewPager;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class ClassifyFragment extends BaseFragment {
    @ViewInject(R.id.fragment_classify_gridview)
    private GridView classifyGridView;
    @ViewInject(R.id.fragment_classify_viewpager)
    private AutoScrollViewPager viewPager;
    private ClassifysAdapter adapter;
    private ArrayList<Classify> classifies = new ArrayList<Classify>();

    public ClassifyFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, container, false);
        ViewUtils.inject(this, view);
        init();
        initHeadPager(AppConstant.MANITO_HEAD_URL, viewPager);
        return view;
    }

    private void init() {
        adapter = new ClassifysAdapter(activity, classifies);
        classifyGridView.setAdapter(adapter);
        ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, AppConstant.CLASSIFY_GRID_URL, new TypeReference<CommonBean<Classify>>() {
        }, adapter, classifies);
    }


    @OnItemClick(R.id.fragment_classify_gridview)
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String type = classifies.get(position).getType();
        if (!TextUtils.isEmpty(type)) {
            Intent intent = new Intent(activity, ClassifyActivity.class);
            intent.putExtra("type", type);
            activity.startActivity(intent);
        }
    }
}
