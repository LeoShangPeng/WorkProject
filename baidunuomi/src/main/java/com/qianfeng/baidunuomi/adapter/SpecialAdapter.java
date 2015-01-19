package com.qianfeng.baidunuomi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.baidunuomi.R;
import com.qianfeng.baidunuomi.bean.Special;

import java.util.List;

/**
 * Created by 
 * zhangwei on 14/11/3.
 */
public class SpecialAdapter extends AppBaseAdapter<Special> {
    private BitmapUtils bitmapUtils;

    public SpecialAdapter(List<Special> list, Context context) {
        super(list, context);
        bitmapUtils = new BitmapUtils(context);
    }

    public SpecialAdapter(List<Special> list, Context context, BitmapUtils bitmapUtils) {
        super(list, context);
        this.bitmapUtils = bitmapUtils;
    }
    
    /**
     * 
     */
    @Override
    public View createView(int position, View convetView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convetView == null) {
            convetView = inflater.inflate(R.layout.item_image_layout, parent, false);
            vh = new ViewHolder();
            ViewUtils.inject(vh, convetView);
            convetView.setTag(vh);
        } else {
            vh = (ViewHolder) convetView.getTag();
        }
        bitmapUtils.display(vh.imageView,list.get(position).getPicture_url());
        return convetView;
    }


    private static class ViewHolder {
        @ViewInject(R.id.item_image)
        private ImageView imageView;

    }

}
