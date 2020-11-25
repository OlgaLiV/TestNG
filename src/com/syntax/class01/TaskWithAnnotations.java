package com.syntax.class01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskWithAnnotations {
	
	/*
	    Create class that will have:
		Before and After Class annotation
		Before and After Method annotation
		2 methods with Test annotation
	 */
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test(groups = "regression")
	public void test2() {
		System.out.println("Test 2");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("*******Before******");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("*******After******");
	}

}
