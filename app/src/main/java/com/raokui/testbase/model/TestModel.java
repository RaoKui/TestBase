package com.raokui.testbase.model;

import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by 20151203 on 2017/7/14.
 */

public class TestModel {

    public OkHttpClient mClient;

    public TestModel() {
        mClient = new OkHttpClient();
    }

    public Observable<byte[]> getUserImage(final String path) {
        return Observable.create(new Observable.OnSubscribe<byte[]>() {
            @Override
            public void call(final Subscriber<? super byte[]> subscriber) {
                Request request = new Request.Builder().url(path).build();
                mClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        subscriber.onError(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (response.isSuccessful()) {
                            byte[] data = response.body().bytes();
                            if (data != null) {
                                subscriber.onNext(data);
                            }
                        }
                        subscriber.onCompleted();
                    }

                });

            }
        });
    }
}
