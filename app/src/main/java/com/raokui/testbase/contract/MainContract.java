package com.raokui.testbase.contract;

import com.raokui.testbase.base.BasePresenter;
import com.raokui.testbase.base.BaseView;

/**
 * Created by 20151203 on 2017/7/12.
 */

public interface MainContract {
    interface Presenter {
        void login();
    }

    interface View extends BaseView {

    }

}
