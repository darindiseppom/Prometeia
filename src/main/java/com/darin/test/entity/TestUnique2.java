package com.darin.test.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TestUnique2 {
	
	@Column(name = "GRUPPO")
	private String gruppo;
	
	@Column(name = "COLUMN2")
	private String codBanca;

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public String getCodBanca() {
		return codBanca;
	}

	public void setCodBanca(String codBanca) {
		this.codBanca = codBanca;
	}

	@Override
	public String toString() {
		return "TestUnique2 [gruppo=" + gruppo + ", codBanca=" + codBanca + "]";
	}
	
	
}
