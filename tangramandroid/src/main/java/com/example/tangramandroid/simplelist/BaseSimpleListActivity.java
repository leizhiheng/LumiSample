package com.example.tangramandroid.simplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.tangramandroid.R;

import java.util.ArrayList;

public class BaseSimpleListActivity extends AppCompatActivity {

    protected RecyclerView mRecyclerView;
    protected SimpleRvAdapter mAdapter;
    private RecyclerView.ItemDecoration mItemDecoration;
    private boolean mFinishedStart = true;
    protected ArrayList<SimpleBean> mItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItems = new ArrayList<>();
        mAdapter = new SimpleRvAdapter(this, mItems);
        mItemDecoration = new CommonItemDecoration(this, CommonItemDecoration.VERTICAL_LIST, R.drawable.shape_common_divider, (int)(20*this.getResources().getDisplayMetrics().density+0.5f));
    }

    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public SimpleRvAdapter getAdapter() {
        return mAdapter;
    }

    public void setData(ArrayList<SimpleBean> items) {
        mAdapter.setData(items);
    }

    /**
     * 这个方法在setContentView()设置成功后调用
     */
    @Override
    public void onContentChanged() {
        super.onContentChanged();
        //后续再添加
        View emptyView = findViewById(R.id.empty_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        if (mRecyclerView == null) {
            throw new RuntimeException(
                    "Your content must have a RecyclerView whose id attribute is " +
                            "'R.id.recycler_view'");
        }
        if (emptyView != null) {
        }

        if (mFinishedStart) {
            setRecyclerView();
        }
        mFinishedStart = false;
    }

    private void setRecyclerView() {
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.addItemDecoration(mItemDecoration);
    }
}
