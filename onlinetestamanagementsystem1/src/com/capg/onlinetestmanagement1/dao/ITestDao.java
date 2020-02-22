/*

 * package com.capg.onlinetestmanagement1.dao;
 * 
 * public interface ITestDao {
 * 
 * }
 */

package com.capg.onlinetestmanagement1.dao;

import java.util.List;
import java.util.Set;

import com.capg.onlinetestmanagement1.beans.Questions;
import com.capg.onlinetestmanagement1.beans.ExamTest;
import com.capg.onlinetestmanagement1.beans.User;

public interface ITestDao {
     
	
	

	   ExamTest addTest(ExamTest test);
	   ExamTest updateTest(ExamTest test,String testTitle);
	   ExamTest deleteTest(int test);
	   Set<Questions>  assignTest(int userId,int testId);
	 
}






