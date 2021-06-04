package com.synway.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Author：Libin on 2021/4/20 17:22
 * Email：1993911441@qq.com
 * Describe：
 */
public class UserViewModel extends ViewModel{
    public final MutableLiveData<UserBean> mutableLiveData = new MutableLiveData<UserBean>();

    public void getData(){
        UserBean userBean = new UserBean("111",1);
        mutableLiveData.setValue(userBean);
    }

}
