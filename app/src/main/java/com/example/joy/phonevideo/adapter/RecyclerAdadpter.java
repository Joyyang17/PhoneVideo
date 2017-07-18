package com.example.joy.phonevideo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.joy.phonevideo.R;

import java.util.List;

/**
 * Created by Joy on 17/7/18.
 */

public class RecyclerAdadpter extends RecyclerView.Adapter<RecyclerAdadpter.ViewHolder> {

    private List<String> mData;

    private Context mContext;

    private LayoutInflater mInflater;

    private OnItemClickListener mOnItemClickListener;

    public RecyclerAdadpter(List<String> data) {
        mData = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_recycler);
        }
    }


    private void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }


    interface OnItemClickListener {
        void onClick(View view, int position, String ciry);
    }


}
