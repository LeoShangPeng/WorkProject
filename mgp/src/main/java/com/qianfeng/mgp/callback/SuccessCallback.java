package com.qianfeng.mgp.callback;

import com.qianfeng.mgp.bean.CommonBean;

/**
 * @Package com.qianfeng.mgp.callback
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/10
 * @修 改 人:
 * @日 期:
 */
public interface SuccessCallback <T>{
    public  void successCallback(CommonBean<T> commonBean);
}
