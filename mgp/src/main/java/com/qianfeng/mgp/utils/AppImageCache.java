package com.qianfeng.mgp.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;


/**
 * @author zhangwei
 * @version V1.0
 * @ClassName:
 * @类作用:
 * @email
 * @创建日期: 14/10/19 下午7:27
 */
public class AppImageCache implements ImageLoader.ImageCache {

    private static AppImageCache imageCache;
    private static LruCache<String, Bitmap> lruCache;//一级缓存强引用

    static {
        //获取系统分配给每个应用程序的最大内存，每个应用系统分配32M
        int maxSize = (int) Runtime.getRuntime().maxMemory();
        lruCache = new LruCache<String, Bitmap>(maxSize / 8) {
            /**
             * 默认缓存图片的数量 ,必须重写此方法，来测量Bitmap的大小
             *
             * @param key
             * @param value
             * @return
             */
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }

        };
    }

    private AppImageCache() {

    }

    public static AppImageCache getAppImageCache() {
        if (imageCache == null) {
            imageCache = new AppImageCache();
        }

        return  imageCache;
    }


    @Override
    public Bitmap getBitmap(String url) {
        return lruCache.get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        lruCache.put(url, bitmap);
    }
}
