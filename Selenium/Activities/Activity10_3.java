package activities;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity10_3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://training-support.net/selenium/drag-drop");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='arrows alternate icon']")));
		System.out.println("Title: "+driver.getTitle());
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();
		String drop1 = driver.findElement(By.xpath("//*[@id='droppable']/p")).getText().trim();
		Assert.assertEquals("Dropped!", drop1);
		action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("dropzone2"))).build().perform();
		String drop2 = driver.findElement(By.xpath("//*[@id='dropzone2']/p")).getText().trim();
		Assert.assertEquals("Dropped!", drop2);
		Thread.sleep(2000);
		driver.close();
	}

}
