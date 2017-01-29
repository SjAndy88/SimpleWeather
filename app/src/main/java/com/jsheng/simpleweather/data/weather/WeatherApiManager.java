package com.jsheng.simpleweather.data.weather;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jkyeo.basicparamsinterceptor.BasicParamsInterceptor;
import com.jsheng.simpleweather.BuildConfig;
import com.jsheng.simpleweather.data.weather.bean.City;
import com.jsheng.simpleweather.data.weather.bean.Forecast;
import com.jsheng.simpleweather.data.weather.bean.Observe;
import com.jsheng.simpleweather.data.weather.constant.YYTianQi;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shengjun on 2017/1/26.
 */

public class WeatherApiManager {

    private static WeatherApiManager instance = new WeatherApiManager();

    private final WeatherService weatherService;

    public static WeatherApiManager getInstance() {
        return instance;
    }

    private WeatherApiManager() {
        BasicParamsInterceptor params = new BasicParamsInterceptor.Builder()
                        .addParam("key", YYTianQi.API_KEY)
                        .build();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? Level.BODY : Level.BASIC);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(params)
                .addInterceptor(logging)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(YYTianQi.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        weatherService = retrofit.create(WeatherService.class);
    }

    public Observable<City> getCityList() {
        return weatherService.getCityList();
    }

    public Observable<Forecast> getForecast(String city) {
        return weatherService.getForecast(city);
    }

    public Observable<Observe> getObserve(String city) {
        return weatherService.getObserve(city);
    }
}
