package com.synway.base;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Author：Libin on 2021/6/2 14:14
 * Email：1993911441@qq.com
 * Describe：
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
    }
}
