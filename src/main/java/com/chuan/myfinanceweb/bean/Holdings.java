package com.chuan.myfinanceweb.bean;

import java.util.Date;

public class Holdings {
    private Integer id;

    private Byte rank;

    private String companyname;

    private Integer cj;

    private Integer cjchg;

    private Integer buy;

    private Integer buychg;

    private Integer sell;

    private Integer sellchg;

    private String type;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getRank() {
        return rank;
    }

    public void setRank(Byte rank) {
        this.rank = rank;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
    }

    public Integer getCj() {
        return cj;
    }

    public void setCj(Integer cj) {
        this.cj = cj;
    }

    public Integer getCjchg() {
        return cjchg;
    }

    public void setCjchg(Integer cjchg) {
        this.cjchg = cjchg;
    }

    public Integer getBuy() {
        return buy;
    }

    public void setBuy(Integer buy) {
        this.buy = buy;
    }

    public Integer getBuychg() {
        return buychg;
    }

    public void setBuychg(Integer buychg) {
        this.buychg = buychg;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Integer getSellchg() {
        return sellchg;
    }

    public void setSellchg(Integer sellchg) {
        this.sellchg = sellchg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}