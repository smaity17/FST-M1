package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity4_3 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("Title of the page: "+title);
		System.out.println("Third Header Text is: "+driver.findElement(By.xpath("//*[@id='third-header']")).getText());
		System.out.println("Fifth Header Text is: "+driver.findElement(By.xpath("//h5")).getText());
		System.out.println("Fifth Header Text is color property is: "+driver.findElement(By.xpath("//h5")).getCssValue("color"));
        System.out.println("Violet button's classes are: "+driver.findElement(By.xpath("//button[contains(text(), 'Violet')]")).getAttribute("class"));
        System.out.println("Grey button: "+driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]")).getText());
		Thread.sleep(2000);
		driver.quit();
	}
}
