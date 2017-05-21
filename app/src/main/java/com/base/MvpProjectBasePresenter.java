package com.base;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public abstract class MvpProjectBasePresenter {
    //handler的弱引用
    protected WeakReference<Handler> mHandlerHost;
    protected WeakReference<Context> mContextHost;
    private boolean mIsReleased = true;

    public MvpProjectBasePresenter(Context context, Handler handler) {
        mIsReleased = false;
        this.mContextHost = new WeakReference<Context>(context);
        this.mHandlerHost = new WeakReference<Handler>(handler);

    }

    protected void notifyUi(int what) {
        if (mIsReleased) {
            return;
        }
        Handler handler = mHandlerHost.get();
        if (handler != null) {
            handler.sendEmptyMessage(what);
        }
    }

    protected void notifyUi(Message message) {
        if (mIsReleased) {
            return;
        }
        Handler handler = mHandlerHost.get();
        if (handler != null) {
            handler.sendMessage(message);
        }

    }
}
