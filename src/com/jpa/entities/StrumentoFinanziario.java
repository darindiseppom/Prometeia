package com.jpa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STRUMENTOFINANZIARIO")
public class StrumentoFinanziario {
	
	@Id
	@Column(name="CODICETITOLO")
	private String codtitolo;
	
	@Column(name="ISIN")
	private String isin;
	
	@Column(name="DESCRIZIONE")
	private String descrizione;
	
	@Column(name="DIVISA")
	private String divisa;
	
	@Column(name="TIPO_STRUMENTO")
	private String tipo;
	
	@Column(name="ASSET_CLASS")
	private String assets_class;
	
	@Column(name="PIAZZA")
	private String piazza;
	
	@Column(name="TASSO_DI_CAMBIO")
	private Double tassoCambio;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="CODICETITOLO")	
	private List<SerieStorica> serieStorica;
	
	public StrumentoFinanziario() {
	}
	
	public StrumentoFinanziario(String codtitolo, String isin, String descrizione, String divisa,
			String tipo, String assets_class, Double tassoCambio) {
		this.codtitolo = codtitolo;
		this.isin = isin;
		this.descrizione = descrizione;
		this.divisa = divisa;
		this.tipo = tipo;
		this.assets_class = assets_class;
		this.tassoCambio = tassoCambio;
	}

	public String getCodtitolo() {
		return codtitolo;
	}
	public void setCodtitolo(String codtitolo) {
		this.codtitolo = codtitolo;
	}
	public String getPiazza() {
		return piazza;
	}
	public void setPiazza(String piazza) {
		this.piazza = piazza;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getDivisa() {
		return divisa;
	}
	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getAssets_class() {
		return assets_class;
	}
	public void setAssets_class(String assets_class) {
		this.assets_class = assets_class;
	}
	public Double getTassoCambio() {
		return tassoCambio;
	}
	public void setTassoCambio(Double tassoCambio) {
		this.tassoCambio = tassoCambio;
	}
	public List<SerieStorica> getSerieStorica() {
		return serieStorica;
	}
	public void setSerieStorica(List<SerieStorica> serieStorica) {
		this.serieStorica = serieStorica;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assets_class == null) ? 0 : assets_class.hashCode());
		result = prime * result + ((codtitolo == null) ? 0 : codtitolo.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((divisa == null) ? 0 : divisa.hashCode());
		result = prime * result + ((isin == null) ? 0 : isin.hashCode());
		result = prime * result + ((serieStorica == null) ? 0 : serieStorica.hashCode());
		result = prime * result + ((tassoCambio == null) ? 0 : tassoCambio.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StrumentoFinanziario other = (StrumentoFinanziario) obj;
		if (assets_class == null) {
			if (other.assets_class != null)
				return false;
		} else if (!assets_class.equals(other.assets_class))
			return false;
		if (codtitolo == null) {
			if (other.codtitolo != null)
				return false;
		} else if (!codtitolo.equals(other.codtitolo))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (divisa == null) {
			if (other.divisa != null)
				return false;
		} else if (!divisa.equals(other.divisa))
			return false;
		if (isin == null) {
			if (other.isin != null)
				return false;
		} else if (!isin.equals(other.isin))
			return false;
		if (serieStorica == null) {
			if (other.serieStorica != null)
				return false;
		} else if (!serieStorica.equals(other.serieStorica))
			return false;
		if (tassoCambio == null) {
			if (other.tassoCambio != null)
				return false;
		} else if (!tassoCambio.equals(other.tassoCambio))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StrumentoFinanziario [codtitolo=" + codtitolo + ", isin=" + isin + ", descrizione=" + descrizione
				+ ", divisa=" + divisa + ", tipo=" + tipo + ", assets_class=" + assets_class + ", piazza=" + piazza
				+ ", tassoCambio=" + tassoCambio + "]";
	}

	
	
}
