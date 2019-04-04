package com.chia.app.common;

import android.text.TextUtils;
import android.util.Log;
import com.lib.frame.view.BaseView;
import io.reactivex.subscribers.ResourceSubscriber;

public abstract class CommonSubscriber<T> extends ResourceSubscriber<T> {

    private BaseView mView;
    private String mErrorMsg;

    public CommonSubscriber(BaseView view) {
        this.mView = view;
    }

    public CommonSubscriber(BaseView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    @Override
    public void onError(Throwable t) {
        if (mErrorMsg != null && !TextUtils.isEmpty(mErrorMsg)) {
            Log.i("jiawei",mErrorMsg);
        } else {
            Log.i("jiawei",t.getMessage());
        }
    }

    @Override
    public void onComplete() {
    }

}
