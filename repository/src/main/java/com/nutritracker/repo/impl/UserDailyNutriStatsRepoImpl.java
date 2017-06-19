package com.nutritracker.repo.impl;

import org.springframework.stereotype.Repository;

import com.nutritracker.common.model.UserDailyNutriStat;
import com.nutritracker.common.repo.UserDailyNutriStatsRepo;

@Repository("userDailyNutriStatsRepo")
public class UserDailyNutriStatsRepoImpl extends BasePersistableRepoImpl<UserDailyNutriStat> implements UserDailyNutriStatsRepo {

	private static final long serialVersionUID = -1406826690626328176L;

	@Override
	protected Class<UserDailyNutriStat> getType() {
		return UserDailyNutriStat.class;
	}

}
