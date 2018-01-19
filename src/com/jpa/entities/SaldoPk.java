package com.jpa.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SaldoPk implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="ID_PTF")
	private Portafoglio portafoglio;
	
	@ManyToOne
	@JoinColumn(name="CODICETITOLO")
	private StrumentoFinanziario strumentoFinanziario;
	
	@Column(name="DATA")
	private Date data;

	public SaldoPk() {
		// TODO Auto-generated constructor stub
	}

	public SaldoPk(Portafoglio portafoglio, StrumentoFinanziario strumentoFinanziario, Date data) {
		this.portafoglio = portafoglio;
		this.strumentoFinanziario = strumentoFinanziario;
		this.data = data;
	}

	public Portafoglio getPortafoglio() {
		return portafoglio;
	}

	public void setPortafoglio(Portafoglio portafoglio) {
		this.portafoglio = portafoglio;
	}

	public StrumentoFinanziario getStrumentoFinanziario() {
		return strumentoFinanziario;
	}

	public void setStrumentoFinanziario(StrumentoFinanziario strumentoFinanziario) {
		this.strumentoFinanziario = strumentoFinanziario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}