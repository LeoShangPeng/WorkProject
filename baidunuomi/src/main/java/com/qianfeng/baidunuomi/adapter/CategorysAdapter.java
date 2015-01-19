package com.qianfeng.baidunuomi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.qianfeng.baidunuomi.R;
import com.qianfeng.baidunuomi.bean.Category;
import com.qianfeng.baidunuomi.widget.CircleImageView;

import java.util.List;

/**
 * 
 */
public class CategorysAdapter extends AppBaseAdapter<Category> {
	private BitmapUtils bitmapUtils;

	public CategorysAdapter(List<Category> list, Context context) {
		super(list, context);
		bitmapUtils = new BitmapUtils(context);
		// 配置图片保存质量
	}

	public CategorysAdapter(List<Category> list, Context context, BitmapUtils bitmapUtils) {
		super(list, context);
		this.bitmapUtils = bitmapUtils;
	}

	@Override
	public View createView(int position, View convetView, final ViewGroup parent) {
		ViewHolder vh = null;
		if (convetView == null) {
			convetView = inflater.inflate(R.layout.item_text_image_layout, parent, false);
			vh = new ViewHolder();
			ViewUtils.inject(vh, convetView);
			convetView.setTag(vh);
		} else {
			vh = (ViewHolder) convetView.getTag();
		}
		vh.name.setText(list.get(position).getCategory_name());
		bitmapUtils.configDefaultBitmapMaxSize(200, 300);
		bitmapUtils.display(vh.imageView, list.get(position).getCategory_picurl());
		return convetView;
	}

	private static class ViewHolder {
		@ViewInject(R.id.item_image)
		private CircleImageView imageView;
		@ViewInject(R.id.item_text)
		private TextView name;
	}

}
