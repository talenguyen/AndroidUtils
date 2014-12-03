package com.tale.androidutils.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tale on 11/17/14.
 */
public abstract class RecyclerTypedAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    private List<T> mDataSet;

    public void changeDataSet(List<T> newDataSet) {
        if (mDataSet != null) {
            mDataSet.clear();
        }

        mDataSet = new ArrayList<T>();
        mDataSet.addAll(newDataSet);
        notifyDataSetChanged();
    }

    public T getItem(int position) {
        return mDataSet.get(position);
    }

    public void addItem(T newItem) {
        if (mDataSet == null) {
            mDataSet = new ArrayList<T>();
        }
        mDataSet.add(newItem);
    }

    public void remove(T item) {
        if (mDataSet != null) {
            mDataSet.remove(item);
        }
    }

    @Override public int getItemCount() {
        return mDataSet == null ? 0 : mDataSet.size();
    }
}
