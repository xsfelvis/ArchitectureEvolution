package com.architectureevolution.mvppro;

import com.model.WeatherDto;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public interface IMvpProjectContract {

    void loadMvpProWeatherData();
    WeatherDto getWeatherData();
    Throwable getThrowable();
}
