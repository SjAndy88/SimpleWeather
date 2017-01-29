
package com.jsheng.simpleweather.data.weather.bean;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastItem {

    @SerializedName("tq1")
    @Expose
    private String tq1;  //白天天气
    @SerializedName("tq2")
    @Expose
    private String tq2;  //夜间天气，当与白天天气相同时，两者可合并为一个
    @SerializedName("numtq1")
    @Expose
    private String numTq1;  //白天天气编码
    @SerializedName("numtq2")
    @Expose
    private String numTq2;  //夜间天气编码
    @SerializedName("qw1")
    @Expose
    private String qw1;  //白天气温
    @SerializedName("qw2")
    @Expose
    private String qw2;  //夜间气温
    @SerializedName("fl1")
    @Expose
    private String fl1;  //白天风力
    @SerializedName("numfl1")
    @Expose
    private String numFl1;  //白天风力编码
    @SerializedName("fl2")
    @Expose
    private String fl2;  //夜间风力
    @SerializedName("numfl2")
    @Expose
    private String numFl2;  //夜间风力编码
    @SerializedName("fx1")
    @Expose
    private String fx1;  //白天风向
    @SerializedName("numfx1")
    @Expose
    private String numFx1;  //白天风向编码
    @SerializedName("fx2")
    @Expose
    private String fx2;  //夜间风向，如白天风力风向与夜间风力风向一致，可合并为一行
    @SerializedName("numfx2")
    @Expose
    private String numFx2;  //夜间风向编码
    @SerializedName("date")
    @Expose
    private String date;  //预报日期

    public String getTq1() {
        return tq1;
    }

    public void setTq1(String tq1) {
        this.tq1 = tq1;
    }

    public String getTq2() {
        return tq2;
    }

    public void setTq2(String tq2) {
        this.tq2 = tq2;
    }

    public String getNumTq1() {
        return numTq1;
    }

    public void setNumTq1(String numTq1) {
        this.numTq1 = numTq1;
    }

    public String getNumTq2() {
        return numTq2;
    }

    public void setNumTq2(String numTq2) {
        this.numTq2 = numTq2;
    }

    public String getQw1() {
        return qw1;
    }

    public void setQw1(String qw1) {
        this.qw1 = qw1;
    }

    public String getQw2() {
        return qw2;
    }

    public void setQw2(String qw2) {
        this.qw2 = qw2;
    }

    public String getFl1() {
        return fl1;
    }

    public void setFl1(String fl1) {
        this.fl1 = fl1;
    }

    public String getNumFl1() {
        return numFl1;
    }

    public void setNumFl1(String numFl1) {
        this.numFl1 = numFl1;
    }

    public String getFl2() {
        return fl2;
    }

    public void setFl2(String fl2) {
        this.fl2 = fl2;
    }

    public String getNumFl2() {
        return numFl2;
    }

    public void setNumFl2(String numFl2) {
        this.numFl2 = numFl2;
    }

    public String getFx1() {
        return fx1;
    }

    public void setFx1(String fx1) {
        this.fx1 = fx1;
    }

    public String getNumFx1() {
        return numFx1;
    }

    public void setNumFx1(String numFx1) {
        this.numFx1 = numFx1;
    }

    public String getFx2() {
        return fx2;
    }

    public void setFx2(String fx2) {
        this.fx2 = fx2;
    }

    public String getNumFx2() {
        return numFx2;
    }

    public void setNumFx2(String numFx2) {
        this.numFx2 = numFx2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
