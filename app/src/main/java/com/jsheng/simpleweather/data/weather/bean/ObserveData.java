package com.jsheng.simpleweather.data.weather.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shengjun on 2017/1/26.
 */

public class ObserveData {
    @SerializedName("cityId")
    @Expose
    private String cityId;
    @SerializedName("cityName")
    @Expose
    private String cityName;
    @SerializedName("lastUpdate")
    @Expose
    private String lastUpdate;
    @SerializedName("tq")
    @Expose
    private String tq;
    @SerializedName("numtq")
    @Expose
    private String numTq;
    @SerializedName("qw")
    @Expose
    private String qw;
    @SerializedName("fl")
    @Expose
    private String fl;
    @SerializedName("numfl")
    @Expose
    private String numFl;
    @SerializedName("fx")
    @Expose
    private String fx;
    @SerializedName("numfx")
    @Expose
    private String numFx;
    @SerializedName("sd")
    @Expose
    private String sd;

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

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getTq() {
        return tq;
    }

    public void setTq(String tq) {
        this.tq = tq;
    }

    public String getNumTq() {
        return numTq;
    }

    public void setNumTq(String numTq) {
        this.numTq = numTq;
    }

    public String getQw() {
        return qw;
    }

    public void setQw(String qw) {
        this.qw = qw;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getNumFl() {
        return numFl;
    }

    public void setNumFl(String numFl) {
        this.numFl = numFl;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getNumFx() {
        return numFx;
    }

    public void setNumFx(String numFx) {
        this.numFx = numFx;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }
}
