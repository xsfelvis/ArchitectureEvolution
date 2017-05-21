package com.architectureevolution.datasource;

import com.model.WeatherDto;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public interface IWeatherDataSource {

    interface LoadWeatherDataCallback {

        void onLoadSucess(WeatherDto weatherDtoInfo);

        void onLoadFail(Throwable t);
    }

    /**
     * 加载天气数据
     * @param loadWeatherDataCallback
     */
    void loadWeatherData(LoadWeatherDataCallback loadWeatherDataCallback);

}
