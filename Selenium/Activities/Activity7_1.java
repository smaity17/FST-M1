package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7_1 {
    public static void main(String[] args) {
    	WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
        
        driver.get("https://training-support.net/selenium/dynamic-attributes");

        driver.findElement(By.xpath("//input[starts-with(@class, 'username')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[contains(@class, 'password')]")).sendKeys("password");

        driver.findElement(By.xpath("//button[contains(text(), 'Log in')]")).click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.close();

    }
}
