package com.jsheng.simpleweather.base;

/**
 * Created by shengjun on 2017/1/27.
 */

public interface BasePresenter<T> {

    void doSubscribe(T view);

    void unSubscribe(T view);

}
