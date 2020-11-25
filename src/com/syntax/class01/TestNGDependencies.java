package com.syntax.class01;

import org.testng.annotations.Test;

public class TestNGDependencies {
	
	@Test(groups = "regression")
	public void login() {
		System.out.println("Test that logges in into the application and has login steps");
	}
	
	@Test(dependsOnMethods = "login")
	public void checkReport() {
		System.out.println("Test that check reports and has navigation to the report steps");
	}

}
