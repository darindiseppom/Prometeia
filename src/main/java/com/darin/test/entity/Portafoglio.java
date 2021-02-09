package com.darin.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name="Portafoglio")
public class Portafoglio {

	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="Codice")
	private String Codice;
	
	@OneToOne
	@JoinColumn(name="NDG")
	private Cliente Cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodice() {
		return Codice;
	}

	public void setCodice(String codice) {
		Codice = codice;
	}

	public Cliente getCliente() {
		return Cliente;
	}

	public void setCliente(Cliente cliente) {
		Cliente = cliente;
	}

	@Override
	public String toString() {
		return "Portafoglio [id=" + id + ", Codice=" + Codice + ", Cliente=" + Cliente + "]";
	}
	
}
