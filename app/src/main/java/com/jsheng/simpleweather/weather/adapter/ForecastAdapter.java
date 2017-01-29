package com.jsheng.simpleweather.weather.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jsheng.simpleweather.R;
import com.jsheng.simpleweather.data.weather.bean.Forecast;
import com.jsheng.simpleweather.data.weather.bean.ForecastItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shengjun on 2017/1/27.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<ForecastItem> mForecastItems;

    public ForecastAdapter(Forecast forecast) {
        mForecastItems = forecast.getForecastData().getList();
    }

    public void setForecastData(Forecast forecast) {
        mForecastItems.clear();
        mForecastItems = forecast.getForecastData().getList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ForecastItem item = mForecastItems.get(position);
        holder.date.setText(item.getDate());
        holder.temperature.setText(String.format("%s℃/%s℃",item.getQw1(), item.getQw2()));
        holder.description.setText(item.getTq1());
    }

    @Override
    public int getItemCount() {
        return mForecastItems == null ? 0 : mForecastItems.size();
    }
}

class ViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.forecast_date)
    TextView date; // 日期
    @BindView(R.id.forecast_temperature)
    TextView temperature; // 温度
    @BindView(R.id.forecast_description)
    TextView description; // 天气

    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
