package com.architectureevolution.mvpnormal;

import com.base.BasePresenter;
import com.base.BaseView;
import com.model.WeatherDto;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public interface IMvpNormalContract {
    interface View extends BaseView<Presenter> {

        void showError(Throwable t);

        void showNodata();

        void showWeatherData(WeatherDto weatherDto);
    }


    interface Presenter extends BasePresenter {

        void loadMvpBaseWeatherData();
    }
}
