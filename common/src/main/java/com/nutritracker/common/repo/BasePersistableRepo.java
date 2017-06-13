package com.nutritracker.common.repo;

import java.io.Serializable;

import com.nutritracker.common.model.Persistable;

public interface BasePersistableRepo<T extends Persistable> {

	public void save(T t);
	
	public T findById(Serializable id);
}
