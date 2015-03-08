package com.qianfeng.mgp.utils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.qianfeng.mgp.BaseApplication;


/**
 * @author zhangwei
 * @version V1.0
 * @ClassName:
 * @类作用: Volley帮助类
 * @email
 * @创建日期:
 */
public class VolleyHepler {
    private static VolleyHepler hepler;
    private RequestQueue mRequestQueue;
    private ImageLoader imageLoader;

    private VolleyHepler() {
        mRequestQueue = getRequestQueue();
        imageLoader = new ImageLoader(mRequestQueue, AppImageCache.getAppImageCache());

    }

    /**
     * 同步锁保证只有一个线程能访问此方法
     *
     * @return
     */
    public static synchronized VolleyHepler getInstance() {
        if (hepler == null) {
            hepler = new VolleyHepler();
        }
        return hepler;
    }

    /**
     * 初始化 请求队列
     * @return
     */
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            //它的使用情景为：你需要一个生命周期独立于当前上下文的全局上下文，
            //即就是它的存活时间绑定在进程中而不是当前某个组建。
            mRequestQueue = Volley.newRequestQueue(BaseApplication.getApp());
        }
        return mRequestQueue;
    }

    /**
     * 添加请求
     * @param request
     * @param <T>
     */
    public <T> void addRequest(Request<T> request) {
        getRequestQueue().add(request);
    }

    /**
     * 图片加载Imageloader
     * @return
     */
    public ImageLoader getImageLoader(){
        return  imageLoader;
    }

}
