package com.capg.onlinetestmanagement1.exceptions;

public class MyException extends Exception{
	
	public MyException(String myException)
	{  
		super(myException);
		System.err.println(myException);
	}

}
