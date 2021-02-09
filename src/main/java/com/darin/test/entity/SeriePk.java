package com.darin.test.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SeriePk implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="CODICETITOLO")
	private String codTitolo; 
	
	@Column(name="DATA")
	private Date Data;
	
	public SeriePk() {
	}

	public SeriePk(String codTitolo, Date data) {
		super();
		this.codTitolo = codTitolo;
		Data = data;
	}

	public String getCodTitolo() {
		return codTitolo;
	}

	public void setCodTitolo(String codTitolo) {
		this.codTitolo = codTitolo;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	@Override
	public String toString() {
		return "SeriePK [codTitolo=" + codTitolo + ", Data=" + Data + "]";
	}
	
	
}