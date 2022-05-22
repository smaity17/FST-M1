package project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity8 {
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
	public void sentMessage() {
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h1"))));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h2[contains(text(),' Send us a message  ')]")));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='wpforms-form-8']"))));
		driver.findElement(By.id("wpforms-8-field_0")).sendKeys("Soumen Maity");
		driver.findElement(By.id("wpforms-8-field_1")).sendKeys("soumenmaity@gmail.com");
		driver.findElement(By.id("wpforms-8-field_3")).sendKeys("subject");
		driver.findElement(By.id("wpforms-8-field_2")).sendKeys("This is the mandatory message section");
		driver.findElement(By.id("wpforms-submit-8")).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='wpforms-confirmation-8']"))));
		String confirmationText = driver.findElement(By.xpath("//*[@id='wpforms-confirmation-8']/p")).getText().trim();
		System.out.println("Comfirmation Message: "+confirmationText);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
