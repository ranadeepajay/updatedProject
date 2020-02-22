/*
 * package com.capg.onlinetestamanagementsystem1.ui;
 * 
 * public class Generators {
 * 
 * }
 */
package com.capg.onlinetestmanagement1.ui;

/*
 * public class Generators {
 * 
 * public static int generateId(String testTitle) { int length =
 * testTitle.length();
 * 
 * int generatedId = 0; generatedId = testTitle.hashCode();
 * 
 * return generatedId; } }
 */
 

public class Generators {
	 
	//static int testId=100;
	
	public static int generateId()
	{
		// int length=testTitle.length();
		  double id=Math.random()*10000;
		   int testId=(int)id;
		  
		  
		    return testId;
		   
		          
		  
	}
}
