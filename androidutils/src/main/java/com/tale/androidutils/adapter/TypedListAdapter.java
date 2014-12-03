package com.tale.androidutils.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class TypedListAdapter<T> extends TypedBaseAdapter<T> {

    private final List<T> dataSet = new ArrayList<T>();

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public T getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);

    public List<T> getData() {
        return new ArrayList<T>(dataSet);
    }

    public void changeDataSet(List<T> dataSet) {
        this.dataSet.clear();
        this.dataSet.addAll(dataSet);
        notifyDataSetChanged();
    }

    public void clear() {
        this.dataSet.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<T> elements) {
        this.dataSet.addAll(elements);
        notifyDataSetChanged();
    }

    public void add(T element) {
        this.dataSet.add(element);
    }
}
