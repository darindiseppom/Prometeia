/**
 * robgion
 * www.2clever.it
 *
 * @${date}
 * For further information please write to info@2clever.it
 */
package com.jpa.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.jpa.utils.JpaUtils;


public class GenericDaoImpl<T> implements GenericDao<T> {

	protected EntityManager em;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];

		this.em = JpaUtils.getInstance().getEntityManager();
	}

	public T create(final T t) {
		this.em.persist(t);
		return t;
	}

	public void delete(final Object id) {
		this.em.remove(this.em.getReference(type, id));
	}

	public T find(final Object id) {
		return (T) this.em.find(type, id);
	}

	public T update(final T t) {
		return this.em.merge(t);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override public List<T> findAll() {
 
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(type);

		Root root = criteriaQuery.from(type);
		
		
		criteriaQuery.select(root);

		return em.createQuery(criteriaQuery).getResultList();
	}
}
