package com.jsheng.simpleweather.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.jsheng.simpleweather.R;
import com.jsheng.simpleweather.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;

/**
 * Created by shengjun on 2017/1/26.
 */

public class WeatherActivity extends BaseActivity {

    @BindView(R.id.weather_view_pager)
    ViewPager mWeatherViewPager;

    String[] mWeatherCitys = new String[] {
            "CH010100", "CH020100", "CH030100"
    };

    static class WeatherAdapter extends FragmentStatePagerAdapter {

        private ArrayList<String> mWeatherCities;
        private WeatherPresenter mPresenter;

        public WeatherAdapter(FragmentManager fm, WeatherPresenter presenter,
                              List<String> cities) {
            super(fm);
            mPresenter = presenter;
            mWeatherCities = new ArrayList<>(cities.size());
            mWeatherCities.addAll(cities);
        }

        @Override
        public Fragment getItem(int position) {
            WeatherFragment fragment = WeatherFragment.getInstance(mWeatherCities.get(position));
            fragment.setPresenter(mPresenter);
            return fragment;
        }

        @Override
        public int getCount() {
            return mWeatherCities.size();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeatherPresenter presenter = new WeatherPresenter();
        WeatherAdapter adapter = new WeatherAdapter(
                getSupportFragmentManager(), presenter, Arrays.asList(mWeatherCitys));
        mWeatherViewPager.setAdapter(adapter);
    }

    @Override
    protected int getActivityLayout() {
        return R.layout.activity_main;
    }
}
