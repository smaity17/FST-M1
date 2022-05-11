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

public class Activity3 {
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
	public void testAddition() {
		if(driver.findElementByClassName("android.widget.LinearLayout").isDisplayed()) {
			driver.findElementByAccessibilityId("clear").click();
		}
		driver.findElementById("btn_5_s").click();
		driver.findElementByAccessibilityId("plus").click();
		driver.findElementById("btn_2_s").click();
		driver.findElementByAccessibilityId("equals").click();
		String result = driver.findElementById("result").getText().trim();
		System.out.println("5 + 2 "+result);
		Assert.assertEquals(result, "= 7");
	}
	
	@Test
	public void testSubstraction() {
		if(driver.findElementByClassName("android.widget.LinearLayout").isDisplayed()) {
			driver.findElementByAccessibilityId("clear").click();
		}
		driver.findElementById("btn_5_s").click();
		driver.findElementByAccessibilityId("minus").click();
		driver.findElementById("btn_2_s").click();
		driver.findElementByAccessibilityId("equals").click();
		String result = driver.findElementById("result").getText().trim();
		System.out.println("5 - 2 "+result);
		Assert.assertEquals(result, "= 3");
		driver.findElementByAccessibilityId("clear").click();
	}
	
	@Test
	public void testMultiplication() {
		if(driver.findElementByClassName("android.widget.LinearLayout").isDisplayed()) {
			driver.findElementByAccessibilityId("clear").click();
		}
		driver.findElementById("btn_5_s").click();
		driver.findElementByAccessibilityId("multiply").click();
		driver.findElementById("btn_2_s").click();
		driver.findElementByAccessibilityId("equals").click();
		String result = driver.findElementById("result").getText().trim();
		System.out.println("5 x 2 "+result);
		Assert.assertEquals(result, "= 10");
		driver.findElementByAccessibilityId("clear").click();
	}
	
	@Test
	public void testDivision() {
		if(driver.findElementByClassName("android.widget.LinearLayout").isDisplayed()) {
			driver.findElementByAccessibilityId("clear").click();
		}
		driver.findElementById("btn_10_s").click();
		driver.findElementByAccessibilityId("divide").click();
		driver.findElementById("btn_2_s").click();
		driver.findElementByAccessibilityId("equals").click();
		String result = driver.findElementById("result").getText().trim();
		System.out.println("10 / 2 "+result);
		Assert.assertEquals(result, "= 5");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
