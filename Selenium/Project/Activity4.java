package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4 {
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
	public void readCourseTitle() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("(//h2[@class='uagb-ifb-title'])[1]")));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='caption'])[1]")));
		String courseTitle = driver.findElement(By.xpath("(//*[@class='entry-title'])[2]")).getText().trim();
		try {
			Assert.assertEquals("Email Marketing Strategies", courseTitle);
			System.out.println("Course title Text: "+courseTitle);
			driver.quit();
		}catch(Exception e) {
			System.out.println("Course title Text Validation failed!! Reason: "+e.getMessage());
		}
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Activity 4 completed");
	}
}
