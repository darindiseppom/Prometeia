package com.darin.test.entity;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SERIESTORICA")
public class SerieStorica implements Comparable<SerieStorica>{
	
	@EmbeddedId
	private SeriePk seriepk;
	
	@Column(name="PREZZO")
	private Double prezzo;
	

	public SerieStorica(SeriePk seriepk, Double prezzo) {
		super();
		this.seriepk = seriepk;
		this.prezzo = prezzo;
	}
	public SerieStorica() {
		
	}

	public SeriePk getSeriepk() {
		return seriepk;
	}

	public void setSeriepk(SeriePk seriepk) {
		this.seriepk = seriepk;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public int compareTo(SerieStorica o) {
		return seriepk.getData().compareTo(o.getSeriepk().getData());
	}
	@Override
	public String toString() {
		return "SerieStorica [seriepk=" + seriepk + ", prezzo=" + prezzo + "]";
	}
	
	
}
