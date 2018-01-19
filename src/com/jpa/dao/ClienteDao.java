package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.jpa.entities.Cliente;
import com.jpa.utils.JpaUtils;

public class ClienteDao {	

	private EntityManager em;
	private EntityTransaction et;

	public void persist(Cliente cliente) {
		em = null;
		et = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(cliente);
			em.flush();
			et.commit();
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	public Cliente findById(String id) {
		em = null;
		Cliente cliente = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			cliente = em.find(Cliente.class, id);	
		} finally {
			em.close();
		}
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findAll() {
		em = null;
		List<Cliente> clienti = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query q = em.createQuery("SELECT u FROM Cliente u");
			clienti = q.getResultList();
		} finally {
			em.close();
		}
		return clienti;		
	}
}
