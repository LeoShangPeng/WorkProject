package com.qianfeng.mgp.apapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.bean.Recommend;

import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/11
 * @修 改 人:
 * @日 期:
 */
public class RecommendAdapter extends MeBaseAdapter<Recommend> {
    BitmapUtils bitmapUtils;

    public RecommendAdapter(Context context, List<Recommend> list) {
        super(context, list);
        bitmapUtils = new BitmapUtils(context);
    }

    @Override
    public View createView(int i, View view, ViewGroup viewGroup) {
        Recommend recommend = list.get(i);
        ViewHolder vh = null;
        if (view == null) {
            view = inflater.inflate(R.layout.adapter_recommend_layout, viewGroup, false);
            vh = new ViewHolder();
            ViewUtils.inject(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        bitmapUtils.display(vh.iv, recommend.getBimg());
        vh.text.setText(recommend.getBname());
        return view;
    }

    private static class ViewHolder {
        @ViewInject(R.id.recommend_item_text)
        TextView text;
        @ViewInject(R.id.recommend_item_iv)
        ImageView iv;

    }

}
