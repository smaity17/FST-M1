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

public class Activity6 {
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
	public void navigatePage() {
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h1"))));
		String pageTitle = driver.getTitle().trim();
		Assert.assertEquals("My Account � Alchemy LMS", pageTitle);
		System.out.println("Navigated Page title Text: "+pageTitle);
		driver.findElement(By.xpath("//a[@href='#login']")).click();
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		driver.findElement(By.className("ld-profile-summary")).isDisplayed();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
