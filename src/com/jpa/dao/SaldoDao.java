package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.jpa.entities.Saldo;
import com.jpa.entities.SaldoPk;
import com.jpa.utils.JpaUtils;

public class SaldoDao {	

	private EntityManager em;
	private EntityTransaction et;

	public void persist(Saldo saldo) {
		em = null;
		et = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(saldo);
			em.flush();
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
	
	// Non dovrebbe servirci
	public List<Saldo> findByNdg(String ndg) {
		em = null;
		List<Saldo> s = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query query = em.createQuery("SELECT u FROM Saldo u JOIN FETCH u.cliente i WHERE i.ndg = :ndg");
			query.setParameter("ndg", ndg);
			s = query.getResultList();
		} finally {
			em.close();
		}
		return s;
	}

	// Non dovrebbe servirci
	public List<Saldo> findByCodTitolo(String codTitolo) {
		em = null;
		List<Saldo> s = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query query = em.createQuery("SELECT u FROM Saldo u JOIN FETCH u.saldopk.strumentoFinanziario s WHERE s.codtitolo = :codTitolo");
			query.setParameter("codTitolo", codTitolo);
			s = query.getResultList();
		} finally {
			em.close();
		}
		return s;
	}
	

	public Saldo findById(Integer id) {
		em = null;
		Saldo saldo = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			saldo = em.find(Saldo.class, id);	
		} finally {
			em.close();
		}
		return saldo;		
	}
	
	public Saldo findById(SaldoPk id) {
		em = null;
		Saldo saldo = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			saldo = em.find(Saldo.class, id);	
		} finally {
			em.close();
		}
		return saldo;		
	}

	@SuppressWarnings("unchecked")
	public List<Saldo> findAll() {
		em = null;
		List<Saldo> saldi = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query q = em.createQuery("SELECT u FROM Saldo u");
			saldi = q.getResultList();
		} finally {
			em.close();
		}
		return saldi;		
	}
	
	public List<Saldo> findByIdPtf(Integer id) {
		em = null;
		List<Saldo> saldi = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query q = em.createQuery("SELECT u FROM Saldo u JOIN FETCH u.saldopk.portafoglio p WHERE p.id = :id");
			q.setParameter("id", id);
			saldi = q.getResultList();
		} finally {
			em.close();
		}
		return saldi;		
	}
	
	public void delete(Saldo s) {
		em = null;
		et = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(s);
			em.flush();
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}
}
