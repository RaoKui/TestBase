package com.example.a20151203.testbase;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by 20151203 on 2017/7/11.
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
//        Logger.init("mytag")                 // default PRETTYLOGGER or use just init()
//                .methodCount(3)                 // default 2
//                .hideThreadInfo()               // default shown
//                .logLevel(LogLevel.NONE)        // default LogLevel.FULL
//                .methodOffset(2)                // default 0
//                .logAdapter(new AndroidLogAdapter()); //default AndroidLogAdapter
//    }
    }
}
