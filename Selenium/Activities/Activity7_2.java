package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity7_2 {
    public static void main(String[] args) {
    	WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-attributes");

        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("NewUser");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("Password");
        driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input")).sendKeys("Password");
        driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input")).sendKeys("real_email@xyz.com");

        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.close();

    }
}