package com.nutritracker.common.exceptions;

public class RepositoryException extends Exception {

	private static final long serialVersionUID = 7092565078192557558L;

	public RepositoryException(String message) {
		super(message);
	}

	public RepositoryException(String message, Throwable t) {
		super(message, t);
	}

	public RepositoryException(Throwable t) {
		super(t);
	}
}
