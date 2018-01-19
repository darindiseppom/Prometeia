package com.jpa.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
public class Cliente {

	@Id
	@Column(name="NDG")
	private String ndg;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="COGNOME")	
	private String cognome;	
	
	public Cliente() {
		
	}
	
	public Cliente(String ndg, String nome, String cognome) {
		this.ndg = ndg;
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNdg() {
		return ndg;
	}
	public void setNdg(String ndg) {
		this.ndg = ndg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((ndg == null) ? 0 : ndg.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (ndg == null) {
			if (other.ndg != null)
				return false;
		} else if (!ndg.equals(other.ndg))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cliente [ndg=" + ndg + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
}
