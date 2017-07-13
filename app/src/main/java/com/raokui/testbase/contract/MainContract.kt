package com.raokui.testbase.contract

/**
 * Created by RaoKui on 2017/7/12.
 */

interface MainContract {
    interface Presenter {
        fun login()
    }

    interface View {
        fun showLoading()

        fun hideLoading()
    }

}
