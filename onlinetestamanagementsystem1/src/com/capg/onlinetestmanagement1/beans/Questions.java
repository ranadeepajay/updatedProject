/*
 * package com.capg.onlinetestmanagement1.beans;
 * 
 * public class Questions {
 * 
 * private int questionId; private String questionName; private String answer;
 * private int qMarks; public Questions(int questionId, String questionName,
 * String answer, int qMarks) { super(); this.questionId = questionId;
 * this.questionName = questionName; this.answer = answer; this.qMarks = qMarks;
 * }
 * 
 * 
 * 
 * 
 * }
 */
package com.capg.onlinetestmanagement1.beans;

public class Questions {
   
	
	   private int questionId;
	   private  String questionTitle;
	   private  String correctAnwser;
	   private  int questionsMarks;
	   public Questions(int questionId, String questionTitle, String correctAnwser, int questionsMarks) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.correctAnwser = correctAnwser;
		this.questionsMarks = questionsMarks;
	}
	@Override
	public String toString() {
		return "Questions [questionId=" + questionId + ", questionTitle=" + questionTitle + ", questionsMarks=" + questionsMarks + "]";
	}
	   
	 
	 
	
	
}
