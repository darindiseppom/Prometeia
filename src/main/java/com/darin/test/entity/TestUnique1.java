package com.darin.test.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TestUnique1 {
	
	@Column(name = "GRUPPO")
	private String gruppo;
	
	@Column(name = "COLUMN1")
	private String codProm;

	public String getGruppo() {
		return gruppo;
	}

	public void setGruppo(String gruppo) {
		this.gruppo = gruppo;
	}

	public String getCodProm() {
		return codProm;
	}

	public void setCodProm(String codProm) {
		this.codProm = codProm;
	}

	@Override
	public String toString() {
		return "TestUnique1 [gruppo=" + gruppo + ", codProm=" + codProm + "]";
	}
	
	
	
}
