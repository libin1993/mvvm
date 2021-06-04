package com.synway.base;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.BuildConfig;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.multidex.MultiDex;


/**
 * Author：Libin on 2021/5/28 16:05
 * Email：1993911441@qq.com
 * Describe：
 */
public class BaseApplication extends Application {
    //全局唯一的context
    private static BaseApplication mInstance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        initARouter();
    }

    /**
     * 初始化路由
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();  // 打印日志
            ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(mInstance);// 尽可能早，推荐在Application中初始化
    }

    public static BaseApplication getInstance() {
        return mInstance;
    }
}
