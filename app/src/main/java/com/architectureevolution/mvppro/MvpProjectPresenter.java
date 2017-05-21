package com.architectureevolution.mvppro;

import android.content.Context;
import android.os.Handler;

import com.architectureevolution.datasource.IWeatherDataSource;
import com.architectureevolution.datasource.impl.WeatherDataSoureImpl;
import com.base.MvpProjectBasePresenter;
import com.model.WeatherDto;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public class MvpProjectPresenter extends MvpProjectBasePresenter implements IMvpProjectContract, IWeatherDataSource.LoadWeatherDataCallback {
    public static final int MSG_BASE = 0;
    public static final int MSG_NODATA = MSG_BASE + 1;
    public static final int MSG_WEATHER_DATA = MSG_BASE + 2;
    public static final int MSG_ERROR = MSG_BASE + 3;

    private IWeatherDataSource mWeatherDataSource;
    private WeatherDto mWeatherInfo;
    private Throwable mThrowable;

    public MvpProjectPresenter(Context context, Handler handler) {
        super(context, handler);
        mWeatherDataSource = new WeatherDataSoureImpl();
    }

    @Override
    public void loadMvpProWeatherData() {
        mWeatherDataSource.loadWeatherData(this);

    }

    @Override
    public WeatherDto getWeatherData() {
        return mWeatherInfo;
    }

    @Override
    public Throwable getThrowable() {
        return mThrowable;
    }

    @Override
    public void onLoadSucess(WeatherDto weatherDtoInfo) {
        if (weatherDtoInfo == null) {
            notifyUi(MSG_NODATA);
        } else {
            mWeatherInfo = weatherDtoInfo;
            notifyUi(MSG_WEATHER_DATA);
        }
    }

    @Override
    public void onLoadFail(Throwable t) {
        mThrowable = t;
        notifyUi(MSG_ERROR);
    }
}
