package com.capg.onlinetestmanagement1.ui;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capg.onlinetestmanagement1.beans.Questions;
import com.capg.onlinetestmanagement1.beans.ExamTest;
import com.capg.onlinetestmanagement1.exceptions.AlreadyTestIsPresent;
import com.capg.onlinetestmanagement1.services.ITestServices;
import com.capg.onlinetestmanagement1.services.TestServices;

public class DisplayOutput {

	public static void main(String args[]) {

		while (true) {
					ExamTest test = new ExamTest();
					
					System.out.println();
					System.out.println("Welcome to Online Test Management System");
		
					System.out.println("1. add test");
					System.out.println("2. update  test");
					System.out.println("3.delete test");
					System.out.println("4.assign test to user");
		
					Scanner scan = new Scanner(System.in);
					int choice=0;
					TestServices services = new TestServices();
					System.out.println();
					System.out.println();
					System.out.println("enter your choice");
				  
				  
					try {	
							choice = scan.nextInt();
				 		}
				    catch(InputMismatchException e)
				 		{
				    		System.err.println("Input should be in integers");
				 		}
					/*
					 * if(new Integer(choice).toString().matches("[1-9]*")==false) { continue; }
					 */
					scan.nextLine();
					
					switch (choice)
					{
							case 1:
										System.out.println("you wanted to add a new test");
										System.out.println();
										
										System.out.println("enter test name");
						
										String testTitle; // java certification test
						
										while (true) {
											testTitle = scan.nextLine();
											boolean b = services.validateTestTitle(testTitle);
											if (b == true)
												break;
										}
										 
										
										System.out.println();
										System.out.println("generate testId"); // testId generation
										int testId = Generators.generateId();
										System.out.println(testId);
										boolean isValidTestID=services.validateId(testId);
						
									//
										String start;
										DateTimeFormatter format = null;
										LocalDateTime startTime =null;
										
										System.out.println();
										format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
						
										while (true) {
											try { 
												// format =DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
												System.out.println("enter starting time of exam(DD-MM-YYYY HH:mm)");
											     start=scan.nextLine();
												startTime = LocalDateTime.parse(start, format); // Validation is required boolean
												 boolean b = services.validateTime(startTime);
												if (b == true)
													break;
											} catch (Exception e) {
												System.err.println(" date format is wrong please enter date format in dd-MM-yy HH:mm");
											}
						
										}
						
										System.out.println();
									//	System.out.println("enter ending time of exam(DD-MM-YYYY HH:mm");
										String end ; // validation is required
						
										LocalDateTime endTime = null;
										while (true) {
											
													try {
														System.out.println("enter ending time of exam(DD-MM-YYYY HH:mm)");
															end= scan.nextLine();
														endTime = LocalDateTime.parse(end, format);
														boolean b = services.validateTime(endTime);
												
														if (b == true)
														{
															 
															 
															break;
														}
													} 
													catch (Exception e) {
														
														System.err.println("date format is wrong please enter date in formate  dd-MM-yy hh:mm");
								
													}
													 
											}
										
										System.out.println();
						
									//	System.out.println("enter duration of the test");
						              long duration=0;
									  int count=10;
						              while(count>0)
						              { 
						            	  count=count-1;
						            	 // System.out.println("enter duration of the test");
						            	
						            	 try
						            	 {
						            		 System.out.println("enter duration of the test");
						            		  String stringDuration= scan.nextLine();
						            		 
						            		  if(stringDuration.matches("[0-9]*")==false)
						            		  {
						            			  throw new InputMismatchException();
						            		  }
						            		 duration = Long.parseLong(stringDuration);
						            		 boolean IsValidDuration=services.validateDuration(startTime, endTime, duration);
							            	 if(IsValidDuration==true)
							            	 {
							            		 System.out.println("valid");
							            		 break;
							            	 }
									  // end time-start
											// time>duration
										 	 
										 }
						            	 // validation is required
						            	 catch(InputMismatchException e)
						            	 {
						            		 System.out.println("minutes in numbers should be entered");
						            	 }
						            	 
						            	 
						            	 
						            	 
						              }
										System.out.println();
										System.out.println("enter set of questions");
										Set<Questions> testQuestions = QuestionList.getQuestions();
										/*
										 * Questions q1 = new Questions(1, "1+1", "2", 1); testQuestions.add(q1);
										 * Questions q2 = new Questions(2, "50-40", "10", 1); testQuestions.add(q2);
										 * Questions q3 = new Questions(3, "50*3", "150", 1); testQuestions.add(q3);
										 * Questions q4 = new Questions(4, "150/15", "10", 1); testQuestions.add(q4);
										 */
										System.err.println(testQuestions);
										//System.out.println();
										boolean bTestQuestion = (testQuestions.size() > 0) ? true : false;
										if (bTestQuestion == false) {
											System.out.println("questions cannot be empty");
											System.exit(0);
										}
						               
										System.out.println();
										System.out.println("enter total no of marks for the test");
						
										int testTotalMarks = testQuestions.size();
										
						        
									   System.out.println(testTotalMarks);
									   System.out.println();
										
										// if (bDuration && bID && bTestQuestion && bTitle) {
										test.setTestId(testId);
										test.setTestTitle(testTitle);
										//System.out.println(test.getTestTitle());
										test.setStartTime(startTime);
										test.setEndTime(endTime);
										test.setDuration(duration);
										test.setTestTotalMarks(testTotalMarks);
										test.setTestQuestions(testQuestions);
						
										// }
						
										//System.out.println(test);
						
										ExamTest test1 = services.addTest(test);
										if (test1 == null) {
											try {
												throw new AlreadyTestIsPresent("Test is present");
											} catch (AlreadyTestIsPresent e) {
												// TODO Auto-generated catch block
												//System.err.println("Test is already added");
											}
						
										} else {
											System.out.println("Test is added");
										}
						
										break;
						
							case 2:
									System.out.println("you choosen to update the test");
									testId=0;
									 
									
									Map<Integer, ExamTest> map = services.getMap();
									
									Set<Integer> testIds=map.keySet();
									System.out.println(map);
									
									  for (Integer key : testIds) {
									  
									        System.out.println(map.get(key));
									        System.out.println();
									  
									  }
				 
									if(map.size()==0)
									{
										System.err.println("there are no tests available  to update ");
										break;
									}
									//System.out.println("enter testId");
									 count=10;
									while(count>0)
									{   count=count-1;
										System.out.println("enter testId");
									    try
									    {
										testId = scan.nextInt();
									    }
									    catch(InputMismatchException e)
									    {  
									    	System.out.println("TestId should be in Integers");
									    }
										 
										boolean b= new Integer(testId).toString().matches("[0-9]*");
										if(b==false)
										{
											System.out.println("testId should be Integers");
										}
										else {
											break;
										}
									}
									
									//System.out.println(map);
									if (map.containsKey(testId) == false) {
										System.err.println("Invalid testId");
										break;
									} else {
										System.err.println("valid TestId");
									}
					
									ExamTest test2 = map.get(testId);
					
									System.out.println("enter name that to be changed as a TitleName");
									scan.nextLine();
									testTitle = scan.nextLine();
					
									test2 = services.updateTest(test2, testTitle);
									System.out.println(" test is updated ");
									System.out.println(test2);
					
								break;
							case 3:
				
									System.out.println("you choosen to delete the test");
								//	System.out.println("enter testid of test that you want to delete");
					
									map = services.getMap();
									if(map.size()==0)
									{
										System.err.println("there are no tests available to delelte");
									    	break;
									}
									Set<Integer> testIdList = map.keySet();
									for (Integer key : testIdList) {
										System.out.println(map.get(key));
									}
									System.out.println("enter testid of test that you want to delete");

									testId = scan.nextInt();
									if(map.containsKey(testId)==false)
									{
										System.err.println("Invalid TestId");
									}
										
									test = services.deleteTest(testId);
				
								break;
							case 4:
								    
								   System.out.println();
									System.out.println("You choosen to assign test to the user");
									
									 map=   services.getMap();
									 
									 if(map.size()==0)
									 { 
										 System.out.println("No tests area available");
										 break;
									 }
					           
									System.out.println("enter userId");
									int userId = scan.nextInt();
					
									System.out.println("enter testId");
					
									testId = scan.nextInt();
									if(map.containsKey(testId)==false)
									{
										System.out.println("there is no test available with that id");
										break;
									}
					
									Set<Questions> questionList = services.assignTest(userId, testId);
									
									if(questionList==null)
									{System.out.println("test cannot be taken twice");
									
									}
									
									else
									{
									System.out.println(questionList);
									}
					
									break;
				
							case 5: 
								System.exit(0);
								  break;
							default:
								  System.out.println("Invalid choice");
							     
								break;
							}
				
				}
				 
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		}
		

	}

