package com.capg.onlinetestmanagement1.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capg.onlinetestmanagement1.beans.ExamTest;
import com.capg.onlinetestmanagement1.beans.Questions;
import com.capg.onlinetestmanagement1.services.ITestServices;
import com.capg.onlinetestmanagement1.services.TestServices;

class TestServicesTest {
	/*
	 * @BeforeAll public static void getAll() {
	 * 
	 * 
	 * 
	 * Questions q1=new Questions(1,"1+1","2", 1); Set<Questions> qlist=new
	 * HashSet<Questions>(); qlist.add(q1);
	 * 
	 * Scanner in=new Scanner(System.in); String start="11-11-2014 10:00";
	 * DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	 * LocalDateTime startTime =LocalDateTime.parse(start,format);
	 * 
	 * String end="11-11-2014 12:00"; format =
	 * DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"); LocalDateTime endTime
	 * =LocalDateTime.parse(end,format);
	 * 
	 * ExamTest obj=new ExamTest(101, "java", 120, qlist, 1, startTime, endTime);
	 * 
	 * // ITestServices test=new TestServices();
	 * 
	 * 
	 * }
	 */ TestServices test = new TestServices();

	/*
	 * @Test void testAddTest() {
	 * 
	 * assertEquals(obj, );
	 * 
	 * }
	 */
	/*
	 * @Test void testUpdateTest() { fail("Not yet implemented"); }
	 * 
	 * @Test void testDeleteTest() { fail("Not yet implemented"); }
	 * 
	 * @Test void testAssignTest() { fail("Not yet implemented"); }
	 */
	@Test
	void testValidateTestTitle() {
		boolean flag = true;
		assertEquals(flag, test.validateTestTitle("java"));
		assertEquals(flag,test.validateTestTitle("ajay"));
	}
	
	@Test
	void testValidateTestId()
	{
		 boolean flag=true;
		 assertEquals(flag,test.validateId(101));
	}

}
