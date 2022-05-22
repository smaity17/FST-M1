package Activities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity3 {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setUp(){

        driver  = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.training-support.net/selenium/login-form");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public  void login(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement userName = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        userName.clear();
        userName.isEnabled();
        userName.sendKeys("admin");
        password.clear();
        password.isEnabled();
        password.sendKeys("password");
        loginBtn.isEnabled();
        loginBtn.click();

        String actualMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(actualMessage,"Welcome Back, admin");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}