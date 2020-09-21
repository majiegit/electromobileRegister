package com.xiaoka.bean;

import java.io.Serializable;

public class CategoryProduct implements Serializable {

	private int id;
	private int categoryId;
	private int productId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "CategoryProduct [id=" + id + ", categoryId=" + categoryId + ", productId=" + productId + "]";
	}

}
