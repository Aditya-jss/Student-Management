package com.example.api;

public class StudentDTO {
    private Integer id;
    private String name;
    private long mobile;
    private String country;

    

    @Override
    public String toString() {
        return "StudentDTO [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + "]";
    }

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
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
