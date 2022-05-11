package project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BrowserApp {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "a1aa443e");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);

		URL serverURL = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<>(serverURL, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void testBrowserApp() throws InterruptedException {
		driver.get("https://www.training-support.net/selenium");
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Selenium\")")));
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward(3)"));
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("text(\"To-Do List\")")));
		driver.findElementByAndroidUIAutomator("text(\"To-Do List\")").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Add tasks to list");
		driver.findElementByAndroidUIAutomator("text(\"Add Task\")").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Get number of tasks");
		driver.findElementByAndroidUIAutomator("text(\"Add Task\")").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Clear the list");
		driver.findElementByAndroidUIAutomator("text(\"Add Task\")").click();
		Assert.assertTrue(driver.findElementByAndroidUIAutomator("text(\"Add tasks to list\")").isDisplayed());
		Assert.assertTrue(driver.findElementByAndroidUIAutomator("text(\"Get number of tasks\")").isDisplayed());
		Assert.assertTrue(driver.findElementByAndroidUIAutomator("text(\"Clear the list\")").isDisplayed());
		driver.findElementByAndroidUIAutomator("text(\"Add tasks to list\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Get number of tasks\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Clear the list\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Clear List\")").click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
