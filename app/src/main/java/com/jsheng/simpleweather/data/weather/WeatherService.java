package com.jsheng.simpleweather.data.weather;

import com.jsheng.simpleweather.data.weather.bean.City;
import com.jsheng.simpleweather.data.weather.bean.Forecast;
import com.jsheng.simpleweather.data.weather.bean.Observe;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shengjun on 2017/1/26.
 */

public interface WeatherService {

    @GET("citylist/id/1")
    Observable<City> getCityList();

    @GET("forecast7d")
    Observable<Forecast> getForecast(@Query("city") String city);

    @GET("observe")
    Observable<Observe> getObserve(@Query("city") String city);
}
