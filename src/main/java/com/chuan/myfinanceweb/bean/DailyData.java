package com.chuan.myfinanceweb.bean;

import java.math.BigDecimal;
import java.util.Date;

public class DailyData {
    private Integer id;

    private String productid;

    private String productname;

    private String delivermonth;

    private BigDecimal presettlementprice;

    private BigDecimal openprice;

    private BigDecimal highestprice;

    private BigDecimal lowestprice;

    private BigDecimal closeprice;

    private BigDecimal settlementprice;

    private BigDecimal zd1Chg;

    private BigDecimal zd2Chg;

    private Integer volume;

    private Integer openinterest;

    private Integer openinterestchg;

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

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getDelivermonth() {
        return delivermonth;
    }

    public void setDelivermonth(String delivermonth) {
        this.delivermonth = delivermonth == null ? null : delivermonth.trim();
    }

    public BigDecimal getPresettlementprice() {
        return presettlementprice;
    }

    public void setPresettlementprice(BigDecimal presettlementprice) {
        this.presettlementprice = presettlementprice;
    }

    public BigDecimal getOpenprice() {
        return openprice;
    }

    public void setOpenprice(BigDecimal openprice) {
        this.openprice = openprice;
    }

    public BigDecimal getHighestprice() {
        return highestprice;
    }

    public void setHighestprice(BigDecimal highestprice) {
        this.highestprice = highestprice;
    }

    public BigDecimal getLowestprice() {
        return lowestprice;
    }

    public void setLowestprice(BigDecimal lowestprice) {
        this.lowestprice = lowestprice;
    }

    public BigDecimal getCloseprice() {
        return closeprice;
    }

    public void setCloseprice(BigDecimal closeprice) {
        this.closeprice = closeprice;
    }

    public BigDecimal getSettlementprice() {
        return settlementprice;
    }

    public void setSettlementprice(BigDecimal settlementprice) {
        this.settlementprice = settlementprice;
    }

    public BigDecimal getZd1Chg() {
        return zd1Chg;
    }

    public void setZd1Chg(BigDecimal zd1Chg) {
        this.zd1Chg = zd1Chg;
    }

    public BigDecimal getZd2Chg() {
        return zd2Chg;
    }

    public void setZd2Chg(BigDecimal zd2Chg) {
        this.zd2Chg = zd2Chg;
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

    public Integer getOpeninterestchg() {
        return openinterestchg;
    }

    public void setOpeninterestchg(Integer openinterestchg) {
        this.openinterestchg = openinterestchg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public DailyData(Integer id, String productid, String productname, String delivermonth,
			BigDecimal presettlementprice, BigDecimal openprice, BigDecimal highestprice, BigDecimal lowestprice,
			BigDecimal closeprice, BigDecimal settlementprice, BigDecimal zd1Chg, BigDecimal zd2Chg, Integer volume,
			Integer openinterest, Integer openinterestchg, Date date) {
		
		this.id = id;
		this.productid = productid;
		this.productname = productname;
		this.delivermonth = delivermonth;
		this.presettlementprice = presettlementprice;
		this.openprice = openprice;
		this.highestprice = highestprice;
		this.lowestprice = lowestprice;
		this.closeprice = closeprice;
		this.settlementprice = settlementprice;
		this.zd1Chg = zd1Chg;
		this.zd2Chg = zd2Chg;
		this.volume = volume;
		this.openinterest = openinterest;
		this.openinterestchg = openinterestchg;
		this.date = date;
	}
	public DailyData() {
		super();
	}
	@Override
	public String toString() {
		return this.id+"\n"+this.productid+"\n"+this.productname+"\n"+this.delivermonth+"\n"+
				this.presettlementprice+"\n"+this.openprice+"\n"+
				this.highestprice+"\n"+this.lowestprice+"\n"+this.closeprice+"\n"+
				this.settlementprice+"\n"+this.zd1Chg+"\n"+this.zd2Chg+"\n"+
				this.volume+"\n"+this.openinterest+"\n"+this.openinterestchg+"\n"+this.date;
	}
}