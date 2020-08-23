package com.aws.person.SpringDemo.services;

public class serviceExecption  extends Exception{
    private static final long serialVersionUID = 1L;

	public serviceExecption(String message) {
		super(message);
	}

	public serviceExecption(String message, Throwable cause) {
        super(message, cause);
    }
}