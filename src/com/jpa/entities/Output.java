package com.jpa.entities;

public class Output {
	
	Portafoglio p;
	Double controvalore;
	public Output(Portafoglio p, Double controvalore) {
		super();
		this.p = p;
		this.controvalore = controvalore;
	}
	public Portafoglio getP() {
		return p;
	}
	public void setP(Portafoglio p) {
		this.p = p;
	}
	public Double getControvalore() {
		return controvalore;
	}
	public void setControvalore(Double controvalore) {
		this.controvalore = controvalore;
	}
	
	
}
