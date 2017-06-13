package com.nutritracker.common.repo;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.nutritracker.common.model.Persistable;

public abstract class BasePersistableRepoImpl<T extends Persistable> implements BasePersistableRepo<T>{

	@Autowired
	private EntityManager em;

	@Override
	public void save(T t) {
		if (t.getId() == null) {
			em.persist(t);
		} else {
			em.merge(t);
		}
	}

	public T findById(Serializable id) {
		return em.find(getType(), id);
	}

	protected abstract Class<T> getType();

}
