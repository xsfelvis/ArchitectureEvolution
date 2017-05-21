package com.request;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.model.WeatherDto;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public class RequestClient {
    static Retrofit mRetrofit;
    public static Retrofit retrofit() {
        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl("http://wthrcdn.etouch.cn/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    public interface ApiStores {
        @GET("weather_mini")
        Call<WeatherDto> getWeather(@Query("city") String cityId);
    }
}
