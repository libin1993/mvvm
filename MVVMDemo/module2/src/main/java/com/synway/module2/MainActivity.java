package com.synway.module2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.SeekBar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.synway.base.BaseMvvmActivity;
import com.synway.module2.databinding.ActivityMain2Binding;

import java.io.FileOutputStream;

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