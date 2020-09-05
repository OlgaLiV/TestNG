package com.syntax.class03;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataProvider {

	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
	}

	@Test(dataProvider = "getData", groups = "smoke")
	public void multiLogin(String username, String password, String name, String lastName) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		Assert.assertEquals(welcomeText, "Welcome " + name);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("screenshots/HRMS/"+name+".png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = {{"KokaL", "Kokaytvyn$12345", "Koka", "Liv"},
				{"MichaelRud", "MykhailolRud#12345", "Michael", "Rud"},
				{"OlgaL", "Lytvynenko1@", "Olga", "L"},
				{"AlexRud", "AlexRud#12345", "Alex", "Rud"},
				{"NadiiaL", "NadiiaL$12345", "Nadia", "Liv"}
				};
		return data;
	}

}
