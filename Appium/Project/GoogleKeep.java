package project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

public class GoogleKeep {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "a1aa443e");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);

		URL serverURL = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<>(serverURL, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void testGoogleKeep() {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
		driver.findElementByAccessibilityId("New text note").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("editable_title")));
		driver.findElementById("editable_title").sendKeys("Appium Project");
		driver.findElementById("edit_note_text").sendKeys("FST-batch35");
		driver.findElementByAccessibilityId("Open navigation drawer").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("browse_note_interior_content")));
		String title = driver.findElementById("index_note_title").getText();
		String description = driver.findElementById("index_note_text_description").getText();
		Assert.assertEquals("Appium Project", title);
		Assert.assertEquals("FST-batch35", description);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
