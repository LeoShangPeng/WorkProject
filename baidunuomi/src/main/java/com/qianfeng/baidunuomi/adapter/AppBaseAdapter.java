package com.qianfeng.baidunuomi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;


public abstract class AppBaseAdapter<T> extends BaseAdapter {
    public List<T> list;
    public Context context;
    public LayoutInflater inflater;

    public AppBaseAdapter(List<T> list, Context context) {
        super();
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list != null && !list.isEmpty() ? list.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convetView, ViewGroup parent) {
        return createView(position, convetView, parent);
    }

    public abstract View createView(int position, View convertView, ViewGroup parent);
}
