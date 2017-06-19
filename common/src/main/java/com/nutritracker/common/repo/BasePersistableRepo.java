package com.nutritracker.common.repo;

import java.io.Serializable;

import com.nutritracker.common.exceptions.RepositoryException;
import com.nutritracker.common.model.Persistable;

public interface BasePersistableRepo<T extends Persistable> extends Serializable {

	public void save(T t) throws RepositoryException;
	
	public T findById(Serializable id) throws RepositoryException;
}
