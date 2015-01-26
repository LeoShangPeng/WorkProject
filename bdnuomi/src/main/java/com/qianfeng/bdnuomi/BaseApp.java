package com.qianfeng.bdnuomi;

import android.app.Application;
import android.graphics.Bitmap;

import com.lidroid.app.AppUtils;
import com.lidroid.other.ExceptionHandler;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.util.LogUtils;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.qianfeng.bdnuomi.net.NetChangeObserver;
import com.qianfeng.bdnuomi.net.NetWorkUtil;
import com.qianfeng.bdnuomi.net.NetworkStateReceiver;

/**
 * @Package com.qianfeng.bdnuomi
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/26
 * @修 改 人:
 * @日 期:
 * <p/>
 * 图片处理
 * 全局异常处理
 * 数据库设置
 * 第三方功能
 * 全局Log
 * Toast
 * Dialog
 * 网络判断
 */
public class BaseApp extends Application {
    private NetChangeObserver netChangeObserver = new myNetState();
    private static BaseApp app;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
//        AppUtils.getAppUtils().init(this);
//        //初始化网络监听
//        initNetWork();
//        ExceptionHandler handler = ExceptionHandler.getInstance();
//        handler.sendPreviousReportsToServer();
//        initLog();
    }

    public static BaseApp getInstance() {
        return app;
    }

    private void initBitmapUtils() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration
                .Builder(this)
                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)//线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(new BaseImageDownloader(this, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();//开始构建
        ImageLoader.getInstance().init(config);

    }

    /**
     * 初始化数据库
     */
    private void initDb() {
        DbUtils.DaoConfig daoConfig = new DbUtils.DaoConfig(this);
        daoConfig.setDbDir("sd卡/根目录+ db");
        daoConfig.setDbName("qianfeng.db");
        daoConfig.setDbVersion(2);
        daoConfig.setDbUpgradeListener(new DbUtils.DbUpgradeListener() {

            @Override
            public void onUpgrade(DbUtils db, int oldVersion, int newVersion) {

            }
        });
    }

    public void initNetWork() {
        NetworkStateReceiver.registerNetworkStateReceiver(this);
        NetworkStateReceiver.registerObserver(netChangeObserver);
    }

    public class myNetState extends NetChangeObserver {
        @Override
        public void onConnect(NetWorkUtil.NetType type) {
            super.onConnect(type);
            switch (type) {
                case wifi:
                    break;
            }
        }

        @Override
        public void onDisConnect() {
            super.onDisConnect();
        }
    }

    public void nRegisterNetworkStateReceiver() {
        NetworkStateReceiver.unRegisterNetworkStateReceiver(this);
    }

    private void initLog() {
        LogUtils.allowD = false;
        LogUtils.allowE = false;
        LogUtils.allowI = false;
    }


}
