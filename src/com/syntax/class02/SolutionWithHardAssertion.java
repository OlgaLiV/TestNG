package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SolutionWithHardAssertion {
	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test()
	public void titleValidation() {
		String expectedTitle = "Human Management Systems";
		String actualTitle = driver.getTitle();// Human Management System
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("--- Code after assertion ---");
		System.out.println("--- End of test titleValidation ---");
	}
	
	@Test
	public void logoValidation() {
		WebElement element = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		Assert.assertTrue(element.isDisplayed());
	}
	
	//@Test
	public void loginPannelText() {
		String expectedText = "LOGIN Panels";
		WebElement loginForm = driver.findElement(By.id("logInPanelHeading"));
		Assert.assertEquals(loginForm.getText(), expectedText, "Text on the login panel did not matched");
		
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
