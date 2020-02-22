 package com.capg.onlinetestmanagement1.services;
    

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capg.onlinetestmanagement1.beans.Questions;
import com.capg.onlinetestmanagement1.beans.ExamTest;
import com.capg.onlinetestmanagement1.beans.User;
import com.capg.onlinetestmanagement1.dao.ITestDao;
import com.capg.onlinetestmanagement1.dao.TestDao;
import com.capg.onlinetestmanagement1.exceptions.AlreadyTestIsPresent;
import com.capg.onlinetestmanagement1.exceptions.NotPresentException;
import com.capg.onlinetestmanagement1.exceptions.MyException;

 

public class TestServices implements ITestServices {
     ITestDao dao=new TestDao();
     TestDao daoObj=new TestDao();
	public ExamTest addTest(ExamTest test) {
		 
		// TODO Auto-generated method stub
	  Map<Integer,ExamTest> testList=	daoObj.getMap();
	  if(testList.containsKey(test.getTestId())==true)
	  {   
		  try
		  {
		  throw new  MyException("alreadyPresent");
		  }
		  catch(MyException e)
		  {
			  
		  }
		  return null;
	  }
		return dao.addTest(test);
	}
    
	public ExamTest updateTest(ExamTest test,String testTitle) {
		// TODO Auto-generated method stub
	  
	   
		return dao.updateTest(test, testTitle);
	}

	public ExamTest deleteTest(int testId) {
		// TODO Auto-generated method stub
		return dao.deleteTest(testId);
	}

	public Set<Questions> assignTest(int userId, int testId) {
		// TODO Auto-generated method stub
		    Set<Questions> questionList=null;
		   Map<Integer,HashSet<Integer>> testTakenList= daoObj.getUserTestTakenList();
           if(testTakenList.containsKey(testId)==true)
 			{
        	   		HashSet<Integer> set=  testTakenList.get(testId);
        	   		if(set.contains(userId)==false)
        	   		{
        	   			 questionList= dao.assignTest(userId, testId);
        	   		}
        	   		else
        	   		{
        	   		   try {
        	   			throw new MyException("user already taken the test");
        	   		   }
        	   		   catch(MyException e)
        	   		   {
        	   			   
        	   		   }
        	   		}
 			     
 			}
          
 		   
		return questionList;
	}

	 
	public boolean validateId(int testId)
	{
		 boolean result=true;
		Map<Integer,ExamTest> map= daoObj.getMap();
		if(map.containsKey(testId))
		{
			result=false;
		}
		   
		 

		if(result==false)
		{
			try {
				throw new AlreadyTestIsPresent("test is already present");
			} catch (AlreadyTestIsPresent e) {
				// TODO Auto-generated catch block
				System.err.println("test is already present cannot proceed");
				System.exit(0);
			}
		}
		return result;

	}
	
	public boolean validateTestTitle(String testTitle)
	{  
		 boolean flag=true;
		if (testTitle.length() < 3 || testTitle.matches("[0-9][a-z A-Z 0-9]*")) {
			try {
				   flag=false;
				throw new MyException("Test title length should be greater than 3 and should start with character  ");
			} catch (MyException e) {
				// TODO Auto-generated catch block
				/*
				 * System.err.
				 * println("testtitle should be of length of 3 and it should start with character"
				 * ); System.err.println("cannot proceed try again");
				 */
				
			//	System.exit(0);
			}
		}
		return flag;

	}
	public boolean validateTime(LocalDateTime  startTime)
	{
		   boolean result=true;
		    LocalDateTime timeNow=LocalDateTime.now();
		    
		    LocalDateTime  nowTime=LocalDateTime.now();
			// System.out.println(nowTime);
			  
				
		   long minutes= ChronoUnit.MINUTES.between(nowTime, startTime);	
		   
		   if(minutes<0)
		   {    
			   try {
				   throw new MyException("Exam date should be in future..the time yo entered is in the past");
			   }
			   catch(MyException e)
			   {
				   
			   }
			   	result =false;
		   }
		    
		    return result;
		    
		
		
	}
	
	
	
	public boolean validateDuration(LocalDateTime startTime,LocalDateTime endTime,long duration)
	{
		 boolean result=false;
		 
		   
		   if(duration<=ChronoUnit.MINUTES.between(startTime, endTime))
			{
				result=true;
			}
		    
		
		  if(result==false) { try { throw new
		  AlreadyTestIsPresent("Duration is should be less than time between the starttime and end time"
		  );
		  
		  } catch (AlreadyTestIsPresent e) { // TODO Auto-generated catch block
		  System.err.println("duration should  set correctly ");
		  
		  } }
		 
		   return result;
	}
	
	public Map<Integer,ExamTest> getMap()
	{
		
		return daoObj.getMap();
	}
	
	public Map<Integer,HashSet<Integer>>  getListMap()
	{
		  return daoObj.getUserTestTakenList();
	}
	
	
}

