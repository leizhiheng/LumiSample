package com.example.tangramandroid.simplelist;

import android.graphics.Color;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Collections;
import java.util.List;

/**
 * Author: lzh
 * date: 2019/4/12
 * desc:
 */
public class ItemTouchCallback extends ItemTouchHelper.Callback{

    private boolean mIsCanDrag = true;
    private ItemDragAndMoveListener mItemDragAndMoveListener;

    public ItemTouchCallback(boolean isCanDrag) {
        this.mIsCanDrag = isCanDrag;
    }

    public interface ItemDragAndMoveListener {
        void onMove(int fromPosition, int targetPosition);
        void onSwipe(int postion);
    }

    public void setItemDragAndMoveListener(ItemDragAndMoveListener listener) {
        this.mItemDragAndMoveListener = listener;
    }

    public void setIsCanDrag(boolean isCanDrag) {
        this.mIsCanDrag = isCanDrag;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 获取触摸响应的方向   包含两个 1.拖动dragFlags 2.侧滑删除swipeFlags
        // 代表只能是向左侧滑删除，当前可以是这样ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT
        //int swipeFlags = ItemTouchHelper.LEFT;

        // 拖动
        int dragFlags = 0;
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            if (mIsCanDrag) {
                // GridView 样式四个方向都可以
                dragFlags = ItemTouchHelper.UP | ItemTouchHelper.LEFT | ItemTouchHelper.DOWN | ItemTouchHelper.RIGHT;
            }
        } else {
            if (mIsCanDrag) {
                // ListView 样式不支持左右，只支持上下
                dragFlags = ItemTouchHelper.UP |
                        ItemTouchHelper.DOWN;
            }
        }

        return makeMovementFlags(dragFlags, 0);
    }

    /**
     * 拖动的时候不断的回调方法
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // 获取原来的位置
        int fromPosition = viewHolder.getAdapterPosition();
        // 得到目标的位置
        int targetPosition = target.getAdapterPosition();
        if (mItemDragAndMoveListener != null) {
            mItemDragAndMoveListener.onMove(fromPosition, targetPosition);
        }
        return true;
    }

    /**
     * 侧滑删除后会回调的方法
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // 获取当前删除的位置
        int position = viewHolder.getAdapterPosition();
        if (mItemDragAndMoveListener != null) {
            mItemDragAndMoveListener.onSwipe(position);
        }
    }

    /**
     * 拖动选择状态改变回调
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            // ItemTouchHelper.ACTION_STATE_IDLE 看看源码解释就能理解了
            // 侧滑或者拖动的时候背景设置为灰色
            viewHolder.itemView.setBackgroundColor(Color.GRAY);
        }
    }

    /**
     * 回到正常状态的时候回调
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        // 正常默认状态下背景恢复默认
        viewHolder.itemView.setBackgroundColor(0);
        ViewCompat.setTranslationX(viewHolder.itemView, 0);
    }


    public void swapItems(List<Object> items, int fromPosition, int targetPosition) {
        if (fromPosition > targetPosition) {
            for (int i = fromPosition; i < targetPosition; i++) {
                Collections.swap(items, i, i + 1);// 改变实际的数据集
            }
        } else {
            for (int i = fromPosition; i > targetPosition; i--) {
                Collections.swap(items, i, i - 1);// 改变实际的数据集
            }
        }
    }
}
