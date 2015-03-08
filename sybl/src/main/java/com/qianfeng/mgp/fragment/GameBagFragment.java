package com.qianfeng.mgp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alibaba.fastjson.TypeReference;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.BagAdapter;
import com.qianfeng.mgp.bean.Bag;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.connect.ConnectUtils;

import java.util.ArrayList;

/**
 * 游戏礼包界面
 */
public class GameBagFragment extends Fragment {
    @ViewInject(R.id.fragment_bag_listview)
    private ListView listView;
    private String url = "http://mobileapi.72g.com/index.php?tp=andv4/gift3&op=virlist&gifttype=1&gameid=1541";
    private BagAdapter adapter;
    private ArrayList<Bag> bags = new ArrayList<Bag>();

    public GameBagFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_bag, container, false);
        ViewUtils.inject(this, view);
        initView();
        loadData();
        return view;
    }

    private void initView() {
        adapter = new BagAdapter(getActivity(), bags);
        listView.setAdapter(adapter);
    }

    private void loadData() {
        ConnectUtils.getInstance().sendRequest(HttpRequest.HttpMethod.GET, url, new TypeReference<CommonBean<Bag>>() {
        }, adapter, bags);
    }

}
