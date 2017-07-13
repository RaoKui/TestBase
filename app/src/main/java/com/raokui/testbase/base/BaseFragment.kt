package com.raokui.testbase.base

import android.app.Activity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup

import com.orhanobut.logger.Logger

import butterknife.ButterKnife
import butterknife.Unbinder

/**
 * Created by RaoKui on 2017/7/12.
 */

abstract class BaseFragment : Fragment() {



    private var mUnbinder: Unbinder? = null
    /**
     * Fragment Content view
     */
    private var inflateView: View? = null

    /**
     * 所属Activity
     */
    private var activity: Activity? = null
    /**
     * 记录是否已经创建了,防止重复创建
     */
    private var viewCreated: Boolean = false

    /**
     * 通过ID查找控件

     * @param viewId 控件资源ID
     * *
     * @param <VIEW> 泛型参数，查找得到的View
     * *
     * @return 找到了返回控件对象，否则返回null
    </VIEW> */
    fun <VIEW : View> findViewById(@IdRes viewId: Int): VIEW {
        return inflateView!!.findViewById<View>(viewId) as VIEW
    }


    protected abstract val layoutId: Int


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Logger.d("onActivityCreated")
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        Logger.d("onAttach")
        this.activity = activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.d("onCreate")
        // 防止重复调用onCreate方法，造成在initData方法中adapter重复初始化问题
        if (!viewCreated) {
            viewCreated = true
            initData()
        }
    }

    protected abstract fun initData()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Logger.d("onCreateView")
        if (null == inflateView) {
            val layoutResId = layoutId
            if (layoutResId > 0) {
                inflateView = inflater!!.inflate(layoutId, container, false)
                mUnbinder = ButterKnife.bind(this, inflateView!!)
            }

            // 解决点击穿透问题
            inflateView!!.setOnTouchListener { v, event -> true }
        }
        return inflateView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Logger.d("onViewCreated")
        if (viewCreated) {
            initView(view!!, savedInstanceState!!)
            initListener()
            viewCreated = false
        }
    }

    protected abstract fun initView(view: View, savedInstanceState: Bundle)

    protected abstract fun initListener()

    override fun onDestroy() {
        super.onDestroy()
        mUnbinder!!.unbind()
    }
}

