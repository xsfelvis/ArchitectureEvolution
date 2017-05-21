package com.model;

import java.util.List;

/**
 * Author: xushangfei
 * Time: created at 2017/5/21.
 * Description:
 */

public class WeatherDto {
    public String desc;
    public int status;
    public WeatherData data;

    public class WeatherData {
        public String wendu;
        public String ganmao;
        public Yesterday yesterday;
        public List<Forecast> forecast;
        public String aqi;
        public String city;
    }

    public class Yesterday {
        public String fl;
        public String fx;
        public String high;
        public String type;
        public String low;
        public String date;
    }

    public class Forecast {
        /**
         * fengxiang : 无持续风向
         * fengli : 微风级
         * high : 高温 25℃
         * type : 阴
         * low : 低温 15℃
         * date : 7日星期四
         */

        public String fengxiang;
        public String fengli;
        public String high;
        public String type;
        public String low;
        public String date;

    }

}
