package com.qianfeng.mgp.apapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.core.BitmapSize;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.bean.Classify;

import java.util.List;

/**
 * @Package
 * @作 用: 分类信息Adapter
 * @创 建 人: zhangwei
 * @日 期: 15/1/19
 * @修 改 人:
 * @日 期:
 */
public class ClassifysAdapter extends MeBaseAdapter<Classify> {
    private BitmapUtils bitmapUtils;
    private String[] classifyStr = {"即时类", "回合类", "策略类", "休闲类", "动作类", "总排行"};
    public ClassifysAdapter(Context context, List<Classify> list) {
        super(context, list);
        bitmapUtils = new BitmapUtils(context);
        bitmapUtils.configDefaultLoadFailedImage(R.drawable.img_default_06);
        bitmapUtils.configDefaultLoadingImage(R.drawable.img_default_06);
    }

    @Override
    public View createView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_classify_layout, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        bitmapUtils.display(vh.img, list.get(position).getIcon());
        vh.totalTv.setText("总 " + list.get(position).getTotal() + " 款游戏");
        vh.nameTv.setText(classifyStr[position]);
        return convertView;
    }

    private static class ViewHolder {
        @ViewInject(R.id.item_classify_img)
        ImageView img;
        @ViewInject(R.id.item_classify_name)
        TextView nameTv;
        @ViewInject(R.id.item_classify_total)
        TextView totalTv;

        public ViewHolder(View view) {
            ViewUtils.inject(this, view);
        }

    }
}
