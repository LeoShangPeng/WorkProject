package com.qianfeng.mgp.apapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.mgp.bean.Bag;

import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/3/8
 * @修 改 人:
 * @日 期:
 */
public class BagAdapter extends MeBaseAdapter<Bag> {

    public BagAdapter(Context context, List<Bag> list) {
        super(context, list);
    }

    @Override
    public View createView(int position, View view, ViewGroup viewGroup) {
        return null;
    }


}
