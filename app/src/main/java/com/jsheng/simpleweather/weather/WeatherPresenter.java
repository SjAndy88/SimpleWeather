package com.jsheng.simpleweather.weather;

import com.jsheng.simpleweather.data.weather.WeatherApiManager;
import com.jsheng.simpleweather.data.weather.bean.Forecast;
import com.jsheng.simpleweather.data.weather.bean.Observe;
import com.jsheng.simpleweather.weather.bean.WeatherBean;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by shengjun on 2017/1/27.
 */

public class WeatherPresenter implements WeatherContract.Presenter {

    private HashMap<String, WeatherContract.View> mViewsMap;
    private HashMap<String, CompositeDisposable> mDisposablesMap;

    public WeatherPresenter() {
        mViewsMap = new HashMap<>();
        mDisposablesMap = new HashMap<>();
    }

    @Override
    public void doSubscribe(WeatherContract.View view) {
        String city = view.getCity();
        mViewsMap.put(city, view);
        mDisposablesMap.put(city, new CompositeDisposable());
        getWeather(city);
    }

    @Override
    public void unSubscribe(WeatherContract.View view) {
        String city = view.getCity();
        CompositeDisposable cDisposable = mDisposablesMap.remove(city);
        cDisposable.clear();
        mViewsMap.remove(city);
    }

    private void getWeather(final String city) {
        mDisposablesMap.get(city).clear();
        mDisposablesMap.get(city).add(
                Observable.zip(
                        WeatherApiManager.getInstance().getObserve(city),
                        WeatherApiManager.getInstance().getForecast(city),
                        new BiFunction<Observe, Forecast, WeatherBean>() {
                            @Override
                            public WeatherBean apply(Observe observe, Forecast forecast) throws Exception {
                                return new WeatherBean(forecast, observe);
                            }
                        }
                )
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                new Consumer<WeatherBean>() {
                                    @Override
                                    public void accept(WeatherBean weatherBean) throws Exception {
                                        WeatherContract.View view = mViewsMap.get(city);
                                        if (weatherBean.getForecast().getCode() == 1
                                                && weatherBean.getObserve().getCode() == 1) {
                                            view.setForecast(weatherBean.getForecast());
                                            view.setObserve(weatherBean.getObserve());
                                        } else {
                                            view.showServiceError(weatherBean.getForecast().getDirections());
                                        }
                                    }
                                },
                                new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                        WeatherContract.View view = mViewsMap.get(city);
                                        view.showNetworkError();
                                    }
                                }
                        ));
    }

    @Override
    public void refreshWeather(String city) {
        getWeather(city);
    }
}
