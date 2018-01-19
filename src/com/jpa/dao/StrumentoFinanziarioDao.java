package com.jpa.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jpa.entities.Cliente;
import com.jpa.entities.Portafoglio;
import com.jpa.entities.Saldo;
import com.jpa.entities.SerieStorica;
import com.jpa.entities.StrumentoFinanziario;
import com.jpa.utils.JpaUtils;

public class StrumentoFinanziarioDao {	

	private EntityManager em;
	private EntityTransaction et;

	public void persist(StrumentoFinanziario strumentoFinanziario) {
		em = null;
		et = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(strumentoFinanziario);
			em.flush();
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public StrumentoFinanziario findById(Integer id) {
		em = null;
		StrumentoFinanziario str_fin = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			str_fin = em.find(StrumentoFinanziario.class, id);	
		} finally {
			em.close();
		}
		return str_fin;
	}
	
	// Non dovrei usarla per il fatto che la PK dovrebbe essere Integer
	public StrumentoFinanziario findById(String id) {
		em = null;
		StrumentoFinanziario str_fin = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			str_fin = em.find(StrumentoFinanziario.class, id);	
		} finally {
			em.close();
		}
		return str_fin;
	}

	public List<StrumentoFinanziario> findAll() {
		em = null;
		List<StrumentoFinanziario> strumentiFinanziari = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query q = em.createQuery("SELECT u FROM StrumentoFinanziario u");
			strumentiFinanziari = q.getResultList();
		} finally {
			em.close();
		}
		return strumentiFinanziari;		
	}
}
