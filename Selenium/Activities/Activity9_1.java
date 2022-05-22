package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9_1 {
    public static void main(String[] args) {
    	WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");

        Select dropdown = new Select(driver.findElement(By.id("single-select")));

        dropdown.selectByVisibleText("Option 2");
        System.out.println(driver.findElement(By.id("single-value")).getText());

        dropdown.selectByIndex(3);
        System.out.println(driver.findElement(By.id("single-value")).getText());

        dropdown.selectByValue("4");
        System.out.println(driver.findElement(By.id("single-value")).getText());

        List<WebElement> options = dropdown.getOptions();

        for(WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }

        driver.close();
    }
}
