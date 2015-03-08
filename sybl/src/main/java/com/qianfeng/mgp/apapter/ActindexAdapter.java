package com.qianfeng.mgp.apapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.bean.Actindex;
import com.qianfeng.mgp.bean.Hot;
import com.qianfeng.mgp.utils.XutilsHepler;

import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/11
 * @修 改 人:
 * @日 期:
 */
public class ActindexAdapter extends MeBaseAdapter<Actindex> {

    public ActindexAdapter(Context context, List<Actindex> list) {
        super(context, list);
    }

    @Override
    public View createView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh = null;
        if (view == null) {
            view = inflater.inflate(R.layout.actindex_list_item_layout, viewGroup, false);
            vh = new ViewHolder();
            ViewUtils.inject(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) view.getTag();
        }
        XutilsHepler.getBitmapUtils(context).display(vh.iv, list.get(i).getBimg());
        return view;
    }

    private static class ViewHolder {
        @ViewInject(R.id.actindex_item_iv)
        ImageView iv;

    }

}
