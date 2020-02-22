package com.capg.onlinetestmanagement1.ui;

import java.util.HashSet;
import java.util.Set;

import com.capg.onlinetestmanagement1.beans.Questions;

public class QuestionList {

	    static    public Set<Questions> getQuestions()
	      {
	    	  Set<Questions> testQuestions=new HashSet<Questions>();
	    	  
	    	  Questions q1 = new Questions(1, "1+1", "2", 1);
				testQuestions.add(q1);
				Questions q2 = new Questions(2, "50-40", "10", 1);
				testQuestions.add(q2);
				Questions q3 = new Questions(3, "50*3", "150", 1);
				testQuestions.add(q3);
				Questions q4 = new Questions(4, "150/15", "10", 1);
			
				testQuestions.add(q4);
				
				return testQuestions;
	      }
	
}
