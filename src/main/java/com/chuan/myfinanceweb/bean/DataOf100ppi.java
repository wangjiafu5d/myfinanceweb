package com.chuan.myfinanceweb.bean;

import java.math.BigDecimal;
import java.util.Date;

public class DataOf100ppi {
    private Integer id;

    private String productid;

    private String productname;

    private BigDecimal currentprice;

    private String delivermonth1;

    private BigDecimal settlementprice1;

    private BigDecimal jc1;

    private BigDecimal percent1;

    private String delivermonth2;

    private BigDecimal settlementprice2;

    private BigDecimal jc2;

    private BigDecimal percent2;

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

    public BigDecimal getCurrentprice() {
        return currentprice;
    }

    public void setCurrentprice(BigDecimal currentprice) {
        this.currentprice = currentprice;
    }

    public String getDelivermonth1() {
        return delivermonth1;
    }

    public void setDelivermonth1(String delivermonth1) {
        this.delivermonth1 = delivermonth1 == null ? null : delivermonth1.trim();
    }

    public BigDecimal getSettlementprice1() {
        return settlementprice1;
    }

    public void setSettlementprice1(BigDecimal settlementprice1) {
        this.settlementprice1 = settlementprice1;
    }

    public BigDecimal getJc1() {
        return jc1;
    }

    public void setJc1(BigDecimal jc1) {
        this.jc1 = jc1;
    }

    public BigDecimal getPercent1() {
        return percent1;
    }

    public void setPercent1(BigDecimal percent1) {
        this.percent1 = percent1;
    }

    public String getDelivermonth2() {
        return delivermonth2;
    }

    public void setDelivermonth2(String delivermonth2) {
        this.delivermonth2 = delivermonth2 == null ? null : delivermonth2.trim();
    }

    public BigDecimal getSettlementprice2() {
        return settlementprice2;
    }

    public void setSettlementprice2(BigDecimal settlementprice2) {
        this.settlementprice2 = settlementprice2;
    }

    public BigDecimal getJc2() {
        return jc2;
    }

    public void setJc2(BigDecimal jc2) {
        this.jc2 = jc2;
    }

    public BigDecimal getPercent2() {
        return percent2;
    }

    public void setPercent2(BigDecimal percent2) {
        this.percent2 = percent2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public DataOf100ppi(Integer id, String productid, String productname, BigDecimal currentprice, String delivermonth1,
			BigDecimal settlementprice1, BigDecimal jc1, BigDecimal percent1, String delivermonth2,
			BigDecimal settlementprice2, BigDecimal jc2, BigDecimal percent2, Date date) {
		super();
		this.id = id;
		this.productid = productid;
		this.productname = productname;
		this.currentprice = currentprice;
		this.delivermonth1 = delivermonth1;
		this.settlementprice1 = settlementprice1;
		this.jc1 = jc1;
		this.percent1 = percent1;
		this.delivermonth2 = delivermonth2;
		this.settlementprice2 = settlementprice2;
		this.jc2 = jc2;
		this.percent2 = percent2;
		this.date = date;
	}

	public DataOf100ppi() {
		super();
	}
	public String toString() {
		String str = this.id+" "+this.productid+" "+this.productname+" "+this.currentprice+" "+this.delivermonth1+" "
				+this.settlementprice1+" "+this.jc1+" "+this.percent1+" "+this.delivermonth2+" "+this.settlementprice2
				+" "+this.jc2+" "+this.percent2+" "+" "+this.date+" ";
		return str;
	}
}