package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	AndroidDriver<MobileElement> driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "a1aa443e");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.miui.calculator");
		caps.setCapability("appActivity", ".cal.CalculatorActivity");
		caps.setCapability("noReset", true);
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver<>(serverURL, caps);
	}
	
	@Test
	public void testMultiplication() {
		driver.findElementById("btn_5_s").click();
		driver.findElementByAccessibilityId("multiply").click();
		driver.findElementById("btn_2_s").click();
		driver.findElementByAccessibilityId("equals").click();
		String result = driver.findElementById("result").getText().trim();
		Assert.assertEquals(result, "= 10");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
