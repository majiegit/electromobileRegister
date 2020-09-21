package com.xiaoka.bean;

import java.io.Serializable;

public class IdCardInfo implements Serializable {
	private int id;
	private String idcard;
	private String idcardPros;
	private String idcardCons;
	private String isPrincipal;
	private String compName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdcardPros() {
		return idcardPros;
	}

	public void setIdcardPros(String idcardPros) {
		this.idcardPros = idcardPros;
	}

	public String getIdcardCons() {
		return idcardCons;
	}

	public void setIdcardCons(String idcardCons) {
		this.idcardCons = idcardCons;
	}

	public String getIsPrincipal() {
		return isPrincipal;
	}

	public void setIsPrincipal(String isPrincipal) {
		this.isPrincipal = isPrincipal;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	@Override
	public String toString() {
		return "IdCardInfo [id=" + id + ", idcard=" + idcard + ", idcardPros=" + idcardPros + ", idcardCons="
				+ idcardCons + ", isPrincipal=" + isPrincipal + ", compName=" + compName + "]";
	}

}
