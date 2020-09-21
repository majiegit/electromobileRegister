package com.xiaoka.bean;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {

	private int productId;
	private String name;
	private Date addTime;
	private String remark;
	private int fixedPrice;
	private String description;
	private String isShow;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getFixedPrice() {
		return fixedPrice;
	}

	public void setFixedPrice(int fixedPrice) {
		this.fixedPrice = fixedPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsShow() {
		return isShow;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", addTime=" + addTime + ", remark=" + remark
				+ ", fixedPrice=" + fixedPrice + ", description=" + description + ", isShow=" + isShow + "]";
	}

}
