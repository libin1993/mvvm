package com.synway.mvvm.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.synway.mvvm.R;
import com.synway.mvvm.UserBean;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import rx.Observable;

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
        dataList.add(new UserBean("1",1));
        dataList.add(new UserBean("2",2));
        dataList.add(new UserBean("3",1));
        dataList.add(new UserBean("4",1));
        dataList.add(new UserBean("5",1));
        dataList.add(new UserBean("6",1));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter1(dataList));
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        recyclerView.setOnFlingListener(null);
        pagerSnapHelper.attachToRecyclerView(recyclerView);

    }


    public class Adapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        private List<UserBean> userList;

        public Adapter1(List<UserBean> userList) {
            this.userList = userList;
        }

        @NonNull
        @NotNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
           if (viewType == 2){
               return new ViewHolder2(LayoutInflater.from(TestActivity.this).inflate(R.layout.layout_rv1,parent,false));
           }else {
               return new ViewHolder1(LayoutInflater.from(TestActivity.this).inflate(R.layout.layout_rv_item,parent,false));
           }
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof ViewHolder1){
                ViewHolder1 holder1 = (ViewHolder1) holder;
                holder1.tv.setText(userList.get(position).getUserName());
            }else if (holder instanceof ViewHolder2){
                ViewHolder2 holder2 = (ViewHolder2) holder;
                List<UserBean> itemList = new ArrayList<>();
                itemList.add(new UserBean("2-1",1));
                itemList.add(new UserBean("2-2",1));
                itemList.add(new UserBean("2-3",1));
                itemList.add(new UserBean("2-4",1));
                itemList.add(new UserBean("2-5",1));
                itemList.add(new UserBean("2-6",1));
                holder2.rv.setLayoutManager(new LinearLayoutManager(TestActivity.this));
                holder2.rv.setAdapter(new Adapter1(itemList));
                PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
                pagerSnapHelper.attachToRecyclerView(holder2.rv);
            }
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }

        @Override
        public int getItemViewType(int position) {
            return userList.get(position).getAge();
        }


    }


    public class ViewHolder1 extends RecyclerView.ViewHolder{
        public TextView tv;
        public ViewHolder1(@NonNull @NotNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_value);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder{
        public NestRecyclerView rv;
        public ViewHolder2(@NonNull @NotNull View itemView) {
            super(itemView);
            rv = itemView.findViewById(R.id.rv1);
        }
    }
}
