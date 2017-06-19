package com.nutritracker.repo.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.util.Assert.*;

import com.nutritracker.common.model.Persistable;
import com.nutritracker.common.repo.BasePersistableRepo;

public abstract class BasePersistableRepoImpl<T extends Persistable> implements BasePersistableRepo<T> {

	private static final long serialVersionUID = -2152575370949423685L;

	@Autowired
	@PersistenceContext
	EntityManager em;

	@Override
	public void save(T t) {
		notNull(t);
		if (t.getId() == null) {
			em.persist(t);
		} else {
			em.merge(t);
		}
	}

	public T findById(Serializable id) {
		notNull(id);
		return em.find(getType(), id);
	}

	protected abstract Class<T> getType();

}
