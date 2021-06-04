package com.synway.module1;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.synway.base.BaseActivity;
import com.synway.base.BaseMvvmActivity;
import com.synway.module1.databinding.ActivityMain1Binding;

import androidx.annotation.Nullable;


@Route(path = "/module1/MainActivity")
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
    }
    //    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_main1;
//    }
//
//    @Override
//    protected void initView() {
//
//    }


}