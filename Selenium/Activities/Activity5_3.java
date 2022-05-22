package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity5_3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/dynamic-controls");
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
		System.out.println("Text field is enabled: "+driver.findElement(By.xpath("//*[@id='input-text']")).isEnabled());
		driver.findElement(By.xpath("//*[@id='toggleInput']")).click();
		System.out.println("Text field is enabled: "+driver.findElement(By.xpath("//*[@id='input-text']")).isEnabled());		
		driver.quit();	
	}

}
