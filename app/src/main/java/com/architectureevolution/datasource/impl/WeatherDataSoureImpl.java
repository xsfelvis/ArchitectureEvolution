package com.architectureevolution.datasource.impl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.architectureevolution.datasource.IWeatherDataSource;
import com.model.WeatherDto;
import com.request.RequestClient;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public class WeatherDataSoureImpl implements IWeatherDataSource {
    @Override
    public void loadWeatherData(final LoadWeatherDataCallback loadWeatherDataCallback) {
        RequestClient.ApiStores apiStores = RequestClient.retrofit().create(RequestClient.ApiStores.class);
        Call<WeatherDto> call = apiStores.getWeather("成都");
        call.enqueue(new Callback<WeatherDto>() {
            @Override
            public void onResponse(Call<WeatherDto> call, Response<WeatherDto> response) {
                loadWeatherDataCallback.onLoadSucess(response.body());
            }

            @Override
            public void onFailure(Call<WeatherDto> call, Throwable t) {
                loadWeatherDataCallback.onLoadFail(t);
            }
        });

    }
}
