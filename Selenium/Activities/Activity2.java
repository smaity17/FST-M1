package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net");
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
		System.out.println("Getting Text using ID locator: "+driver.findElement(By.id("about-link")).getText().trim());
		System.out.println("Getting Text using LinkText locator: "+driver.findElement(By.linkText("About Us")).getText().trim());
		System.out.println("Getting Text using CSS Selector locator: "+driver.findElement(By.cssSelector("a#about-link")).getText().trim());
		System.out.println("Getting Text using Class locator: "+driver.findElement(By.className("inverted")).getText().trim());
		driver.quit();
	}
}
