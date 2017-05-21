package com.architectureevolution.mvpnormal;

import com.architectureevolution.datasource.IWeatherDataSource;
import com.architectureevolution.datasource.impl.WeatherDataSoureImpl;
import com.model.WeatherDto;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public class MvpNormalPresenter implements IMvpNormalContract.Presenter, IWeatherDataSource.LoadWeatherDataCallback {

    private IWeatherDataSource mWeatherDataSource;
    private IMvpNormalContract.View mView;

    public MvpNormalPresenter(IMvpNormalContract.View view) {
        mWeatherDataSource = new WeatherDataSoureImpl();
        this.mView = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void onLoadSucess(WeatherDto weatherDtoInfo) {
        if (weatherDtoInfo == null) {
            mView.showNodata();
        } else {
            mView.showWeatherData(weatherDtoInfo);
        }
    }

    @Override
    public void onLoadFail(Throwable t) {

        mView.showError(t);
    }

    @Override
    public void loadMvpBaseWeatherData() {
        mWeatherDataSource.loadWeatherData(this);
    }
}
