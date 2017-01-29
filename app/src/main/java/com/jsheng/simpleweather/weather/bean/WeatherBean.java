package com.jsheng.simpleweather.weather.bean;

import com.jsheng.simpleweather.data.weather.bean.Forecast;
import com.jsheng.simpleweather.data.weather.bean.Observe;

/**
 * Created by shengjun on 2017/1/28.
 */

public class WeatherBean {

    private Forecast forecast;
    private Observe observe;

    public WeatherBean(Forecast forecast, Observe observe) {
        this.forecast = forecast;
        this.observe = observe;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public Observe getObserve() {
        return observe;
    }
}
