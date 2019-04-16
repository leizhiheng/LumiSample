package com.example.tangramandroid;

import android.os.Bundle;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.tangramandroid.draglist.DragAdapter;
import com.example.tangramandroid.simplelist.BaseSimpleListActivity;
import com.example.tangramandroid.simplelist.ItemTouchCallback;
import com.example.tangramandroid.simplelist.SimpleBean;
import com.example.tangramandroid.simplelist.SimpleRvAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class DragAndSwipeListActivity extends BaseSimpleListActivity {

    private boolean canDrag = true;
    private ItemTouchCallback mTouchCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        mTouchCallback = new ItemTouchCallback(true);
        mTouchCallback.setItemDragAndMoveListener(mListener);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(mTouchCallback);
        mAdapter = new DragAdapter(this);
//        DragCallBack callBack = new DragCallBack(mAdapter);
//        ItemTouchHelper helper = new ItemTouchHelper(callBack);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        ArrayList<SimpleBean> items = getDatas();
        setData(items);
        mAdapter.setOnItemClickEventListener(mOnItemClickEventListener);
        mRecyclerView.setAdapter(mAdapter);


        Switch s = findViewById(R.id.switch_button);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                canDrag = isChecked;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private SimpleRvAdapter.OnItemClickEventListener mOnItemClickEventListener = new SimpleRvAdapter.OnItemClickEventListener() {
        @Override
        public void onItemClicked(View view, int position) {
            Log.d("zhiheng", "item clicked, position is " + position);
        }

        @Override
        public void onItemLongClicked(View view, int position) {
            Log.d("zhiheng", "item long clicked, position is " + position);
        }
    };

    private ArrayList<SimpleBean> getDatas() {
        ArrayList<SimpleBean> list = new ArrayList<>();
        list.add(new SimpleBean(SimpleBean.TYPE_EMPTY));
        for (int i = 0; i < 20; i++) {
            list.add(new SimpleBean(SimpleBean.TYPE_IMG_ARROW, "Title-" + i));
        }
        return list;
    }

    private ItemTouchCallback.ItemDragAndMoveListener mListener = new ItemTouchCallback.ItemDragAndMoveListener() {
        @Override
        public void onMove(int fromPosition, int targetPosition) {
//            Collections.swap(mItems, fromPosition, targetPosition);
//            if (fromPosition > targetPosition) {
//                for (int i = fromPosition; i < targetPosition; i++) {
//                    Collections.swap(mItems, i, i + 1);// 改变实际的数据集
//                }
//            } else {
//                for (int i = fromPosition; i > targetPosition; i--) {
//                    Collections.swap(mItems, i, i - 1);// 改变实际的数据集
//                }
//            }
            mTouchCallback.swapItems(Collections.singletonList(mItems), fromPosition, targetPosition);
            mAdapter.notifyItemMoved(fromPosition, targetPosition);
        }

        @Override
        public void onSwipe(int postion) {

        }
    };
}
