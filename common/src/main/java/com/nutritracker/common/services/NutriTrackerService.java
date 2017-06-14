package com.nutritracker.common.services;

import java.util.Set;

import org.joda.time.LocalDate;
import org.joda.time.YearMonth;

import com.nutritracker.common.exceptions.ServiceException;
import com.nutritracker.common.model.Food;
import com.nutritracker.common.model.Record;
import com.nutritracker.common.model.UserDailyNutriStat;
import com.nutritracker.common.model.UserHealthDetail;
import com.nutritracker.common.model.Usrr;

public interface NutriTrackerService {

	public UserDailyNutriStat calculateAdHocNutriStatsForFood(Record record) throws ServiceException;
	
	public Food obtainFoodStats(String foodId, String FoodDescription) throws ServiceException;
	
	public Set<UserDailyNutriStat> obtainStatsForMonth(Usrr usrr, YearMonth month) throws ServiceException;
	
	public UserDailyNutriStat obtainDailyRecord(Usrr usrr, LocalDate date) throws ServiceException;
	
	public UserDailyNutriStat obtainDailyRecord(Usrr usrr) throws ServiceException;
	
	public void recordEntry(Record record) throws ServiceException;
	
	public void addUserHealthDetail(UserHealthDetail userHealthDetail) throws ServiceException;
}
