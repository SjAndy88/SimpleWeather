
package com.jsheng.simpleweather.data.weather.bean;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("counts")
    @Expose
    private Integer counts;  //访问的剩余次数。
    @SerializedName("directions")
    @Expose
    private String directions;
    @SerializedName("data")
    @Expose
    private ForecastData forecastData;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public ForecastData getForecastData() {
        return forecastData;
    }

    public void setForecastData(ForecastData forecastData) {
        this.forecastData = forecastData;
    }

}
