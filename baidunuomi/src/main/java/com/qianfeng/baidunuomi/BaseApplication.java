package com.qianfeng.baidunuomi;

import java.io.File;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import android.app.Application;

/**
 * 跟程序声明周期联动
 *
 * @author zhangwei
 */
public class BaseApplication extends Application {

    private static BaseApplication app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initImageLoaderConfiguration();
        bitmapGlobalConfig();
    }

    public static BaseApplication getApplication() {
        return app;
    }

    private void initImageLoaderConfiguration() {
        ImageLoaderConfiguration.Builder builder = new ImageLoaderConfiguration.Builder(this);
        // 设置缓存路径
        File imageCache = StorageUtils.getOwnCacheDirectory(this, "bdnm/imageCache");
        builder.diskCache(new UnlimitedDiscCache(imageCache));
        // ImageLoaderConfiguration.Builder builder = new
        // ImageLoaderConfiguration.Builder(this);
        builder.memoryCacheExtraOptions(480, 800);// max width, max
        // height，即保存的每个缓存文件的最大长宽
        // 线程池内加载的数量 范围3-5之间
        builder.threadPoolSize(5);
        // 线程的优先级别
        // builder.threadPriority(Thread.NORM_PRIORITY - 2)
        /**
         * ImageLoaderConfiguration
         * 配置中的.discCacheFileNameGenerator()方法是将缓存下来的文件以什么方式命名 里面可以调用的方法有 1.new
         * Md5FileNameGenerator() //使用MD5对UIL进行加密命名 2.new
         * HashCodeFileNameGenerator()//使用HASHCODE对UIL进行加密命名
         */
        builder.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        // 配置缓存图片的数量 保存在磁盘里的图片最大数量
        builder.diskCacheFileCount(100);

        // 设置默认连接超时时间5s,默认读取超时时间20s
        builder.imageDownloader(new BaseImageDownloader(this, 5 * 1000, 20 * 1000));
        /**
         * 注册框架全局配置
         */
        ImageLoader.getInstance().init(builder.build());

    }

    private void bitmapGlobalConfig() {

    }

}
