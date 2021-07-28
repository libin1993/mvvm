package com.synway.module1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author：Libin on 2021/5/31 10:28
 * Email：1993911441@qq.com
 * Describe：
 */
public class MyViewModel extends ViewModel {
    public MutableLiveData<String> mutableLiveData = new MutableLiveData<>();

    public void getData(){
        mutableLiveData.setValue("11111");
    }

}
