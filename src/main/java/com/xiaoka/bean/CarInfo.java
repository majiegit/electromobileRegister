package com.xiaoka.bean;

import java.io.Serializable;

public class CarInfo implements Serializable {
	private int id;
	private int carId;
	private String carP1;
	private String carP2;
	private String carP3;
	private String carP4;
	private String carP5;
	private String isComp;
	private String compName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCarP1() {
		return carP1;
	}
	public void setCarP1(String carP1) {
		this.carP1 = carP1;
	}
	public String getCarP2() {
		return carP2;
	}
	public void setCarP2(String carP2) {
		this.carP2 = carP2;
	}
	public String getCarP3() {
		return carP3;
	}
	public void setCarP3(String carP3) {
		this.carP3 = carP3;
	}
	public String getCarP4() {
		return carP4;
	}
	public void setCarP4(String carP4) {
		this.carP4 = carP4;
	}
	public String getCarP5() {
		return carP5;
	}
	public void setCarP5(String carP5) {
		this.carP5 = carP5;
	}
	public String getIsComp() {
		return isComp;
	}
	public void setIsComp(String isComp) {
		this.isComp = isComp;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	@Override
	public String toString() {
		return "CarInfo [id=" + id + ", carId=" + carId + ", carP1=" + carP1 + ", carP2=" + carP2 + ", carP3=" + carP3
				+ ", carP4=" + carP4 + ", carP5=" + carP5 + ", isComp=" + isComp + ", compName=" + compName + "]";
	}

	
}
