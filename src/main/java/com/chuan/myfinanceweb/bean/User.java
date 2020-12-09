package com.chuan.myfinanceweb.bean;

public class User {
    private Integer id;

    private String name;

    private String password;

    private String email;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	public User() {
		super();
	}

	public User(Integer id, String name, String password, String email, String phone) {
		
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
}