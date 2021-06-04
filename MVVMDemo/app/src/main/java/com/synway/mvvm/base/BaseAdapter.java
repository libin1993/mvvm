package com.synway.mvvm.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author：Libin on 2021/4/22 11:14
 * Email：1993911441@qq.com
 * Describe：
 */
public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private Context context;
    private List<?> dataList;
    private int rid;
    private OnClickListener onClickListener;

    public BaseAdapter(Context context, int rid,List<?> dataList) {
        this.context = context;
        this.rid = rid;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(rid,parent,false);
        BaseViewHolder baseViewHolder = new BaseViewHolder(itemView);
        if (onClickListener !=null){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClick(baseViewHolder.getLayoutPosition());
                }
            });
        }
        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(int position);
    }
}
