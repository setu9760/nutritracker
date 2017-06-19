package com.nutritracker.repo.impl;

import static org.springframework.util.Assert.notNull;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nutritracker.common.exceptions.RepositoryException;
import com.nutritracker.common.model.Food;
import com.nutritracker.common.repo.FoodRepo;

@Repository("foodRepo")
public class FoodRepoImpl extends BasePersistableRepoImpl<Food> implements FoodRepo {

	private static final long serialVersionUID = 4460579630943004119L;

	@Override
	public Food findFoodByDesc(String desc) throws RepositoryException {
		notNull(desc);
		return em.createNamedQuery("findFoodByDesc", getType()).setParameter("desc", desc).getSingleResult();
	}

	@Override
	public List<Food> findFoodLikeDesc(String desc) throws RepositoryException {
		notNull(desc);
		return em.createNamedQuery("findFoodLikeDesc", getType()).setParameter("desc", "%" + desc.toLowerCase() + "%").getResultList();
	}

	@Override
	protected Class<Food> getType() {
		return Food.class;
	}

}
