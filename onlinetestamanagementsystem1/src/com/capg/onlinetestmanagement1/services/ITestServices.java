/*
 * package com.capg.onlinetestamanagement1.services;
 * 
 * public interface ITestServices {
 * 
 * }
 * 
 * package com.capg.onlinetestmanagement1.services;
 * 
 * import java.util.List;
 * 
 * 
 * import com.capg.onlinetestmanagement1.beans.Questions; import
 * com.capg.onlinetestmanagement1.beans.Test; import
 * com.capg.onlinetestmanagement1.beans.User;
 * 
 * public interface ITestServices {
 * 
 * Test addTest(Test test);
 * 
 * Test updateTest(Test test);
 * 
 * Test deleteTest(Test test);
 * 
 * List<Questions> assignTest(User userId, int testId);
 * 
 * }
 * 
 */
package com.capg.onlinetestmanagement1.services;

import java.util.List;
import java.util.Set;

import com.capg.onlinetestmanagement1.beans.Questions;
import com.capg.onlinetestmanagement1.beans.ExamTest;
import com.capg.onlinetestmanagement1.beans.User;

public interface ITestServices {

	
	   ExamTest addTest(ExamTest test);
	   ExamTest updateTest(ExamTest test,String testTitle);
	   ExamTest deleteTest(int testId);
	   Set<Questions>  assignTest(int userId,int testId);
	   
	   
	
}




