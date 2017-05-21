package com.architectureevolution;

import android.os.Bundle;
import android.view.View;

import com.architectureevolution.mvpnormal.MvpNormalActivity;
import com.architectureevolution.mvppro.MvpProjectActivity;
import com.architectureevolution.ugly.UglyActivity;
import com.base.NormalBaseActivity;


public class MainActivity extends NormalBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        findViewById(R.id.btn_architectire_normal).setOnClickListener(this);
        findViewById(R.id.btn_architectire_mvp_normal).setOnClickListener(this);
        findViewById(R.id.btn_architectire_mvp_pro).setOnClickListener(this);
        findViewById(R.id.btn_architectire_mvp_databinding).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_architectire_normal:
                launch(UglyActivity.class);
                break;
            case R.id.btn_architectire_mvp_normal:
                launch(MvpNormalActivity.class);
                break;
            case R.id.btn_architectire_mvp_pro:
                launch(MvpProjectActivity.class);
                break;
            default:
                break;
        }
    }
}
