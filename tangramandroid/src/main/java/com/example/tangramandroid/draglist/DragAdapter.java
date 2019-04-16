package com.example.tangramandroid.draglist;

import android.content.Context;

import com.example.tangramandroid.simplelist.SimpleRvAdapter;

import java.util.Collections;

/**
 * Author: lzh
 * date: 2019/4/12
 * desc:
 */
public class DragAdapter extends SimpleRvAdapter implements IDragOperation{
    public DragAdapter(Context context) {
        super(context);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        notifyDataSetChanged();
    }

    @Override
    public void onItemDismiss(int position) {

    }
}
