 package com.capg.onlinetestmanagement1.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capg.onlinetestmanagement1.beans.Questions;
import com.capg.onlinetestmanagement1.beans.ExamTest;
import com.capg.onlinetestmanagement1.beans.User;
import com.capg.onlinetestmanagement1.repository.MyRepository;

public class TestDao implements ITestDao {
      MyRepository reposit=new MyRepository();
      
      
	public ExamTest addTest(ExamTest test) {
		// TODO Auto-generated method stub
		return reposit.addTest(test);
	}

	public ExamTest updateTest(ExamTest test,String testTitle) {
		// TODO Auto-generated method stub
		
		return reposit.updateTest(test, testTitle);
	}

	public ExamTest deleteTest(int testId) {
		// TODO Auto-generated method stub
		return reposit.DeleteTest(testId);
	}

	public Set<Questions> assignTest(int userId, int testId) {
		// TODO Auto-generated method stub
		return MyRepository.assignTest(userId, testId);
	}
	 public Map<Integer,ExamTest>  getMap()
	 {
		 return MyRepository.getTestList();
	 }
	 
	 public  Map<Integer, HashSet<Integer>> getUserTestTakenList() {
			return MyRepository.getUserTestTakenList();
		}
}
















