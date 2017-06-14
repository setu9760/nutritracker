package com.nutritracker.common.exceptions;

import com.nutritracker.common.utils.I18N;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 4459262758212718268L;

	public ServiceException(String operationName, Throwable t) {
		super(I18N.getString("service.exception", operationName), t);
	}
	
	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(Throwable t) {
		super(t);
	}
}
