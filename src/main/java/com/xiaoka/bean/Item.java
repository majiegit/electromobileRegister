package com.xiaoka.bean;

import java.io.Serializable;

public class Item implements Serializable {

	private int id;
	private int orderId;
	private int productId;
	private int productNum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", productNum=" + productNum
				+ "]";
	}

}
