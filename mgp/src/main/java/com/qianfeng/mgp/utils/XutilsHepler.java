package com.qianfeng.mgp.utils;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;

/**
 * @Package com.qianfeng.mgp.utils
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/12
 * @修 改 人:
 * @日 期:
 */
public class XutilsHepler {
    private XutilsHepler() {
    }

    private static BitmapUtils bitmapUtils;

    /**
     * BitmapUtils不是单例的 根据需要重载多个获取实例的方法
     *
     * @param appContext application context
     * @return
     */
    public static BitmapUtils getBitmapUtils(Context appContext) {
        if (bitmapUtils == null) {
            bitmapUtils = new BitmapUtils(appContext);
        }
        return bitmapUtils;
    }
}
