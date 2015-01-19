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
import com.qianfeng.mgp.bean.Manitio;
import com.qianfeng.mgp.utils.XutilsHepler;

import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/16
 * @修 改 人:
 * @日 期:
 */
public class ManitoAdapter extends MeBaseAdapter<Manitio> {

    public ManitoAdapter(Context context, List<Manitio> list) {
        super(context, list);
    }

    @Override
    public View createView(int i, View view, ViewGroup viewGroup) {
        Manitio manitio = list.get(i);
        ViewHodler vh = null;
        if (view == null) {
            view = inflater.inflate(R.layout.adapter_manito_item_layout, viewGroup, false);
            vh = new ViewHodler();
            ViewUtils.inject(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHodler) view.getTag();
        }
        XutilsHepler.getBitmapUtils(context).display(vh.icon, list.get(i).getIcon());
        vh.title.setText(manitio.getQname());
        vh.name.setText(manitio.getGodname());
        if (manitio.getFlag() != null && !"".equals(manitio.getFlag())) {
            if (manitio.getFlag().equals("1")) {
                vh.flag.setImageResource(R.drawable.ic_find_item_1);
            } else if (manitio.getFlag().equals("2")) {
                vh.flag.setImageResource(R.drawable.ic_find_item_2);
            } else if (manitio.getFlag().equals("3")) {
                vh.flag.setImageResource(R.drawable.ic_find_item_3);
            }
        } else {
            vh.flag.setImageResource(R.drawable.ic_find_item_1);
        }
        return view;
    }

    private static class ViewHodler {
        @ViewInject(R.id.manito_item_icon)
        private ImageView icon;
        @ViewInject(R.id.manito_item_title)
        private TextView title;
        @ViewInject(R.id.manito_item_name)
        private TextView name;
        @ViewInject(R.id.manito_item_content)
        private TextView content;
        @ViewInject(R.id.manito_item_flag)
        private ImageView flag;
    }
}
