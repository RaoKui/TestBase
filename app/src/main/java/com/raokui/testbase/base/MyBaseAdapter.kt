package com.raokui.testbase.base

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

import java.util.ArrayList

/**
 * Created by RaoKui on 2017/7/12.
 */

abstract class MyBaseAdapter<Holder, T>(protected var mContext: Context) : BaseAdapter() {

    protected var mDataList: List<T>? = ArrayList()

    protected var mInflater: LayoutInflater

    init {
        mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return if (mDataList == null) 0 else mDataList!!.size
    }

    override fun getItem(position: Int): T? {
        return if (mDataList == null) null else mDataList!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var holder: Holder? = null
        var t = getItem(position)
        if (convertView == null) {
            convertView = mInflater.inflate(layoutId, parent, false)
            holder = onCreateViewHolder(convertView)
            convertView!!.tag = holder
        } else {
            holder = convertView.tag as Holder
        }

        onBindViewHolder(holder, t!!, position, convertView)
        return convertView
    }

    protected abstract fun onBindViewHolder(holder: Holder, t: T, position: Int, convertView: View)

    protected abstract fun onCreateViewHolder(convertView: View): Holder

    @get:LayoutRes
    protected abstract val layoutId: Int

}
