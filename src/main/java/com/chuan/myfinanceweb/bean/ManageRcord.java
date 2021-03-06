package com.chuan.myfinanceweb.bean;

import java.util.Date;

public class ManageRcord {
    private Integer id;

    private Date date;

    private String flag;

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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

	public ManageRcord(Integer id, Date date, String flag) {		
		this.id = id;
		this.date = date;
		this.flag = flag;
	}

	public ManageRcord() {
		super();
	}
}