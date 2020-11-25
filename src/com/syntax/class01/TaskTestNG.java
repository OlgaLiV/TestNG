package com.syntax.class01;

import org.testng.annotations.Test;

public class TaskTestNG {
	
	@Test
	public void sayHello() {
		System.out.println("Hello!!!");
	}
	
	@Test
	public void sayGoodMorning() {
		System.out.println("Good Morning!!!");
	}

	
	@Test(groups = "regression")
	public void sayHaveAGoodDay() {
		System.out.println("Have a Good Day!!!");
	}


}
