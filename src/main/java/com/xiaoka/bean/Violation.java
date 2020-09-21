package com.xiaoka.bean;

import java.io.Serializable;
import java.util.Date;

public class Violation implements Serializable {
	private int violationId;
	private int violationFine;
	private int violationMark;
	private String licenseNum;
	private String violationSite;
	private String violationType;
	private String violationDriver;
	private Date violationDate;

	public int getViolationId() {
		return violationId;
	}

	public void setViolationId(int violationId) {
		this.violationId = violationId;
	}

	public int getViolationFine() {
		return violationFine;
	}

	public void setViolationFine(int violationFine) {
		this.violationFine = violationFine;
	}

	public int getViolationMark() {
		return violationMark;
	}

	public void setViolationMark(int violationMark) {
		this.violationMark = violationMark;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
	}

	public String getViolationSite() {
		return violationSite;
	}

	public void setViolationSite(String violationSite) {
		this.violationSite = violationSite;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public String getViolationDriver() {
		return violationDriver;
	}

	public void setViolationDriver(String violationDriver) {
		this.violationDriver = violationDriver;
	}

	public Date getViolationDate() {
		return violationDate;
	}

	public void setViolationDate(Date violationDate) {
		this.violationDate = violationDate;
	}

	@Override
	public String toString() {
		return "Violation [violationId=" + violationId + ", violationFine=" + violationFine + ", violationMark="
				+ violationMark + ", licenseNum=" + licenseNum + ", violationSite=" + violationSite + ", violationType="
				+ violationType + ", violationDriver=" + violationDriver + ", violationDate=" + violationDate + "]";
	}

}
