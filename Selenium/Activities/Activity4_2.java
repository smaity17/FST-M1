package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4_2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/selenium/simple-form");
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Soumen");
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Maity");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("smaity@abc.com");
		driver.findElement(By.xpath("//*[@id='number']")).sendKeys("9857164893");
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		Thread.sleep(2000);
		driver.quit();
	}
}
