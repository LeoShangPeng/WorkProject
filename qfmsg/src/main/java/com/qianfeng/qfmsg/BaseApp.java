package com.qianfeng.qfmsg;

import android.app.Application;

import com.lidroid.app.AppUtils;

/**
 * @Package com.qianfeng.qfmsg
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/2/4
 * @修 改 人:
 * @日 期:
 */
public class BaseApp extends Application {
    private static BaseApp app;
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        AppUtils.getAppUtils().init(this);
    }

    public static BaseApp getInstance() {
        return app;
    }
}
