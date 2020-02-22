/*
 * package com.capg.onlinetestamanagementsystem1.beans;
 * 
 * public class Test {
 * 
 * }
 * 
 * package com.capg.onlinetestmanagement1.beans;
 * 
 * import java.time.LocalTime; import java.util.Set;
 * 
 * public class Test {
 * 
 * private int testId; private String testTitle; private long duration; private
 * Set<Questions> testQuestions; private int testTotalMarks; private LocalTime
 * startTime;
 * 
 * private LocalTime endTime;
 * 
 * }
 */
package com.capg.onlinetestmanagement1.beans;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

public class ExamTest {
	
	
	  private int testId;
	  private String testTitle;
	  private long  duration;
	  private Set<Questions> testQuestions;
	  private int testTotalMarks;
	  private LocalDateTime startTime;
	  
	  private LocalDateTime endTime;
	  
     public ExamTest()
     {
    	 
     }
	public ExamTest(int testId, String testTitle, long duration, Set<Questions> testQuestions, int testTotalMarks,
			LocalDateTime startTime, LocalDateTime endTime) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.duration = duration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Set<Questions> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(Set<Questions> testQuestions) {
		this.testQuestions = testQuestions;
	}

	public int getTestTotalMarks() {
		return testTotalMarks;
	}

	public void setTestTotalMarks(int testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", duration=" + duration + ", testQuestions="
				+ testQuestions + ", testTotalMarks=" + testTotalMarks + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}

	  //@Override
	 
	  
	  
		
}
