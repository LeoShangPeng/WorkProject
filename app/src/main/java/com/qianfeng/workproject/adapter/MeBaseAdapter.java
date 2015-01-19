package com.qianfeng.workproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @version v1.0
 * @类描述：
 * @项目名称：
 * @包 名： com.qianfeng.studydemo.adapter
 * @类名称：BaseAdapter
 * @创建人：张唯
 * @创建时间：14-10-2
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public abstract class MeBaseAdapter<T> extends BaseAdapter {
    public List<T> list;
    public LayoutInflater inflater;
    public Context context;
    public MeBaseAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return createView(i, view, viewGroup);
    }

    public abstract View createView(int i, View view, ViewGroup viewGroup);

}