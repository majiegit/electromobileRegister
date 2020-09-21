package com.xiaoka.bean;

import java.io.Serializable;
import java.util.Date;

public class EBC implements Serializable {
	private int carId;
	private String idCard;
	private String carType;
	private String carBodyNum;
	private String carEleNum;
	private String carUse;
	private String brand;
	private String color;
	private String buyDate;
	private String isComp;
	private String belong;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarBodyNum() {
		return carBodyNum;
	}

	public void setCarBodyNum(String carBodyNum) {
		this.carBodyNum = carBodyNum;
	}

	public String getCarEleNum() {
		return carEleNum;
	}

	public void setCarEleNum(String carEleNum) {
		this.carEleNum = carEleNum;
	}

	public String getCarUse() {
		return carUse;
	}

	public void setCarUse(String carUse) {
		this.carUse = carUse;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}

	public String getIsComp() {
		return isComp;
	}

	public void setIsComp(String isComp) {
		this.isComp = isComp;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}
}