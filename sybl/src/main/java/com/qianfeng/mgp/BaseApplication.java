package com.qianfeng.mgp;

import android.app.Application;

import com.lidroid.app.AppUtils;

/**
 * @Package com.qianfeng.mgp
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/6
 * @修 改 人:
 * @日 期:
 */
public class BaseApplication extends Application {
    private static BaseApplication app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
//        AppUtils.getAppUtils().init(app);
    }

    public static BaseApplication getApp() {
        return app;
    }
}
