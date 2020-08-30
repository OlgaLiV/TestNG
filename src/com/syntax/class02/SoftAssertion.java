package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
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
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("gigigigi");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		String expectedErrorMessage1 = "Invalid credential";
		String actualErrorMessage = driver.findElement(By.id("spanMessage")).getText();
		
		SoftAssert softAssertion = new SoftAssert();
		// 1st validation
		softAssertion.assertEquals(actualErrorMessage, expectedErrorMessage1);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		String expectedErrorMessage2 = "Password cannot be";
		actualErrorMessage = driver.findElement(By.id("spanMessage")).getText();
		// 2nd validation
		softAssertion.assertEquals(actualErrorMessage, expectedErrorMessage2);
		
		System.out.println("I am a text after assertion");
		System.out.println("--- This is the end of the test ---");
		softAssertion.assertAll();
		
		
		
		
		
		
	}

}
