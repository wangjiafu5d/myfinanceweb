package com.chuan.myfinanceweb.bean;

import java.util.Date;

public class Holdings {
    private Integer id;

    private String productid;

    private String delivermonth;

    private Integer rank;

    private String volumcomp;

    private Integer cj;

    private Integer cjchg;

    private String bcomp;

    private Integer buy;

    private Integer buychg;

    private String scomp;

    private Integer sell;

    private Integer sellchg;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getDelivermonth() {
        return delivermonth;
    }

    public void setDelivermonth(String delivermonth) {
        this.delivermonth = delivermonth == null ? null : delivermonth.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getVolumcomp() {
        return volumcomp;
    }

    public void setVolumcomp(String volumcomp) {
        this.volumcomp = volumcomp == null ? null : volumcomp.trim();
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

    public String getBcomp() {
        return bcomp;
    }

    public void setBcomp(String bcomp) {
        this.bcomp = bcomp == null ? null : bcomp.trim();
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

    public String getScomp() {
        return scomp;
    }

    public void setScomp(String scomp) {
        this.scomp = scomp == null ? null : scomp.trim();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Holdings(Integer id, String productid, String delivermonth, Integer rank, String volumcomp, Integer cj,
			Integer cjchg, String bcomp, Integer buy, Integer buychg, String scomp, Integer sell, Integer sellchg,
			Date date) {
		super();
		this.id = id;
		this.productid = productid;
		this.delivermonth = delivermonth;
		this.rank = rank;
		this.volumcomp = volumcomp;
		this.cj = cj;
		this.cjchg = cjchg;
		this.bcomp = bcomp;
		this.buy = buy;
		this.buychg = buychg;
		this.scomp = scomp;
		this.sell = sell;
		this.sellchg = sellchg;
		this.date = date;
	}

	public Holdings() {
		super();
	}
}