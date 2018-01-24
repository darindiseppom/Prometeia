package com.jpa.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jpa.entities.SeriePk;
import com.jpa.entities.SerieStorica;
import com.jpa.utils.JpaUtils;

public class SerieStoricaDao {	

	private EntityManager em;
	private EntityTransaction et;

	public void persist(SerieStorica serieStorica) {
		em = null;
		et = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(serieStorica);
			em.flush();
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	// Metodo nel caso in cui optiamo per id come sola PK
	public SerieStorica findById(Integer id) {
		em = null;
		SerieStorica serieStorica = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			serieStorica = em.find(SerieStorica.class, id);	
		} finally {
			em.close();
		}
		return serieStorica;		
	}

	// Metodo nel caso in cui optiamo per la coppia CodiceTitolo e Data come PK
	public SerieStorica findById(SeriePk id) {
		em = null;
		SerieStorica serieStorica = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			serieStorica = em.find(SerieStorica.class, id);	
		} finally {
			em.close();
		}
		return serieStorica;		
	}

	@SuppressWarnings("unchecked")
	public List<SerieStorica> findAll() {
		em = null;
		List<SerieStorica> serieStorica = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query q = em.createQuery("SELECT u FROM SerieStorica u");
			serieStorica = q.getResultList();
		} finally {
			em.close();
		}
		return serieStorica;		
	}

	public SerieStorica findByDate(Date d) {
		em = null;
		SerieStorica s = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query query = em.createQuery("SELECT u FROM SerieStorica u WHERE u.dtrif = :dtrif");
			query.setParameter("dtrif", d);
			s = (SerieStorica) query.getSingleResult();
		} finally {
			em.close();
		}
		return s;		
	}
	
	@SuppressWarnings("unchecked")
	public List<SerieStorica> findByCodice(String d) {
		em = null;
		List<SerieStorica> s = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query query = em.createQuery("SELECT u FROM SerieStorica u WHERE u.seriepk.codTitolo = :dtrif");
			query.setParameter("dtrif", d);
			s = query.getResultList();
		} finally {
			em.close();
		}	
		return s;		
	}
	
	@SuppressWarnings("unchecked")
	public SerieStorica findRecente(String cod) {
		em = null;
		List<SerieStorica> s = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query query = em.createQuery("SELECT u FROM SerieStorica u WHERE u.codTitolo = :cod ORDER BY u.Data ASC");
			query.setParameter("cod", cod);
			s = query.getResultList();
			
		} finally {
			em.close();
		}
		return s.get(0);
	}
}
