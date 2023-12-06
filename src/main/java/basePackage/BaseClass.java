package basePackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
//import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
//import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import static utils.Utility.*;
import static io.appium.java_client.service.local.flags.GeneralServerFlag.BASEPATH;

public class BaseClass {
	
	public static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
	
	private final Logger LOG = LogManager.getLogger("BaseClass.class");
   // private AppiumDriverLocalService  service;
	public static AppiumDriverLocalService service;
	
    @BeforeSuite
    public void cleanResults() {
        cleanFiles();
    }
    
    @BeforeClass
	@Parameters({"deviceName","platformVersion","portNumber", "udid"})
	public void initiateDriver(String deviceName, String platformVersion, String portNumber, String udid) {
		
    	String apkPath = new File(System.getProperty("user.dir")+readPropertiesFile().getProperty("path")).toString();
    	
		startServer(portNumber);
		/*DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, readPropertiesFile().getProperty("platformName"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, readPropertiesFile().getProperty("automationName"));
		cap.setCapability(MobileCapabilityType.UDID, udid);
		cap.setCapability(MobileCapabilityType.APP, apkPath);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, readPropertiesFile().getProperty("appActivity"));
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, readPropertiesFile().getProperty("appPackage")); */
		UiAutomator2Options options = new UiAutomator2Options();
	    options.setPlatformName(readPropertiesFile().getProperty("platformName")); //optional
	    options.setAutomationName(readPropertiesFile().getProperty("automationName"));//optional
	    options.setDeviceName(deviceName);
	    options.setPlatformVersion(platformVersion);
	    options.setUdid(udid);
	    options.setApp(apkPath);
	    options.setAppActivity(readPropertiesFile().getProperty("appActivity"));
	    options.setAppPackage(readPropertiesFile().getProperty("appPackage")); 

	   // AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

		
		try {
			//setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"),cap));
			setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber),options));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void setDriver(AppiumDriver driver) {
		BaseClass.driver.set(driver);
	}
	
	public static AppiumDriver getDriver() {
		return driver.get();
	}	
	
	public static void startServer(String portNumber) {
		System.out.println("Service is starting at port : "+ portNumber);
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress ("127.0.0.1")
            .usingPort(Integer.parseInt(portNumber))
            .withAppiumJS (
                new File ("C:\\Users\\nikaur\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
            .usingDriverExecutable (new File ("C:\\Program Files\\nodejs\\node.exe"))
           //.withArgument(BASEPATH, "/wd/hub")
          // .withArgument(BASEPATH)
           // .withArgument(GeneralServerFlag.USE_PLUGINS,"element-wait")
            .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
            .withArgument(GeneralServerFlag.LOG_LEVEL, "error");

       service = AppiumDriverLocalService.buildService (builder);
       service.start();
        System.out.println("Service has been started with port number : "+ portNumber);
    }
		
	@AfterClass
	public void quitSession () throws InterruptedException {
        if (null != driver.get ()) {
            LOG.info ("Closing the driver...");
            getDriver().quit ();
            driver.remove();
            stopServer();
        }
    }
	
	@AfterTest
	public void stopServer() {
        service.stop();
    }
	
	/*public static void main(String []args)
	{
		
		BaseClass.startServer("4723");
	}  */

}
