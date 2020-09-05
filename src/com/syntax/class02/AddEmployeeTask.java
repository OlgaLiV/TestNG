package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddEmployeeTask {
	/*
	    TC 1: HRMS Add Employee: 

		Open chrome browser
		Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
		Login into the application
		Click on Add Employee
		Verify labels: Full Name, Employee Id, Photograph are displayed
		Provide Employee First and Last Name
		Add a picture to the profile
		Verify Employee has been added successfully
		Close the browser

	 */
	
	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	@Test
	public void verifyInfo() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		driver.findElement(By.xpath("//b[text() = 'PIM']")).click();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		WebElement actualFullName = driver.findElement(By.xpath("//label[text()= 'Full Name']"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(actualFullName.isDisplayed());
		
		
		WebElement actualEmpId = driver.findElement(By.xpath("//label[text() = 'Employee Id']"));
		softAssert.assertTrue(actualEmpId.isDisplayed());
		
		WebElement photo = driver.findElement(By.xpath("//label[text() = 'Photograph']"));
		softAssert.assertTrue(photo.isDisplayed());
		
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("Aaa");
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Bbb");
	
		WebElement saveBtn = driver.findElement(By.id("btnSave"));
		saveBtn.click();
		
		WebElement personal = driver.findElement(By.xpath("//input[@name= 'personal[txtEmployeeId]']"));
		softAssert.assertTrue(personal.isDisplayed());
		
		softAssert.assertAll();
		
		
		
		
		
		
		
		
		
		


	}
}
