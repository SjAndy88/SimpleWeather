
package com.jsheng.simpleweather.data.weather.bean;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ForecastData {

    @SerializedName("cityId")
    @Expose
    private String cityId;  //城市id
    @SerializedName("cityName")
    @Expose
    private String cityName;  //城市名称
    @SerializedName("sj")
    @Expose
    private String sj;  //数据更新时间
    @SerializedName("list")
    @Expose
    private List<ForecastItem> list = null;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public List<ForecastItem> getList() {
        return list;
    }

    public void setList(List<ForecastItem> forecastItem) {
        this.list = forecastItem;
    }

}
