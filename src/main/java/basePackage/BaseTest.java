package basePackage;

import static utils.Utility.readPropertiesFile;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
//import io.appium.java_client.remote.MobileCapabilityType;
import utils.Utility;

public class BaseTest {

	private static AndroidDriver androidDriver = null;

	@BeforeSuite
	public void cleanResults() {
		Utility.cleanFiles();
	}

	@BeforeClass
	public void setup() {
		initDriver();
	}

	public void initDriver() {
		String apkPath = new File(System.getProperty("user.dir") + readPropertiesFile().getProperty("path")).toString();
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "TestEmulator2");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, apkPath);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.box.android.activities.login.SplashScreenActivity");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.box.android"); */
		UiAutomator2Options options = new UiAutomator2Options();
	    options.setPlatformName("android");
	    options.setAutomationName("uiautomator2");
	    options.setDeviceName("Pixel33");
	    options.setApp(apkPath);
	    options.setAppActivity("com.box.android.activities.login.SplashScreenActivity");
	    options.setAppPackage("com.box.android"); 


		try {
			androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			//androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static AndroidDriver getDriver() {
		return androidDriver;
	}

	@AfterClass
	public void tearDown() {
		getDriver().quit();
	}
}
