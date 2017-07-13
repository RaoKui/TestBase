package com.raokui.testbase.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


import com.orhanobut.logger.Logger

import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by RaoKui on 2017/7/11.
 */

abstract class BaseActivity : AppCompatActivity() {


    protected val TAG = this.javaClass.simpleName

    private var mUnbinder: Unbinder? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        mUnbinder = ButterKnife.bind(this)

        init()
        initData()
        initListener()
        Logger.i("onCreate: ")
    }


    protected abstract val layoutId: Int

    protected abstract fun init()

    protected abstract fun initData()

    protected abstract fun initListener()

    override fun onStart() {
        super.onStart()
        Logger.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Logger.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Logger.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Logger.d(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Logger.d(TAG, "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.d(TAG, "onDestroy: ")
        mUnbinder!!.unbind()

    }


}
