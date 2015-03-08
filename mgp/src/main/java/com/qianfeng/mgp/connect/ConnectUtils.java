package com.qianfeng.mgp.connect;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.bean.Banner;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.constant.AppConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.qianfeng.mgp.connect
 * @作 用:联网工具类
 * @创 建 人: zhangwei
 * @日 期: 14/12/10
 * @修 改 人:
 * @日 期:
 */
public class ConnectUtils<T> {
    private static ConnectUtils connect;
    private HttpUtils httpUtils;

    public ConnectUtils() {
        httpUtils = new HttpUtils();
    }

    public static ConnectUtils getInstance() {
        if (connect == null) {
            connect = new ConnectUtils();
        }
        return connect;
    }


    public <T> HttpHandler sendRequest(HttpRequest.HttpMethod method, final String url, final TypeReference<CommonBean<T>> type, final BaseAdapter adapter, final List<T> list) {

        HttpHandler httpHandler = httpUtils.send(method, AppConstant.getUrl(url), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                if (result != null && !"".equals(result)) {
                    CommonBean<T> bean = JSONObject.parseObject(result, type);
                    if (bean != null) {
                        list.addAll(bean.getInfo());
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }

            @Override
            public void onFailure(HttpException error, String msg) {

            }
        });

        return httpHandler;
    }

    public <T> HttpHandler sendRequest(HttpRequest.HttpMethod method, final String url, final TypeReference<CommonBean<T>> type, final BaseAdapter adapter, final List<T> list, final PullToRefreshListView ptrListView, final int page) {

        HttpHandler handler = httpUtils.send(method, AppConstant.getUrl(url), new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                if (result != null && !"".equals(result)) {
                    CommonBean<T> bean = JSONObject.parseObject(result, type);
                    if (bean != null) {
                        if (page == 1 && !list.isEmpty()) {
                            list.clear();
                        }
                        list.addAll(bean.getInfo());
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                    }
                    if (ptrListView != null) {
                        ptrListView.onRefreshComplete();
                    }
                    if (bean.getPage().getTotal() <= 10 * page) {
                        ptrListView.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
                    } else {
                        ptrListView.setMode(PullToRefreshBase.Mode.BOTH);
                    }
                }

            }

            @Override
            public void onFailure(HttpException error, String msg) {

            }
        });

        return handler;
    }

    /**
     * @param activity     上下文
     * @param method       请求方式
     * @param url          请求的url
     * @param type         转化类型参数
     * @param views
     * @param pagerAdapter 适配器
     * @param l            单击事件
     * @param <T>
     */
    public <T> void sendRequestForViewPager(final Context activity, HttpRequest.HttpMethod method, String url, final TypeReference<CommonBean<T>> type, final ArrayList<View> views, final PagerAdapter pagerAdapter, final View.OnClickListener l) {

        httpUtils.send(method, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                if (result != null) {
                    CommonBean<T> bean = JSONObject.parseObject(result, type);
                    if (bean != null && bean.getInfo() != null && !bean.getInfo().isEmpty()) {
                        BitmapUtils bitmapUtils = new BitmapUtils(activity);
                        bitmapUtils.configDefaultLoadingImage(R.drawable.img_default_04);
                        bitmapUtils.configDefaultLoadFailedImage(R.drawable.img_default_04);
                        ArrayList<Banner> banners = (ArrayList<Banner>) bean.getInfo();
                        for (Banner banner : banners) {
                            ImageView imageView = new ImageView(activity);
                            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            imageView.setLayoutParams(params);
                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                            if (l != null) {
                                imageView.setOnClickListener(l);
                            }
                            bitmapUtils.display(imageView, banner.getBimg());
                            views.add(imageView);
                        }
                        pagerAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(HttpException error, String msg) {

            }
        });
    }


    public void cancel() {
    }

}
