package com.xiaoka.bean;

import java.io.Serializable;

public class EBCOMP implements Serializable {
	private int id;
	private String compName;
	private String principal;
	private String principalIdCard;
	private String count;
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getPrincipalIdCard() {
		return principalIdCard;
	}

	public void setPrincipalIdCard(String principalIdCard) {
		this.principalIdCard = principalIdCard;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "EBCOMP [id=" + id + ", compName=" + compName + ", principal=" + principal + ", principalIdCard="
				+ principalIdCard + ", count=" + count + ", password=" + password + "]";
	}

}
