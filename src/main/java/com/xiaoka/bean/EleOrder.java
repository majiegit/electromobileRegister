package com.xiaoka.bean;

import java.io.Serializable;
import java.util.Date;

public class EleOrder implements Serializable {

	private int orderId;
	private int popsId;
	private int carId;
	private String idcard;
	private String username;
	private String province;
	private String city;
	private String area;
	private String street;
	private String address;
	private String phoneNum;
	private String codedLock;
	private String status;
	private int totalPrice;
	private String licenseNum;
	private String picProve;
	private Date addTime;
	private Date finishTime;
	private String type;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPopsId() {
		return popsId;
	}

	public void setPopsId(int popsId) {
		this.popsId = popsId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getCodedLock() {
		return codedLock;
	}

	public void setCodedLock(String codedLock) {
		this.codedLock = codedLock;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getPicProve() {
		return picProve;
	}

	public void setPicProve(String picProve) {
		this.picProve = picProve;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EleOrder [orderId=" + orderId + ", popsId=" + popsId + ", carId=" + carId + ", idcard=" + idcard
				+ ", username=" + username + ", province=" + province + ", city=" + city + ", area=" + area
				+ ", street=" + street + ", address=" + address + ", phoneNum=" + phoneNum + ", codedLock=" + codedLock
				+ ", status=" + status + ", totalPrice=" + totalPrice + ", licenseNum=" + licenseNum + ", picProve="
				+ picProve + ", addTime=" + addTime + ", finishTime=" + finishTime + ", type=" + type + "]";
	}

}
