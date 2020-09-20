package com.chuan.myfinanceweb.bean;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Dailydatasum {
    private Integer id;

    private Date date;

    private String productname;

    private Double highestprice;

    private Double lowestprice;

    private Double avgprice;

    private Integer volume;

    private Integer openinterest;

    private Double turnover;

    private Double yearvolume;

    private Double yearturnover;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Double getHighestprice() {
        return highestprice;
    }

    public void setHighestprice(Double highestprice) {
        this.highestprice = highestprice;
    }

    public Double getLowestprice() {
        return lowestprice;
    }

    public void setLowestprice(Double lowestprice) {
        this.lowestprice = lowestprice;
    }

    public Double getAvgprice() {
        return avgprice;
    }

    public void setAvgprice(Double avgprice) {
        this.avgprice = avgprice;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getOpeninterest() {
        return openinterest;
    }

    public void setOpeninterest(Integer openinterest) {
        this.openinterest = openinterest;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Double getYearvolume() {
        return yearvolume;
    }

    public void setYearvolume(Double yearvolume) {
        this.yearvolume = yearvolume;
    }

    public Double getYearturnover() {
        return yearturnover;
    }

    public void setYearturnover(Double yearturnover) {
        this.yearturnover = yearturnover;
    }
}