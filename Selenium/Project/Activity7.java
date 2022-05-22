package project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7 {
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
		driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
		List<WebElement> allCourses = driver.findElements(By.xpath("//*[@class='ld_course_grid col-sm-8 col-md-4 ']"));
		System.out.println("Number of courses: "+allCourses.size());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
