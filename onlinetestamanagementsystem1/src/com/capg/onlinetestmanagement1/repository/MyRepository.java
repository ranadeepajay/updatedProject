/*
 * package com.capg.onlinetestmanagement1.repository;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * public class MyRepository {
 * 
 * static Set<String> testTitleList=new HashSet<String>();
 * 
 * public static boolean isValidTestTitle(String TestTitle) { boolean
 * result=false; if(testTitleList.contains(testTitleList)) {
 * 
 * }
 * 
 * 
 * 
 * return result;
 * 
 * 
 * }
 * 
 * }
 */

package com.capg.onlinetestmanagement1.repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capg.onlinetestmanagement1.beans.Questions;
import com.capg.onlinetestmanagement1.beans.ExamTest;
import com.capg.onlinetestmanagement1.beans.User;

public class MyRepository {
	
 
	  public static Map<Integer,ExamTest>  testList=new HashMap<Integer,ExamTest>();
      public static Set<Integer>  userList=new HashSet<Integer>();
	  public static Map<Integer,HashSet<Integer>> userTestTakenList=new HashMap<Integer,HashSet<Integer>>();
	  
	   public static ExamTest addTest(ExamTest test)
	   {    
		   //if(testList.containsKey(test.getTestId()))
			 //   return null;
		 
		 //  else
			  // { testList.put(test.getTestId(),test);
			        
			        HashSet<Integer> uIdList=new HashSet<Integer>();
			       userTestTakenList.put(test.getTestId(),uIdList);
			       testList.put(test.getTestId(), test);
			         
			      //  System.out.println(testList);
			       // System.out.println(userTestTakenList);
		//	   }
			   
		    return test;
		     
	   }
	   public static ExamTest updateTest(ExamTest test,String testTitle)
	   {
		      test.setTestTitle(testTitle);
		      ExamTest test1=testList.put(test.getTestId(),test);
		      
		    //    System.out.println(testList);
		    
			 return test1;
	   }
     
	   public static ExamTest DeleteTest(int testId)
	   {
		   
		   //System.out.println(testList);
		   
		     
		    	 ExamTest test=	 testList.remove(testId);
		    	System.out.println(testList);
		     return test;
	   }
	   public static Set<Questions> assignTest(int userId,int testId)
	   { 
		         
		        ExamTest test=  testList.get(testId);
		        Set<Questions> questionsList= test.getTestQuestions();
		       
		        HashSet<Integer> userx=new HashSet<Integer>();
		        userx.add(userId);
		        userTestTakenList.put(testId, userx);
		   
		   return questionsList;
	   }
    
	   

	public static Map<Integer, HashSet<Integer>> getUserTestTakenList() {
		return userTestTakenList;
	}
	public static void setUserTestTakenList(Map<Integer, HashSet<Integer>> userTestTakenList) {
		MyRepository.userTestTakenList = userTestTakenList;
	}
	public static Map<Integer, ExamTest> getTestList() {
		return testList;
	}



	public static void setTestList(Map<Integer, ExamTest> testList) {
		MyRepository.testList = testList;
	}
	   

}
