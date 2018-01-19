package com.jpa.entities;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity 
@Table(name="SALDO")
public class Saldo {
	
	@EmbeddedId
	private SaldoPk saldopk;
	
	@Column(name="QUANTITA")	
	private Double quantita;
	
	public SaldoPk getSaldopk() {
		return saldopk;
	}

	public void setSaldopk(SaldoPk saldopk) {
		this.saldopk = saldopk;
	}

	public Double getQuantita() {
		return quantita;
	}

	public void setQuantita(Double quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Saldo [saldopk=" + saldopk + ", quantita=" + quantita + "]";
	}


}
