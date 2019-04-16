package com.example.tangramandroid.simplelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tangramandroid.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Author: lzh
 * date: 2019/4/10
 * desc:
 */
public class SimpleRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    protected ArrayList<SimpleBean> mItems = new ArrayList<>();
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected OnItemClickEventListener mOnItemClickEventListener;

    public interface OnItemClickEventListener {
        void onItemClicked(View view, int position);
        void onItemLongClicked(View view, int position);
    }

    public SimpleRvAdapter(Context context) {
        this(context, null);
    }

    public SimpleRvAdapter(Context context, ArrayList<SimpleBean> items) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mItems = items;
    }

    public static HashMap<Integer, Integer> mType2IconMap = new HashMap<>();
    static {
        mType2IconMap.put(SimpleBean.TYPE_IMG_ARROW, R.mipmap.kt_pp_6);
        mType2IconMap.put(SimpleBean.TYPE_IMG_MENE, android.R.drawable.ic_menu_add);
        mType2IconMap.put(SimpleBean.TYPE_IMG_CHOOSED, android.R.drawable.checkbox_on_background);
        mType2IconMap.put(SimpleBean.TYPE_IMG_NONE, 0);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;

        switch (viewType) {
            case SimpleBean.TYPE_IMG_NONE:
            case SimpleBean.TYPE_IMG_ARROW:
            case SimpleBean.TYPE_IMG_MENE:
            case SimpleBean.TYPE_IMG_CHOOSED:
                holder = new SimpleRvItemViewHolder(mInflater.inflate(R.layout.layout_simple_rv_item, parent, false));
                break;
            case SimpleBean.TYPE_EMPTY:
                holder = new EmptyItemViewHolder(mInflater.inflate(R.layout.layout_rv_empty_item, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof SimpleRvItemViewHolder) {
            ((SimpleRvItemViewHolder) viewHolder).bind(viewHolder, position);

        } else if (viewHolder instanceof EmptyItemViewHolder) {
            ((EmptyItemViewHolder) viewHolder).bind(position);
        } else {

        }
    }

    @Override
    public int getItemViewType(int position) {
        return mItems.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void setOnItemClickEventListener(OnItemClickEventListener onItemClickEventListener) {
        this.mOnItemClickEventListener = onItemClickEventListener;
    }

    public void setData(ArrayList<SimpleBean> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    class SimpleRvItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivLeft, ivRight;
        private TextView tvTitle, tvSubTitle, tvContent;

        public SimpleRvItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ivLeft = itemView.findViewById(R.id.iv_cell_left);
            ivRight = itemView.findViewById(R.id.iv_cell_right);
            tvTitle = itemView.findViewById(R.id.tv_cell_left);
            tvSubTitle = itemView.findViewById(R.id.tv_cell_left_bottom);
            tvContent = itemView.findViewById(R.id.tv_cell_right);
        }

        public void bind(RecyclerView.ViewHolder holder, int position) {
            SimpleBean bean = mItems.get(position);
            bean.setLeftIconId(R.mipmap.device_gateway);
            if (bean.getLeftIconId() > 0) {
                ivLeft.setVisibility(View.VISIBLE);
                ivLeft.setImageResource(bean.getLeftIconId());
            } else {
                ivLeft.setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(bean.getTitle())) {
                tvTitle.setVisibility(View.VISIBLE);
                tvTitle.setText(bean.getTitle());
            } else {
                tvTitle.setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(bean.getSubTitle())) {
                tvSubTitle.setVisibility(View.VISIBLE);
                tvSubTitle.setText(bean.getSubTitle());
            } else {
                tvSubTitle.setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(bean.getContent())) {
                tvContent.setVisibility(View.VISIBLE);
                tvContent.setText(bean.getTitle());
            } else {
                tvContent.setVisibility(View.GONE);
            }

            if (mType2IconMap.get(bean.getType()) > 0) {
                ivRight.setVisibility(View.VISIBLE);
                ivRight.setImageResource(mType2IconMap.get(bean.getType()));
            } else {
                ivRight.setVisibility(View.GONE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickEventListener != null) {
                        mOnItemClickEventListener.onItemClicked(holder.itemView, position);
                    }
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mOnItemClickEventListener != null) {
                        mOnItemClickEventListener.onItemLongClicked(holder.itemView, position);
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    static class EmptyItemViewHolder extends RecyclerView.ViewHolder {

        public EmptyItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(int positon) {
            Log.d("zhiheng", "Empty holder bind");
        }
    }
}
