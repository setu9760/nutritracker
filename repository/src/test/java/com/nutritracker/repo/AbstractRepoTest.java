package com.nutritracker.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.nutritracker.common.repo.FoodRepo;
import com.nutritracker.common.repo.RecordRepo;
import com.nutritracker.common.repo.UserDailyNutriStatsRepo;
import com.nutritracker.common.repo.UserHealthDetailsRepo;
import com.nutritracker.common.repo.UserLoginDetailRepo;
import com.nutritracker.common.repo.UsrrRepo;
import com.nutritracker.repo.config.RepoConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(classes = RepoConfiguration.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class AbstractRepoTest {

	@Autowired
	private FoodRepo foodRepo;

	@Autowired
	private RecordRepo recordRepo;

	@Autowired
	private UserDailyNutriStatsRepo userDailyNutriStatsRepo;

	@Autowired
	private UserHealthDetailsRepo userHealthDetailsRepo;

	@Autowired
	private UserLoginDetailRepo userLoginDetailRepo;

	@Autowired
	private UsrrRepo usrrRepo;

	@Test()
	public void doTest() throws Exception {

	}

}
