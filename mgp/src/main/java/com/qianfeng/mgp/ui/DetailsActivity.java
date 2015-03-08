package com.qianfeng.mgp.ui;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.apapter.PageForFragmentAdapter;
import com.qianfeng.mgp.apapter.ViewPagerAdapter;
import com.qianfeng.mgp.bean.CommonBean;
import com.qianfeng.mgp.bean.Detail;
import com.qianfeng.mgp.connect.ConnectUtils;
import com.qianfeng.mgp.constant.AppConstant;
import com.qianfeng.mgp.fragment.CommentFragment;
import com.qianfeng.mgp.fragment.GameBagFragment;
import com.qianfeng.mgp.fragment.GamePreFragment;
import com.qianfeng.mgp.utils.XutilsHepler;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * 点击详情界面
 * 此类没有封装
 */
@ContentView(R.layout.activity_details)
public class DetailsActivity extends ActionBarActivity implements View.OnClickListener {
    private PopupWindow popupWindow;
    public static final String[] TITLES = {"游戏礼包", "游戏专区", "评论"};
    @ViewInject(R.id.details_viewpager)
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;
    private ArrayList<View> views = new ArrayList<View>();
    private PopViewHolder pvh;
    private Detail detail;
    private HttpUtils httpUtils;
    private String url = "http://mobileapi.72g.com/index.php?tp=andv4/game3&op=detail&id=1541";
    private View actionBarView;
    private boolean isFirst = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
        initActionBar();
        initView();
        initPopupWindow();
        loadData();
    }

    private void initActionBar() {
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        actionBarView = getLayoutInflater().inflate(R.layout.action_detail_layout, null);
        TextView title = (TextView) actionBarView.findViewById(R.id.action_detail_title);
        title.setText("详情界面");
        getSupportActionBar().setCustomView(actionBarView, new android.support.v7.app.ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
    }

    /**
     * 初始化ui
     */
    private void initView() {
        pagerAdapter = new ViewPagerAdapter(views);
        viewPager.setAdapter(pagerAdapter);
    }

    /**
     * 加载数据
     */
    private void loadData() {
        httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new RequestCallBack<String>() {
            /**
             * 加载数据成功的回调方法
             * @param responseInfo
             */

            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                if (!TextUtils.isEmpty(responseInfo.result)) {
                    CommonBean<Detail> commonBean = JSONObject.parseObject(responseInfo.result, new TypeReference<CommonBean<Detail>>() {
                    });
                    if (commonBean != null && !TextUtils.isEmpty(commonBean.getState()) && commonBean.getState().equals(AppConstant.SUCCESS)) {
                        List<Detail> details = commonBean.getInfo();
                        if (details != null && !details.isEmpty()) {
                            detail = details.get(0);
                            initViewpagerView();
                        }
                    }
                }
            }

            /**
             * 加载数据失败的回调方法
             * @param error
             * @param msg
             */
            @Override
            public void onFailure(HttpException error, String msg) {
            }
        });
    }

    private void initViewpagerView() {
        String imgUrl = detail.getImg();
        if (!TextUtils.isEmpty(imgUrl)) {
            String[] imgUrls = imgUrl.split(",");
            if (imgUrls != null && imgUrl.length() > 0) {
                for (int i = 0; i < imgUrls.length; i++) {
                    ImageView img = new ImageView(this);
                    ViewGroup.LayoutParams p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    img.setLayoutParams(p);
                    img.setScaleType(ImageView.ScaleType.FIT_XY);
                    img.setOnClickListener(this);
                    XutilsHepler.getBitmapUtils(this).display(img, imgUrls[i]);
                    views.add(img);
                }
            }
            pagerAdapter.notifyDataSetChanged();
        }

    }

    /**
     * 初始化PopupWindow
     */
    private void initPopupWindow() {
        popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        //设置popwindow的背景颜色
        popupWindow.setBackgroundDrawable(new ColorDrawable(R.color.grey));
        View popContentView = createPopContentView();
        //设置显示的View
        popupWindow.setContentView(popContentView);
        //设置点击PopupWindow以外的地方popwindow隐藏
    }

    /**
     * 创建popwindowContentView
     *
     * @return
     */
    private View createPopContentView() {
        View view = getLayoutInflater().inflate(R.layout.pop_details_layout, null);
        pvh = new PopViewHolder(view);
        return view;
    }

    private class PopViewHolder {
        /**
         * 圆形头像
         */
        @ViewInject(R.id.pop_detail_roundImage)
        private ImageView roundImageView;
        @ViewInject(R.id.pop_detail_title)
        private TextView title;
        @ViewInject(R.id.pop_detail_downum)
        private TextView downNumTv;
        @ViewInject(R.id.pop_detail_versize)
        private TextView verSizeTv;

        @ViewInject(R.id.pop_details_tpi)
        private TabPageIndicator indicator;
        @ViewInject(R.id.pop_details_viewpager)
        private ViewPager viewPager;
        public PageForFragmentAdapter adapter;
        private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

        private PopViewHolder(View view) {
            ViewUtils.inject(this, view);
            initTabPageIndicator();
        }

        private void initTabPageIndicator() {
            fragments.add(new GameBagFragment());
            fragments.add(new GamePreFragment());
            fragments.add(new CommentFragment());
            adapter = new PageForFragmentAdapter(fragments, getSupportFragmentManager(), TITLES);
            viewPager.setAdapter(adapter);
            indicator.setViewPager(viewPager);
        }
    }

    @Override
    public void onClick(View v) {
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            } else {
                popupWindow.showAsDropDown(actionBarView, 0, 200);
            }
        }
        if (getSupportActionBar().isShowing()){
            getSupportActionBar().hide();
        }else {
            getSupportActionBar().show();
        }

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            popupWindow.showAsDropDown(actionBarView, 0, 200);
        }
    }
}
