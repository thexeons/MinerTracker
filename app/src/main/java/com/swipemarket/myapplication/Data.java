package com.swipemarket.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ervan on 21/06/17.
 */

public class Data {
    @SerializedName("high")
    @Expose
    private Integer high;

    @SerializedName("low")
    @Expose
    private Integer low;

    @SerializedName("vol_btc")
    @Expose
    private float vol_btc;

    @SerializedName("vol_idr")
    @Expose
    private float vol_idr;

    @SerializedName("last")
    @Expose
    private Integer last;

    @SerializedName("buy")
    @Expose
    private Integer buy;

    @SerializedName("sell")
    @Expose
    private Integer sell;

    @SerializedName("server_time")
    @Expose
    private Integer server_time;

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public Integer getLow() {
        return low;
    }

    public void setLow(Integer low) {
        this.low = low;
    }

    public float getVol_btc() {
        return vol_btc;
    }

    public void setVol_btc(float vol_btc) {
        this.vol_btc = vol_btc;
    }

    public float getVol_idr() {
        return vol_idr;
    }

    public void setVol_idr(float vol_idr) {
        this.vol_idr = vol_idr;
    }

    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Integer getServer_time() {
        return server_time;
    }

    public void setServer_time(Integer server_time) {
        this.server_time = server_time;
    }
}
