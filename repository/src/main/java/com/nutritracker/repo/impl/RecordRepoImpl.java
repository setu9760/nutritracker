package com.nutritracker.repo.impl;

import org.springframework.stereotype.Repository;

import com.nutritracker.common.model.Record;
import com.nutritracker.common.repo.RecordRepo;

@Repository("recordRepo")
public class RecordRepoImpl extends BasePersistableRepoImpl<Record> implements RecordRepo {

	private static final long serialVersionUID = -7992402648323585851L;

	@Override
	protected Class<Record> getType() {
		return Record.class;
	}

}
