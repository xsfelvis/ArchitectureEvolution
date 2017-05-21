package com.architectureevolution.ugly;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.architectureevolution.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.base.NormalBaseActivity;
import com.model.WeatherDto;
import com.request.RequestClient;


public class UglyActivity extends NormalBaseActivity {
    private TextView mTvshow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ugly);
        init();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void init() {
        mTvshow = (TextView) findViewById(R.id.tvShow);
        findViewById(R.id.btn_ugly_request).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_ugly_request:
                loadWeatherData();
                break;
            default:
                break;
        }

    }

    /**
     * 丑陋的写法：Activity做了太多的操作
     */
    private void loadWeatherData() {
        RequestClient.ApiStores apiStores = RequestClient.retrofit().create(RequestClient.ApiStores.class);
        Call<WeatherDto> call = apiStores.getWeather("成都");
        call.enqueue(new Callback<WeatherDto>() {
            @Override
            public void onResponse(Call<WeatherDto> call, Response<WeatherDto> resonse) {
                WeatherDto weatherInfo = resonse.body();
                if (weatherInfo.data == null) {
                    mTvshow.setText("data 为空！");
                    return;
                }
                mTvshow.setText("城市：" + weatherInfo.data.city + "\n"
                                + "staus is: " + weatherInfo.status + "\n"
                                + "温度 :" + weatherInfo.data.wendu + "\n"
                                + "感冒指数 :" + weatherInfo.data.ganmao + "\n"
                                + "昨日 最高气温：" + weatherInfo.data.yesterday.high + "\n"
                                + "预报 后天风力" + weatherInfo.data.forecast.get(3).fengli
                        //    + "预报 后天风力" + weatherInfo.data.forecast.get(5).fengli
                );
            }

            @Override
            public void onFailure(Call<WeatherDto> call, Throwable t) {
                mTvshow.setText(t.getMessage());
            }
        });
    }
}
