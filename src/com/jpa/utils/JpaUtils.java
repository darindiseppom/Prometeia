package com.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {

	private static JpaUtils _instance = null;
	private EntityManagerFactory emfactory = null;
	
	/**
	 * Costruttore private per l'implementazione del pattern Singleton
	 */
	private JpaUtils() {
		
		try {
			
			emfactory = Persistence.
					createEntityManagerFactory("jpaTest");
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	/**
	 * Metodo di recupero dell'istanza Singleton.
	 * @return
	 */
	public static synchronized JpaUtils getInstance() {
		if(_instance == null) {
			_instance = new JpaUtils();
		}
		return _instance;
	}
	
	/**
	 * Metodo per il recupero dell'EntityManager.
	 * @return
	 */
	public EntityManager getEntityManager() {
		return emfactory.createEntityManager();
	}
	
	public static void main(String[] args) {
		JpaUtils.getInstance();
	}
}
