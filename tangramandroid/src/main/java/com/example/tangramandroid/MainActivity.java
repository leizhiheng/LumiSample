package com.example.tangramandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ListActivity {

    public static Class[] Clazzs = {ConstraintActivity.class, SimpleListActivity.class, DragAndSwipeListActivity.class};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(android.R.layout.list_content);

        ClassAdapter adapter = new ClassAdapter();
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        startActivity(new Intent(this, Clazzs[position]));
    }

    class ClassAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Clazzs.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(MainActivity.this, android.R.layout.simple_list_item_1, null);
            TextView tv = convertView.findViewById(android.R.id.text1);
            tv.setText(Clazzs[position].getSimpleName());
            return convertView;
        }
    }
}
