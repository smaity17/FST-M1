package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4_1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
		System.out.println("Getting Text using XPATH locator: "+driver.findElement(By.xpath("//*[@id='about-link']")).getText().trim());
		driver.quit();

	}

}
