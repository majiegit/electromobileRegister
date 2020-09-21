package com.xiaoka.bean;

import java.io.Serializable;

public class Pops implements Serializable {

	private int popsId;
	private String yName;
	private String province;
	private String city;
	private String area;
	private String street;
	private String address;
	private String phoneNum;
	private String pover;

	public int getPopsId() {
		return popsId;
	}

	public void setPopsId(int popsId) {
		this.popsId = popsId;
	}

	public String getyName() {
		return yName;
	}

	public void setyName(String yName) {
		this.yName = yName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPover() {
		return pover;
	}

	public void setPover(String pover) {
		this.pover = pover;
	}

	@Override
	public String toString() {
		return "Pops [popsId=" + popsId + ", yName=" + yName + ", province=" + province + ", city=" + city + ", area="
				+ area + ", street=" + street + ", address=" + address + ", phoneNum=" + phoneNum + ", pover=" + pover
				+ "]";
	}

}
