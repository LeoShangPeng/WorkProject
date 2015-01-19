package com.qianfeng.mgp.apapter;


import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.mgp.R;
import com.qianfeng.mgp.bean.HomeBean;
import com.qianfeng.mgp.download.DownloadManager;


import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HomeJfAdapter extends MeBaseAdapter<HomeBean> {
    private BitmapUtils bitmapUtils;

    public HomeJfAdapter(Context context, List<HomeBean> list) {
        super(context, list);
        bitmapUtils = new BitmapUtils(context);
        bitmapUtils.configDefaultLoadingImage(R.drawable.img_default_05);
    }

    public HomeJfAdapter(Context context, List<HomeBean> list, DownloadManager downloadManager) {
        this(context, list);
    }

    @Override
    public View createView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.adapter_home_layout, viewGroup, false);
            holder = new ViewHolder();
            ViewUtils.inject(holder, view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        bitmapUtils.display(holder.image, list.get(i).getIcon());
        holder.title.setText(list.get(i).getName());
        holder.size.setText(list.get(i).getSize());
        holder.number.setText(list.get(i).getMdown());
        holder.gold.setText("+" + list.get(i).getIntegral() + "金币");
//        holder.down.setOnClickListener(new DownOnClickListener(i, holder));
        return view;
    }

    private static class ViewHolder {
        @ViewInject(R.id.home_item_iocn)
        ImageView image;
        @ViewInject(R.id.home_item_down)
        Button down;
        @ViewInject(R.id.home_item_title)
        TextView title;
        @ViewInject(R.id.home_item_size)
        TextView size;
        @ViewInject(R.id.home_item_gold)
        TextView gold;
        @ViewInject(R.id.home_item_number)
        TextView number;

    }

    public class DownOnClickListener implements OnClickListener {
        private int position;
        private ViewHolder vh;

        public DownOnClickListener(int position, ViewHolder vh) {
            super();
            this.position = position;
            this.vh = vh;
        }

        @Override
        public void onClick(View v) {
        }
    }


}
