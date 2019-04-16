package com.example.tangramandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.tangramandroid.simplelist.BaseSimpleListActivity;
import com.example.tangramandroid.simplelist.SimpleBean;
import com.example.tangramandroid.simplelist.SimpleRvAdapter;
import com.example.tangramandroid.utils.DataCreator;

import java.util.ArrayList;

public class SimpleListActivity extends BaseSimpleListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        ArrayList<SimpleBean> items = DataCreator.getSimpleBeans();
        setData(items);
        mAdapter.setOnItemClickEventListener(mOnItemClickEventListener);
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
}
