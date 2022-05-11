package activities;

import java.net.MalformedURLException;
import java.net.URL;
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

public class Activity5 {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "a1aa443e");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.android.mms");
		caps.setCapability("appActivity", ".ui.MmsTabActivity");
		caps.setCapability("noReset", true);
		
		URL serverURL = new URL("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver<>(serverURL, caps);
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void testSendMessage() {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Compose")));
		driver.findElementByAccessibilityId("Compose").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.EditText[@content-desc=\"Recipient: \"]")));
		driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Recipient: \"]").sendKeys("Vijay");
		driver.findElementByAndroidUIAutomator("text(\"+91 62894 26717\")").click();
		driver.findElementById("embedded_text_editor").sendKeys("Sent via Appium");
		driver.findElementByAccessibilityId("Select SIM card").click();
		driver.findElementById("sim_button1").click();
		driver.findElementByAccessibilityId("Send message").click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("history")));
		List<MobileElement> messages = driver.findElementsByClassName("android.widget.TextView");
		boolean pass = false;
		for(MobileElement sms: messages) {
			if(sms.getText().trim().equalsIgnoreCase("Sent via Appium")) {
				pass = true;
				break;
			}
		}
		if(pass)
			Assert.assertTrue(true);
		else
			Assert.assertTrue(false);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
