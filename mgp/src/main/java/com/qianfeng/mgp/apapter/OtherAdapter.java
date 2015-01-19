package com.qianfeng.mgp.apapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.bean.OtherEnum;

import java.util.HashMap;
import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 14/12/12
 * @修 改 人:
 * @日 期:
 */
public class OtherAdapter extends MeBaseAdapter<OtherEnum> {

    public OtherAdapter(Context context, List<OtherEnum> list) {
        super(context, list);
    }

    @Override
    public View createView(int i, View view, ViewGroup viewGroup) {
        ViewHodler vh = null;
        if (view == null) {
            view = inflater.inflate(R.layout.adapter_other_layout, viewGroup, false);
            vh = new ViewHodler();
            ViewUtils.inject(vh, view);
            view.setTag(vh);
        } else {
            vh = (ViewHodler) view.getTag();
        }
        vh.icon.setImageResource(list.get(i).getIcon());
        vh.text.setText(list.get(i).getText());
        return view;
    }

    private static class ViewHodler {
        @ViewInject(R.id.other_item_icon)
        ImageView icon;
        @ViewInject(R.id.other_item_text)
        TextView text;
    }

}
