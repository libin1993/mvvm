package com.synway.module2;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.synway.base.BaseMvvmActivity;
import com.synway.module2.databinding.ActivityMain2Binding;

@Route(path = "/module2/MainActivity")
public class MainActivity extends BaseMvvmActivity<MyViewModel, ActivityMain2Binding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {

    }


}