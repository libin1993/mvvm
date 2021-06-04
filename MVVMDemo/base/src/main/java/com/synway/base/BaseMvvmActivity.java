package com.synway.base;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

import java.lang.reflect.ParameterizedType;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Author：Libin on 2021/4/21 15:23
 * Email：1993911441@qq.com
 * Describe：
 */
public abstract class BaseMvvmActivity<VM extends ViewModel,VDB extends ViewDataBinding> extends BaseActivity {
    protected VM mViewModel;
    protected VDB mViewDataBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewDataBind = DataBindingUtil.setContentView(this, getLayoutId());
        mViewDataBind.setLifecycleOwner(this);
        //获得泛型参数的实际类型
        Class<VM> vmClass = (Class<VM>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(vmClass);

        initView();

    }


    protected abstract int getLayoutId();

    protected abstract void initView();
}
