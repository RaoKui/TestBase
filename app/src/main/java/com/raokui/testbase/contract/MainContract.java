package com.raokui.testbase.contract;

import com.raokui.testbase.base.BaseView;

/**
 * Created by RaoKui on 2017/7/12.
 */

public interface MainContract {
    interface Presenter {
        void login(String path);
    }

    interface View extends BaseView {
        void showPic(byte[] bytes);
    }

}
