package com.synway.module0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.synway.base.BaseMvvmActivity;
import com.synway.module0.databinding.ActivityMain0Binding;

import java.lang.reflect.Method;

public class MainActivity extends BaseMvvmActivity<MyViewModel, ActivityMain0Binding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main0;
    }

    @Override
    protected void initView() {

    }

    public void toModule1(View view){
//        setMobileDataState(this,true);
        ARouter.getInstance().build("/module1/MainActivity").navigation();
    }

    public void toModule2(View view) {
//        setMobileDataState(this,false);
        ARouter.getInstance().build("/module2/MainActivity").navigation();
    }

    public void setMobileDataState(Context context, boolean enabled) {
        TelephonyManager telephonyService = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try {
            Method setDataEnabled = telephonyService.getClass().getDeclaredMethod("setDataEnabled",boolean.class);
            if (null != setDataEnabled) {
                setDataEnabled.invoke(telephonyService, enabled);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public boolean getMobileDataState(Context context) {
        TelephonyManager telephonyService = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        try {
            Method getDataEnabled = telephonyService.getClass().getDeclaredMethod("getDataEnabled");
            if (null != getDataEnabled) {
                return (Boolean) getDataEnabled.invoke(telephonyService);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}