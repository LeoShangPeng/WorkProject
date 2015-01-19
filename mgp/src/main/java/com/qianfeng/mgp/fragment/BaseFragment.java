package com.qianfeng.mgp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.db.annotation.Table;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.bean.Banner;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.connect.ConnectUtils;
import com.qianfeng.mgp.constant.AppStates;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.qianfeng.mgp.fragment
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/10
 * @修 改 人:
 * @日 期:
 */
public class BaseFragment extends Fragment {
    public Activity activity;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    //添加广告栏View
    private void addBannerView(ArrayList<Banner> banners, ArrayList<View> views, PagerAdapter pagerAdapter) {
        BitmapUtils bitmapUtils = new BitmapUtils(activity);
        bitmapUtils.configDefaultLoadingImage(R.drawable.img_default_04);
        bitmapUtils.configDefaultLoadFailedImage(R.drawable.img_default_04);
        for (Banner banner : banners) {
            ImageView imageView = new ImageView(activity);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setOnClickListener(new ImageOnClickLinstner());
            bitmapUtils.display(imageView, banner.getBimg());
            views.add(imageView);
        }
        pagerAdapter.notifyDataSetChanged();
    }

    public class ImageOnClickLinstner implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
