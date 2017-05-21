package com.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public abstract class MvpProjectBaseActivity extends AppCompatActivity implements IActivity, Handler.Callback , View.OnClickListener{

    protected Handler mHandler;
    protected LayoutInflater mInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mHandler = new Handler(this);
        handleIntent(getIntent());
        preparePresenter();
        super.onCreate(savedInstanceState);
        mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    }
}
