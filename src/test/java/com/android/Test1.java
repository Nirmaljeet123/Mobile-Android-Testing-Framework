package com.android;

import static utils.Utility.readPropertiesFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.remote.MobileCapabilityType;
import utils.Listener;

@Listeners({Listener.class})
public class Test1 {
	
	@Test
	public void test() throws MalformedURLException {
		
		File f = new File("src\\main\\resources");
		File app = new File(f,"Box.apk");
		UiAutomator2Options options = new UiAutomator2Options();
	    options.setPlatformName(readPropertiesFile().getProperty("android")); //optional
	    options.setAutomationName(readPropertiesFile().getProperty("uiautomator2"));//optional
	    options.setDeviceName("Pixel34");
	    options.setPlatformVersion("14");
	   // options.setUdid(udid);
	    options.setApp(app.getAbsolutePath());
	    options.setAppActivity(readPropertiesFile().getProperty("appActivity"));
	    options.setAppPackage(readPropertiesFile().getProperty("appPackage")); 

		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TestEmulator2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.box.android.activities.login.SplashScreenActivity");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.box.android"); */
		
		//AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		
		WebElement loginAppBtn = driver.findElement(By.id("com.box.android:id/loginButton"));
		wait.until(ExpectedConditions.elementToBeClickable(loginAppBtn));
		loginAppBtn.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement emailIdTextField = driver.findElement(By.className("android.widget.EditText"));
		wait.until(ExpectedConditions.elementToBeClickable(emailIdTextField));
		emailIdTextField.sendKeys("sidhunirmal.sidhu@gmail.com");
		
		WebElement nextBtn = driver.findElement(By.className("android.widget.Button"));
		wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		nextBtn.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Not you?\"]/android.widget.TextView")));
		
		WebElement passwordTextField = driver.findElement(By.className("android.widget.EditText"));
		wait.until(ExpectedConditions.elementToBeClickable(passwordTextField));
		passwordTextField.sendKeys("Exercise@123");
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("allure-results\\screen.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		WebElement loginBtn = driver.findElement(By.className("android.widget.Button"));
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		WebElement settingsMenuIcon = driver.findElement(By.id("com.box.android:id/account_settings_menu_item"));
		wait.until(ExpectedConditions.visibilityOf(settingsMenuIcon));
		boolean status = settingsMenuIcon.isDisplayed();
		Assert.assertTrue(status, "Seetings menu not displayed");
		driver.quit();
		
	}
}
