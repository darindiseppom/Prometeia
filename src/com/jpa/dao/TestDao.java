package com.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jpa.entities.TestEntity;
import com.jpa.utils.JpaUtils;

@Repository
public class TestDao {	

	private EntityManager em;
	private EntityTransaction et;
	
	public TestEntity findByLabel(String label) {
		em = null;
		TestEntity result = null;
		try {
			em = JpaUtils.getInstance().getEntityManager();
			Query q = em.createQuery("SELECT u FROM Cliente u WHERE u.label LIKE :label");
			q.setParameter("nome", "%"+label+"%");
			result = (TestEntity) q.getSingleResult();
		} finally {
			em.close();
		}
		return result;
	}

}
