package com.synway.mvvm.base;

import android.os.Bundle;
import android.widget.Toast;

import com.synway.mvvm.R;
import com.synway.mvvm.UserBean;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author：Libin on 2021/4/22 14:40
 * Email：1993911441@qq.com
 * Describe：
 */
public class TestActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        recyclerView = findViewById(R.id.rv);
        List<UserBean> dataList = new ArrayList<>();
        dataList.add(new UserBean("1122221",111));
        dataList.add(new UserBean("223121",111));
        dataList.add(new UserBean("333221",111));
        dataList.add(new UserBean("1122221",111));
        dataList.add(new UserBean("22311",111));
        dataList.add(new UserBean("33311",111));
        dataList.add(new UserBean("1122221",111));
        dataList.add(new UserBean("22311",111));
        dataList.add(new UserBean("33311",111));
        dataList.add(new UserBean("1122221",111));
        dataList.add(new UserBean("22311",111));
        dataList.add(new UserBean("33311",111));
        dataList.add(new UserBean("1122221",111));
        dataList.add(new UserBean("22311",111));
        dataList.add(new UserBean("33311",111));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BaseAdapter adapter = new BaseAdapter(this,R.layout.layout_rv_item,dataList) {
            @Override
            public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
                holder.setText(R.id.tv_value,dataList.get(position).getUserName());
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new BaseAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(TestActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
