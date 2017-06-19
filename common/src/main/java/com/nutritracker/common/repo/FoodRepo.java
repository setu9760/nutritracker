package com.nutritracker.common.repo;

import java.util.List;

import com.nutritracker.common.exceptions.RepositoryException;
import com.nutritracker.common.model.Food;

public interface FoodRepo extends BasePersistableRepo<Food>{

	public Food findFoodByDesc(String desc) throws RepositoryException;
	
	public List<Food> findFoodLikeDesc(String desc) throws RepositoryException;
}
