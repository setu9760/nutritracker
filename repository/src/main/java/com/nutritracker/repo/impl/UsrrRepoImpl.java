package com.nutritracker.repo.impl;

import static org.springframework.util.Assert.notNull;

import org.springframework.stereotype.Repository;

import com.nutritracker.common.model.Usrr;
import com.nutritracker.common.repo.UsrrRepo;

@Repository("usrrRepo")
public class UsrrRepoImpl extends BasePersistableRepoImpl<Usrr> implements UsrrRepo {

	private static final long serialVersionUID = -4387495160393741606L;

	@Override
	public void save(Usrr u) {
		notNull(u);
		if (findById(u.getUsername()) != null)
			em.merge(u);
		else
			em.persist(u);
	}

	@Override
	protected Class<Usrr> getType() {
		return Usrr.class;
	}

}
