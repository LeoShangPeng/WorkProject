package com.qianfeng.mgp.apapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.bean.Hot;
import com.qianfeng.mgp.utils.XutilsHepler;
import com.qianfeng.mgp.widget.CircleImageView;


import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/11
 * @修 改 人:
 * @日 期:
 */
public class HotAdapter extends MeBaseAdapter<Hot> {
    BitmapUtils bitmapUtils ;
    public HotAdapter(Context context, List<Hot> list) {
        super(context, list);
        bitmapUtils = XutilsHepler.getBitmapUtils(context);
        bitmapUtils.configDefaultLoadFailedImage(R.drawable.ic_launcher);
        bitmapUtils.configDefaultLoadingImage(R.drawable.ic_launcher);
    }

    @Override
    public View createView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh = null;
        if (view == null) {
            view = inflater.inflate(R.layout.adapter_hot_layout, viewGroup, false);
            vh = new ViewHolder();
            ViewUtils.inject(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        bitmapUtils.display(vh.civ, list.get(i).getIcon());
        vh.text.setText(list.get(i).getName());
        return view;
    }

    private static class ViewHolder {
        @ViewInject(R.id.hot_item_civ)
        CircleImageView civ;
        @ViewInject(R.id.hot_item_text)
        TextView text;
    }

}
