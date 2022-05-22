package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity9_2 {
    public static void main(String[] args) {
    	WebDriver driver;
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");

        Select multiList = new Select(driver.findElement(By.id("multi-select")));
        
        if(multiList.isMultiple()) {

            multiList.selectByVisibleText("Javascript");
            System.out.println(driver.findElement(By.id("multi-value")).getText());
    
            multiList.selectByValue("node");
            System.out.println(driver.findElement(By.id("multi-value")).getText());

            for(int i=4; i<=6; i++) {
                multiList.selectByIndex(i);
            }
            System.out.println(driver.findElement(By.id("multi-value")).getText());
    
            multiList.deselectByValue("node");
            System.out.println(driver.findElement(By.id("multi-value")).getText());

            multiList.deselectByIndex(7);
            System.out.println(driver.findElement(By.id("multi-value")).getText());

            List<WebElement> selectedOptions = multiList.getAllSelectedOptions();

            for(WebElement selectedOption : selectedOptions) {
                System.out.println("Selected option: " + selectedOption.getText());
            }
            multiList.deselectAll();
            System.out.println(driver.findElement(By.id("multi-value")).getText());
        }        

        driver.close();
    }
}
