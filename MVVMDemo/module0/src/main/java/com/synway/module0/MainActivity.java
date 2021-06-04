package com.synway.module0;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.synway.base.BaseMvvmActivity;
import com.synway.module0.databinding.ActivityMain0Binding;

public class MainActivity extends BaseMvvmActivity<MyViewModel, ActivityMain0Binding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main0;
    }

    @Override
    protected void initView() {

    }

    public void toModule1(View view){
        ARouter.getInstance().build("/module1/MainActivity").navigation();
    }

    public void toModule2(View view) {
        ARouter.getInstance().build("/module2/MainActivity").navigation();
    }
}