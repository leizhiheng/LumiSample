package com.example.tangramandroid.draglist;

/**
 * Author: lzh
 * date: 2019/4/12
 * desc:
 */
public interface IDragOperation {
    void onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
