package com.raokui.testbase.presenter;

import com.raokui.testbase.base.BasePresenter;
import com.raokui.testbase.contract.MainContract;
import com.raokui.testbase.model.TestModel;

import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 20151203 on 2017/7/12.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {



    @Override
    public void login(String path) {
        new TestModel().getUserImage(path).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(byte[] bytes) {
                mView.showPic(bytes);
            }
        });
    }

}
