package com.nutritracker.repo.impl;

import org.springframework.stereotype.Repository;

import com.nutritracker.common.model.UserHealthDetail;
import com.nutritracker.common.repo.UserHealthDetailsRepo;

@Repository("userHealthDetailsRepo")
public class UserHealthDetailsRepoImpl extends BasePersistableRepoImpl<UserHealthDetail> implements UserHealthDetailsRepo {

	private static final long serialVersionUID = -6348906975791778355L;

	@Override
	protected Class<UserHealthDetail> getType() {
		return UserHealthDetail.class;
	}

}
