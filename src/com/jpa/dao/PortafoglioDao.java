package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.jpa.entities.Portafoglio;
import com.jpa.utils.JpaUtils;

public class PortafoglioDao {


	private EntityManager em;
	private EntityTransaction et;

	public void persist(Portafoglio portafoglio) {
		em = null;
		et = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(portafoglio);
			em.flush();
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	public Portafoglio findById(Integer id) {
		em = null;
		Portafoglio portafoglio = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			portafoglio = em.find(Portafoglio.class, id);	
		} finally {
			em.close();
		}
		return portafoglio;		
	}

	@SuppressWarnings("unchecked")
	public List<Portafoglio> findAll() {
		em = null;
		List<Portafoglio> clienti = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query q = em.createQuery("SELECT u FROM Portafoglio u");
			clienti = q.getResultList();
		} finally {
			em.close();
		}
		return clienti;		
	}
	
}
