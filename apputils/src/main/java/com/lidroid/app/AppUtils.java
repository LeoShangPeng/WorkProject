package com.lidroid.app;

import android.app.Application;
import android.widget.Toast;

import com.lidroid.dialog.DialogImpl;
import com.lidroid.dialog.IDialog;
import com.lidroid.netstate.NetChangeObserver;
import com.lidroid.netstate.NetWorkUtil;
import com.lidroid.netstate.NetworkStateReceiver;
import com.lidroid.other.ExceptionHandler;
import com.lidroid.other.FileUtil;
import com.lidroid.other.Logger;
import com.lidroid.xutils.DbUtils;

import java.io.File;
import java.util.HashMap;


public class AppUtils {
    private static AppUtils appUtils;
    private DbUtils.DaoConfig config;
    private DbUtils db;
    /**
     * Application对象
     */
    private Application application;

    /**
     * 默认高度和宽度,所有的缩放比根据这个常数来获得
     */
    private int mode_w = 480;
    private int mode_h = 800;
    private HashMap<String, DbUtils> dbMap = new HashMap<String, DbUtils>();
    private NetChangeObserver netChangeObserver;


    private IDialog iDialog;


    private AppUtils() {

    }

    /**
     * 单例模式获取全局应用初始化工具类
     *
     * @return
     */
    public static AppUtils getAppUtils() {
        if (appUtils == null) {
            appUtils = new AppUtils();
        }
        return appUtils;
    }

    /**
     * 获取应用程序启动类
     *
     * @return
     */
    public Application getApplication() {
        return application;
    }

    /**
     * 获取程序logger日志
     *
     * @return
     */

    /**
     * 注册全局应用程序工具类
     *
     * @param app
     */
    public void init(Application app) {
        Logger.init(app.getApplicationContext());
        application = app;
        FileUtil.init(app.getApplicationContext());
        //捕获程序异常
        ExceptionHandler handler = ExceptionHandler.getInstance();
        //注册全局异常处理
        handler.init(app);
        // 发送以前没发送的报告(可选)
        handler.sendPreviousReportsToServer();
//        注册网络监听广播类
        NetworkStateReceiver.registerNetworkStateReceiver(app.getApplicationContext());
        netChangeObserver = new MeNetChangeObserver();
        NetworkStateReceiver.registerObserver(netChangeObserver);
        DBConfigMethod();
    }

    public IDialog getiDialog() {
        if (iDialog == null) {
            iDialog = new DialogImpl();
        }
        return iDialog;
    }


    /**
     * 数据库配置
     */
    private void DBConfigMethod() {
        config = new DbUtils.DaoConfig(application);
        config.setDbDir("qianfeng");
        config.setDbName("qianfeng.db");
        config.setDbVersion(1);
    }

    /**
     * 获取默认的数据库操作工具类
     *
     * @return
     */
    public DbUtils getDb() {
        return getDb(null, config.getDbName());
    }

    /**
     * 获取数据库操作类
     *
     * @param dbDirs 数据库路径
     * @param dbName //数据库名称
     * @return
     */
    public DbUtils getDb(String dbDirs, String dbName) {
        String key = dbDirs == null ? dbName : dbDirs + dbName;
        if (dbMap.containsKey(key)) {
            return dbMap.get(key);
        }


        if (dbDirs == null) {
            db = DbUtils.create(application, dbName);
            dbMap.put(dbName, db);
        } else {
            File file = new File(dbDirs);
            if (!file.exists()) {
                file.mkdirs();
            }
            db = DbUtils.create(application.getApplicationContext(), dbDirs, dbName);
            dbMap.put(dbDirs + dbName, db);
        }
        db.configDebug(true);
        db.configAllowTransaction(true);
        return db;
    }

    public void showToast(String msg) {
        Toast.makeText(application, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 注销网络监听
     */
    public void UnRegisterNetworkStateReceiver() {
        NetworkStateReceiver.unRegisterNetworkStateReceiver(application);
        //移除网络改变观察者
        NetworkStateReceiver.removeRegisterObserver(netChangeObserver);

    }


    private class MeNetChangeObserver extends NetChangeObserver {

        @Override
        public void onConnect(NetWorkUtil.NetType type) {
            super.onConnect(type);
            switch (type) {
                case wifi:
                    showToast("当前wifi已连接");
                    break;
            }

        }

        @Override
        public void onDisConnect() {
            super.onDisConnect();
            showToast("当前网络不可用");
        }
    }

    public int getMode_h() {
        return mode_h;
    }

    public void setMode_h(int mode_h) {
        this.mode_h = mode_h;
    }

    public int getMode_w() {
        return mode_w;
    }

    public void setMode_w(int mode_w) {
        this.mode_w = mode_w;
    }
}
