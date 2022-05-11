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

public class GoogleTask {
	AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceId", "a1aa443e");
		caps.setCapability("platformName", "android");
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		URL serverURL = new URL("http://localhost:4723/wd/hub");

		driver = new AndroidDriver<>(serverURL, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void testGoogleTask() {
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Create new task")));
		driver.findElementByAccessibilityId("Create new task").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
		driver.findElementById("add_task_done").click();
		driver.findElementByAccessibilityId("Create new task").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
		driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
		driver.findElementById("add_task_done").click();
		driver.findElementByAccessibilityId("Create new task").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
		driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
		driver.findElementById("add_task_done").click();
		List<String> ExpectedTasks = new ArrayList<String>();
		ExpectedTasks.add("Complete the second Activity Google Keep");
		ExpectedTasks.add("Complete Activity with Google Keep");
		ExpectedTasks.add("Complete Activity with Google Tasks");
		List<String> ActualTasks = new ArrayList<String>();
		List<MobileElement> tasks = driver.findElementsByAndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")");
		for(MobileElement task: tasks) {
			ActualTasks.add(task.getText().trim());
		}
		System.out.println("Expected List: "+ExpectedTasks);
		System.out.println("Actual List: "+ActualTasks);
		Assert.assertTrue(ExpectedTasks.equals(ActualTasks));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
