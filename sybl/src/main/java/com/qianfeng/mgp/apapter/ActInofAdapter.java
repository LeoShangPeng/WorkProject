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
import com.qianfeng.mgp.bean.ActInfo;


import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/25
 * @修 改 人:
 * @日 期:
 */
public class ActInofAdapter extends MeBaseAdapter<ActInfo> {
    private BitmapUtils bitmapUtils;

    public ActInofAdapter(Context context, List<ActInfo> list, BitmapUtils bitmapUtils) {
        super(context, list);
        this.bitmapUtils = bitmapUtils;
    }

    @Override
    public View createView(int position, View view, ViewGroup viewGroup) {
        ViewHolder vh = null;
        if (view == null) {
            view = inflater.inflate(R.layout.list_actinfo_item_layout, viewGroup, false);
            vh = new ViewHolder(view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        bitmapUtils.display(vh.img, list.get(position).getApic());
        vh.nameTv.setText(list.get(position).getAname());
        vh.shortNameTv.setText(list.get(position).getShortname());
        vh.totalTv.setText(new StringBuffer().append(list.get(position).getTotal()).append("人已参加").toString());
        return view;
    }

    private static class ViewHolder {
        @ViewInject(R.id.item_actinfo_img)
        private ImageView img;
        @ViewInject(R.id.item_actinfo_name)
        private TextView nameTv;
        @ViewInject(R.id.item_actinfo_shortName)
        private TextView shortNameTv;
        @ViewInject(R.id.item_actinfo_total)
        private TextView totalTv;

        private ViewHolder(View view) {
            ViewUtils.inject(this, view);
        }
    }

}
