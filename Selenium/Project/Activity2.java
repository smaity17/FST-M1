package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		driver.manage().window().maximize();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h1"))));
	}
	
	@Test
	public void verifyHeading() {
		String headerText = driver.findElement(By.tagName("h1")).getText().trim();
		try {
			Assert.assertEquals("Learn from Industry Experts", headerText);
			System.out.println("Header Text: "+headerText);
			driver.quit();
		}catch(Exception e) {
			System.out.println("Title Validation failed!! Reason: "+e.getMessage());
		}
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Activity 2 completed");
	}
}
