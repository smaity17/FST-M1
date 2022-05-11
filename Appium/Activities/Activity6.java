package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
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
	public void testScroll() {
		driver.get("https://www.training-support.net/selenium/lazy-loading");
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.Image")));
		List<MobileElement> imagesBeforeScroll = driver.findElementsByClassName("android.widget.Image");
		System.out.println("Total images in the view before scrolling : " + imagesBeforeScroll.size());
		driver.findElement(
				MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollIntoView(text(\"helen\"))"));
		List<MobileElement> imagesAfterScroll = driver.findElementsByClassName("android.widget.Image");
		System.out.println("Total images in the view after scrolling : " + imagesAfterScroll.size());
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
