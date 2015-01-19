package com.qianfeng.baidunuomi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianfeng.baidunuomi.R;
import com.qianfeng.baidunuomi.bean.Recommend;
import com.qianfeng.baidunuomi.widget.CircleImageView1;

import java.util.List;

/**
 *
 */
public class RecommendAdapter extends AppBaseAdapter<Recommend> {

	public RecommendAdapter(List<Recommend> list, Context context) {
		super(list, context);
	}

	@Override
	public View createView(int position, View convetView, ViewGroup parent) {
		ViewHolder vh = null;
		if (convetView == null) {
			convetView = inflater.inflate(R.layout.recommend_item_layout, parent, false);
			vh = new ViewHolder();
			ViewUtils.inject(vh, convetView);
			convetView.setTag(vh);
		} else {
			vh = (ViewHolder) convetView.getTag();
		}
		vh.nameTv.setText(list.get(position).getMan_name());
		vh.contenTv.setText(list.get(position).getMan_desc());
		// 
		ImageLoader.getInstance().displayImage(list.get(position).getRecommend_image(), vh.img);
		// ImageLoader.getInstance().displayImage(list.get(position).getMan_pic(),vh.headIv,BaseApplication.getApplication().getDisplayImageOptions());
		return convetView;
	}

	private static class ViewHolder {
		@ViewInject(R.id.recommend_item_head)
		private CircleImageView1 headIv;
		@ViewInject(R.id.recommend_item_name)
		private TextView nameTv;
		@ViewInject(R.id.recommend_item_content)
		private TextView contenTv;
		@ViewInject(R.id.recommend_item_img)
		private ImageView img;

	}
}
