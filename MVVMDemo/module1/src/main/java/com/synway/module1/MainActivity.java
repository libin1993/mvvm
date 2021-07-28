package com.synway.module1;

import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.synway.base.BaseActivity;
import com.synway.base.BaseMvvmActivity;
import com.synway.module1.databinding.ActivityMain1Binding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.annotation.Nullable;
import io.reactivex.rxjava3.functions.Consumer;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;


@Route(path = "/module1/MainActivity")
public class MainActivity extends BaseMvvmActivity<MyViewModel, ActivityMain1Binding> {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main1;
    }

    @Override
    protected void initView() {
        mViewModel.getData();

        List<Integer> dataList = new ArrayList<>();
        dataList.add(111);
        dataList.add(222);


        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1111111");

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("libin", "onNext: "+s);
            }
        });


        Observable.from(dataList)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("libin", "onNext:from "+integer);
                    }
                });

//        Observable.interval(1, TimeUnit.SECONDS)
//                .subscribe(new Consumer<Long>());



    }


}