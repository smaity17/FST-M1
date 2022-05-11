package activities;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
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
	public void testBrowserPage() {
		driver.get("https://www.training-support.net/");
		String heading1 = driver.findElementByClassName("android.widget.TextView").getText().trim();
		System.out.println("Heading of the page: "+heading1);
		driver.findElementByAccessibilityId("About Us").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.widget.TextView")));
		String heading2 = driver.findElementByClassName("android.widget.TextView").getText().trim();
		System.out.println("Heading of the page: "+heading2);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
