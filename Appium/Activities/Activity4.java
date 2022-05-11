package activities;

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

public class Activity4 {
AndroidDriver<MobileElement> driver;
WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "a1aa443e");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", ".activities.PeopleActivity");
		caps.setCapability("noReset", true);
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver<>(serverURL, caps);
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void testContacts() {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageView[@content-desc=\"Add\"]")));
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Add\"]").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AndroidUIAutomator("text(\"Name\")")));
		driver.findElementByAndroidUIAutomator("text(\"Name\")").sendKeys("Aaditya Varma");
		driver.findElementByAndroidUIAutomator("text(\"Phone\")").sendKeys("9991482921");
		driver.findElementByAccessibilityId("OK").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("custom_title")));
		String name = driver.findElementById("custom_title").getText().trim();
		Assert.assertEquals(name, "Aaditya Varma");
		String phno = driver.findElementById("data").getText().trim();
		Assert.assertEquals(phno, "99914 82921");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
