package com.qianfeng.baidunuomi.fragment;

import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.view.annotation.ViewInject;

import com.qianfeng.baidunuomi.R;
import com.qianfeng.baidunuomi.adapter.CategorysAdapter;
import com.qianfeng.baidunuomi.adapter.ImagePagerAdapter;
import com.qianfeng.baidunuomi.adapter.RecommendAdapter;
import com.qianfeng.baidunuomi.adapter.SpecialAdapter;
import com.qianfeng.baidunuomi.bean.Banner;
import com.qianfeng.baidunuomi.bean.Category;
import com.qianfeng.baidunuomi.bean.Data;
import com.qianfeng.baidunuomi.bean.HeadBean;
import com.qianfeng.baidunuomi.bean.Recommend;
import com.qianfeng.baidunuomi.bean.Special;
import com.qianfeng.baidunuomi.utils.AppConstants;
import com.qianfeng.baidunuomi.widget.AutoScrollViewPager;
import com.qianfeng.baidunuomi.widget.GridViewForScrollView;
import com.qianfeng.baidunuomi.widget.ListViewForScrollView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/**
 * 控件初始化完毕 javabean数据;---- 第一从网络获取 第二 从本地数据库 apapter
 *
 * @author zhangwei
 */
public class HomeFragment extends BaseFragment {
    /**
     * 广告
     */
    @ViewInject(R.id.groupbuy_head_banners_viewpager)
    private AutoScrollViewPager viewPager;
    private ImagePagerAdapter imagePagerAdapter;
    private ArrayList<View> imageViews = new ArrayList<View>();
    private ArrayList<Banner> banners = new ArrayList<Banner>();

    /**
     * 分类
     */
    @ViewInject(R.id.groupbuy_head_category_gridview)
    private GridViewForScrollView categoryGridView;
    private ArrayList<Category> categorys = new ArrayList<Category>();
    /** */
    private CategorysAdapter categorysAdapter;

    /**
     * 特色gridview
     */
    @ViewInject(R.id.groupbuy_head_special_gridview)
    private GridViewForScrollView specialGridview;
    private SpecialAdapter specialAdapter;
    private ArrayList<Special> specials = new ArrayList<Special>();

    /**
     * 达人
     */
    @ViewInject(R.id.groupbuy_head_recommend_listview)
    private ListViewForScrollView recommendListView;
    private RecommendAdapter recommendAdapter;
    private ArrayList<Recommend> recommends = new ArrayList<Recommend>();

    private HttpUtils httpUtils = new HttpUtils();
    private BitmapUtils bitmapUtils;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bitmapUtils = new BitmapUtils(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ViewUtils.inject(this, view);
        initView();
        loadData();
        return view;
    }

    /**
     * 初始化控件
     */
    public void initView() {
        initSpecialGridview();
        initCategorysGridview();
        initRecommend();
    }

    /**
     * 分类GridView关联数据
     */
    private void initCategorysGridview() {
        categorysAdapter = new CategorysAdapter(categorys, activity, bitmapUtils);
        categoryGridView.setAdapter(categorysAdapter);
    }

    /**
     * 特色GridView关联数据
     */
    private void initSpecialGridview() {
        specialAdapter = new SpecialAdapter(specials, activity, bitmapUtils);
        specialGridview.setAdapter(specialAdapter);
    }

    /**
     * 达人推荐
     */
    private void initRecommend() {
        recommendAdapter = new RecommendAdapter(recommends, activity);
        recommendListView.setAdapter(recommendAdapter);
    }

    private void loadData() {
        httpUtils.send(HttpMethod.GET, AppConstants.GROUP_BUY_URL, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                if (result != null) {
                    HeadBean bean = JSONObject.parseObject(result, HeadBean.class);
                    if (bean != null && bean.getMsg() != null && bean.getMsg().equals("success") && bean.getData() != null) {
                        Data data = bean.getData();
                        categorys.addAll(data.getCategory());
                        specials.addAll(data.getSpecial());
                        recommends.addAll(data.getRecommend());
                        banners.addAll(data.getBanners());
                        recommendAdapter.notifyDataSetChanged();
                        specialAdapter.notifyDataSetChanged();
                        categorysAdapter.notifyDataSetChanged();
                        initBannerView();
                    }
                }
            }

            @Override
            public void onFailure(HttpException error, String msg) {

            }
        });

    }

    private void initBannerView() {
        for (int i = 0; i < banners.size(); i++) {
            ImageView imageView = new ImageView(activity);
            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            bitmapUtils.display(imageView, banners.get(i).getPicture_url());
            imageViews.add(imageView);
        }
        viewPager.startAutoScroll();
        imagePagerAdapter = new ImagePagerAdapter(imageViews);
        viewPager.setAdapter(imagePagerAdapter);
    }

}
