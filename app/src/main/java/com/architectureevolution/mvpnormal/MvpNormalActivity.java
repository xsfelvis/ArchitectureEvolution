package com.architectureevolution.mvpnormal;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.architectureevolution.R;

import com.base.NormalBaseActivity;
import com.model.WeatherDto;

public class MvpNormalActivity extends NormalBaseActivity implements IMvpNormalContract.View {
    private TextView mTvshow;
    private IMvpNormalContract.Presenter mPreseneter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_normal);
        mPreseneter = new MvpNormalPresenter(this);
        initView();
    }

    private void initView() {
        mTvshow = (TextView) findViewById(R.id.tvMvpBaseShow);
        findViewById(R.id.btn_mvp_base_request).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_mvp_base_request:
                mPreseneter.loadMvpBaseWeatherData();
                break;
            default:
                break;
        }
    }

    @Override
    public void setPresenter(IMvpNormalContract.Presenter presenter) {

    }

    @Override
    public void showError(Throwable t) {
        mTvshow.setText(t.getMessage());
    }

    @Override
    public void showNodata() {
        mTvshow.setText("WeatherData 为空！");
    }

    @Override
    public void showWeatherData(WeatherDto weatherInfo) {
        mTvshow.setText("城市：" + weatherInfo.data.city + "\n"
                        + "staus is: " + weatherInfo.status + "\n"
                        + "温度 :" + weatherInfo.data.wendu + "\n"
                        + "感冒指数 :" + weatherInfo.data.ganmao + "\n"
                        + "昨日 最高气温：" + weatherInfo.data.yesterday.high + "\n"
                        + "预报 后天风力" + weatherInfo.data.forecast.get(3).fengli
                //    + "预报 后天风力" + weatherInfo.data.forecast.get(5).fengli
        );
    }
}
