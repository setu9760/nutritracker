package com.nutritracker.repo.impl;

import static org.springframework.util.Assert.notNull;

import org.springframework.stereotype.Repository;

import com.nutritracker.common.model.UserLoginDetail;
import com.nutritracker.common.repo.UserLoginDetailRepo;

@Repository("userLoginDetaiRepo")
public class UserLoginDetaiRepoImpl extends BasePersistableRepoImpl<UserLoginDetail> implements UserLoginDetailRepo {

	private static final long serialVersionUID = 8586233333725401382L;

	@Override
	public void save(UserLoginDetail uld) {
		notNull(uld);
		if (findById(uld.getUsername()) != null)
			em.merge(uld);
		else
			em.persist(uld);
	}

	@Override
	protected Class<UserLoginDetail> getType() {
		return UserLoginDetail.class;
	}

}
