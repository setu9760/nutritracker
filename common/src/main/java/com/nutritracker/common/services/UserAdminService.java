package com.nutritracker.common.services;

import com.nutritracker.common.exceptions.ServiceException;
import com.nutritracker.common.model.UserLoginDetail;

public interface UserAdminService {

	public void createNewUser(UserLoginDetail userLoginDetail) throws ServiceException;
	
	public void updateUser(UserLoginDetail userLoginDetail) throws ServiceException;
	
}
