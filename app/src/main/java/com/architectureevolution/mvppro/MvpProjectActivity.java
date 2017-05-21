package com.architectureevolution.mvppro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.architectureevolution.R;
import com.base.MvpProjectBaseActivity;
import com.model.WeatherDto;

import static com.architectureevolution.mvppro.MvpProjectPresenter.MSG_ERROR;
import static com.architectureevolution.mvppro.MvpProjectPresenter.MSG_NODATA;
import static com.architectureevolution.mvppro.MvpProjectPresenter.MSG_WEATHER_DATA;


public class MvpProjectActivity extends MvpProjectBaseActivity {
    private TextView mTvShow;
    private IMvpProjectContract mMvpProjectContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_pro);
        initView();
    }

    private void initView() {
        mTvShow = (TextView) findViewById(R.id.tvMvpProShow);
        findViewById(R.id.btn_mvp_pro_request).setOnClickListener(this);
    }

    @Override
    public boolean handleMessage(Message msg) {
        if (this.isFinishing() || msg == null) {
            return false;
        }
        switch (msg.what) {
            case MSG_WEATHER_DATA:
                showWeatherData();
                break;
            case MSG_NODATA:
                showNoData();
                break;
            case MSG_ERROR:
                showError();
            default:
                break;
        }


        return false;
    }


    @Override
    public void handleIntent(Intent intent) {

    }


    @Override
    public void preparePresenter() {
        mMvpProjectContract = new MvpProjectPresenter(this, mHandler);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_mvp_pro_request:
                mMvpProjectContract.loadMvpProWeatherData();
                break;
            default:
                break;
        }

    }

    private void showWeatherData() {
        WeatherDto weatherInfo = mMvpProjectContract.getWeatherData();
        if (weatherInfo != null) {
            mTvShow.setText("城市：" + weatherInfo.data.city + "\n"
                            + "staus is: " + weatherInfo.status + "\n"
                            + "温度 :" + weatherInfo.data.wendu + "\n"
                            + "感冒指数 :" + weatherInfo.data.ganmao + "\n"
                            + "昨日 最高气温：" + weatherInfo.data.yesterday.high + "\n"
                            + "预报 后天风力" + weatherInfo.data.forecast.get(3).fengli
                    //    + "预报 后天风力" + weatherInfo.data.forecast.get(5).fengli
            );

        }
    }

    private void showNoData() {
        mTvShow.setText("WeatherData 为空！");
    }

    private void showError() {
        mTvShow.setText(mMvpProjectContract.getThrowable().getMessage());
    }

}
