package com.jsheng.simpleweather.weather;

import com.jsheng.simpleweather.base.BasePresenter;
import com.jsheng.simpleweather.base.BaseView;
import com.jsheng.simpleweather.data.weather.bean.Forecast;
import com.jsheng.simpleweather.data.weather.bean.Observe;

/**
 * Created by shengjun on 2017/1/27.
 */

interface WeatherContract {

    interface View extends BaseView<Presenter> {

        void showNetworkError();

        void showServiceError(String error);

        void setForecast(Forecast forecast);

        void setObserve(Observe observe);

        boolean isActive();

        String getCity();
    }

    interface Presenter extends BasePresenter<View> {

        void refreshWeather(String city);

    }
}
