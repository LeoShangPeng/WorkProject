package com.qianfeng.mgp.apapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qianfeng.mgp.R;

import java.util.List;

/**
 * @Package com.qianfeng.mgp.apapter
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/25
 * @修 改 人:
 * @日 期:
 */
public class ViewHolderAdapter<T,ViewHodler> extends BaseAdapter {
    public List<T> list;
    public LayoutInflater inflater;
    public Context context;
    private int layoutId;

    public ViewHolderAdapter(Context context, List<T> list,int layoutId) {
        this.context = context;
        this.list = list;
        this.layoutId = layoutId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list != null && !list.isEmpty() ? list.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null){
            convertView = inflater.inflate(layoutId,parent,false);
            vh = new ViewHolder();
            convertView.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }
        return null;
    }
}
