package com.synway.mvvm.base;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author：Libin on 2021/4/22 11:13
 * Email：1993911441@qq.com
 * Describe：
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    private View mItemView;
    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.mItemView = itemView;
    }

    public void setText(int id,String text){
        TextView textView = mItemView.findViewById(id);
        textView.setText(text);
    }
}
