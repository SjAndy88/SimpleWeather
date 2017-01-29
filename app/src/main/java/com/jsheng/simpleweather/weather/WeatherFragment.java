package com.jsheng.simpleweather.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jsheng.simpleweather.R;
import com.jsheng.simpleweather.base.BaseFragment;
import com.jsheng.simpleweather.data.weather.bean.Forecast;
import com.jsheng.simpleweather.data.weather.bean.Observe;
import com.jsheng.simpleweather.data.weather.bean.ObserveData;
import com.jsheng.simpleweather.weather.adapter.ForecastAdapter;

import butterknife.BindView;

/**
 * Created by shengjun on 2017/1/26.
 */

public class WeatherFragment extends BaseFragment implements WeatherContract.View {

    public static final String KEY_CITY = "KEY_CITY";

    private String mCity;

    private WeatherContract.Presenter mPresenter;

    @BindView(R.id.weather_title)
    TextView mTitle;

    @BindView(R.id.weather_description)
    TextView mDescription;

    @BindView(R.id.weather_temperature)
    TextView mTemperature;

    @BindView(R.id.weather_forecast)
    RecyclerView mForecast;

    private ForecastAdapter mAdapter;

    public static WeatherFragment getInstance(String city) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putString(KEY_CITY, city);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCity = getArguments().getString(KEY_CITY);
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_weather;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mForecast.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.doSubscribe(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.unSubscribe(this);
    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(getContext(), R.string.network_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showServiceError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setForecast(Forecast forecast) {
        if (mAdapter == null) {
            mAdapter = new ForecastAdapter(forecast);
            mForecast.setAdapter(mAdapter);
        } else {
            mAdapter.setForecastData(forecast);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setObserve(Observe observe) {
        ObserveData observeData = observe.getData();
        mTitle.setText(observeData.getCityName());
        mDescription.setText(observeData.getTq());
        mTemperature.setText(String.format("%s℃", observeData.getQw()));
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public String getCity() {
        return mCity;
    }
}
