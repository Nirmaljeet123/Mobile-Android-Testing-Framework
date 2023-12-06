package com.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumBy.ByAndroidUIAutomator;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class Test2 {
		
		/*@Test
		public void test() throws MalformedURLException, Throwable {
			
			File f = new File("src\\main\\resources");
			File app = new File(f,"box.apk");
			
			UiAutomator2Options options = new UiAutomator2Options();
		    options.setPlatformName("Android"); //optional
		    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
		    options.setDeviceName("Pixel33");
		    options.setApp(app.getAbsolutePath());
		    options.setAppActivity("com.box.android.activities.login.SplashScreenActivity");
		    options.setAppPackage("com.box.android");

		    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		   Thread.sleep(5000);
		    WebElement loginAppBtn = driver.findElement(By.id("com.box.android:id/loginButton"));
		    doubleTap(driver,loginAppBtn);
		}
		  /* loginAppBtn.click();
		    
		   /// driver.findElement(By.className("android.widget.EditText")).sendKeys("sidhunirmal.sidhu@gmail.com");
		   // Thread.sleep(5000);
		   // WebElement emailIdTextField = driver.findElement(By.className("android.widget.EditText"));
			//new WebDriverWait(driver,Duration.ofSeconds(10)).until(e->e.findElement(By.className("android.widget.EditText"))).sendKeys("sidhunirmal.sidhu@gmail.com");
					//ExpectedConditions.elementToBeClickable(emailIdTextField));
			//emailIdTextField.sendKeys("sidhunirmal.sidhu@gmail.com");
			
			///WebElement nextBtn = driver.findElement(By.className("android.widget.Button"));
		//	wait.until(ExpectedConditions.elementToBeClickable(nextBtn));
		///	nextBtn.click();

           
			//Thread.sleep(5000);
			///WebElement passwordTextField = driver.findElement(By.className("android.widget.EditText"));

		/*	passwordTextField.sendKeys("Exercise@123");
			WebElement loginBtn = driver.findElement(By.className("android.widget.Button"));
			//wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
			loginBtn.click(); 

} 
	
	@Test
	  void doubleTap() throws MalformedURLException, InterruptedException {
	    UiAutomator2Options options = new UiAutomator2Options();
	    options.setPlatformName("Android"); //optional
	    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
	    options.setDeviceName("android emulator");
	    options.setApp(System.getProperty("user.dir") + "/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");

	    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	    WebElement openMenu = driver.findElement(AppiumBy.accessibilityId("open menu"));
	    doubleTap(driver, openMenu);
	    //Assertion
	  } */
	
	/* @Test
	  void longPress() throws MalformedURLException {
	    UiAutomator2Options options = new UiAutomator2Options();
	    options.setPlatformName("Android"); //optional
	    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
	    options.setDeviceName("Android Emulator");
	    options.setApp("C:\\Users\\nikaur\\Downloads\\ApiDemos-debug.apk");

	    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

	    driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
	    driver.findElement(AppiumBy.xpath(".//*[@text='Expandable Lists']")).click();
	    driver.findElement(AppiumBy.xpath(".//*[@text='1. Custom Adapter']")).click();
	    WebElement element = driver.findElement(AppiumBy.xpath(".//*[@text='People Names']"));
	    longPress(driver,element);
	   // new Actions(driver).clickAndHold(element).perform();
	    //Assertion
	  }
	 */
	 /*@Test
	  void zoom() throws MalformedURLException, InterruptedException {
	    UiAutomator2Options options = new UiAutomator2Options();
	    options.setPlatformName("Android"); //optional
	    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
	    options.setDeviceName("Pixel33");
	    options.setApp("C:\\Users\\nikaur\\Downloads\\Android-MyDemoAppRN.1.3.0.build-244.apk");

	    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	    driver.findElement(AppiumBy.accessibilityId("open menu")).click();
	    driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item drawing\"]"))
	        .click();
	    WebElement element = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"drawing screen\"]"));
	    
	    zoom(driver,element);
	 }*/
	
	@Test
	  void dragAndDrop() throws MalformedURLException {
		 UiAutomator2Options options = new UiAutomator2Options();
		    options.setPlatformName("Android"); //optional
		    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
		    options.setDeviceName("Pixel32");
		    options.setApp("C:\\Users\\nikaur\\Downloads\\ApiDemos-debug.apk");

		    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		    driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
		    driver.findElement(AppiumBy.xpath(".//*[@text='Drag and Drop']")).click();
		    
		    WebElement source=driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		    WebElement target= driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));
		    dragAndDrop(driver, source, target);
		    
	}
	private void dragAndDrop(AndroidDriver driver, WebElement source,WebElement target)
	{
		    Point sourceElementCenter=getCenterOfElement(source.getLocation(),source.getSize());
		    Point targetElementCenter= getCenterOfElement(target.getLocation(),target.getSize());
		    PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
		    Sequence sequence=new Sequence(finger1,1)
		    		.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), sourceElementCenter))
		    		.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		    		.addAction(new Pause(finger1,Duration.ofMillis(500)))
		    		.addAction(finger1.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(), targetElementCenter))
		    		.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		    driver.perform(Collections.singletonList(sequence));
	}

	/* @Test
	  void swipeOrScroll() throws MalformedURLException {
		 UiAutomator2Options options = new UiAutomator2Options();
		    options.setPlatformName("Android"); //optional
		    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
		    options.setDeviceName("Android Emulator");
		    options.setApp("C:\\Users\\nikaur\\Downloads\\ApiDemos-debug.apk");

		    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);


	 driver.findElement(AppiumBy.xpath(".//*[@text='Views']")).click();
	  swipeOrScroll(driver);
		    
	  
	  } */
	 
	 
	    
	 private void swipeOrScroll(AndroidDriver driver)
	 {
		 Dimension size = driver.manage().window().getSize();
		    int startX = size.getWidth() / 2;
		    int startY = size.getHeight() / 2;
		    int endX = startX;
		    int endY = (int) (size.getHeight() * 0.25);
		    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(200)))
		        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    driver.perform(Collections.singletonList(sequence));
		 
	 }
	    
	    private void zoom(AndroidDriver driver, WebElement element)
	    {
	    Point centerOfElement = getCenterOfElement(element.getLocation(), element.getSize());

	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(200)))
	        .addAction(finger1.createPointerMove(Duration.ofMillis(200),
	                                             PointerInput.Origin.viewport(), centerOfElement.getX() + 100,
	                                             centerOfElement.getY() - 100))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    Sequence sequence2 = new Sequence(finger2, 1)
	        .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
	        .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger2, Duration.ofMillis(200)))
	        .addAction(finger2.createPointerMove(Duration.ofMillis(200),
	                                             PointerInput.Origin.viewport(), centerOfElement.getX() - 100,
	                                             centerOfElement.getY() + 100))
	        .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Arrays.asList(sequence, sequence2));

	    //Assertion
	  }
	

	 private void longPress(AndroidDriver driver, WebElement element) {
		    Point location = element.getLocation();
		    Dimension size = element.getSize();

		    Point centerOfElement = getCenterOfElement(location, size);

		    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofSeconds(2)))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    driver.perform(Collections.singletonList(sequence));
		  }
	
	private void doubleTap(AndroidDriver driver, WebElement element) {
	    Point location = element.getLocation();
	    Dimension size = element.getSize();

	    Point centerOfElement = getCenterOfElement(location, size);

	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(100)))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(100)))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(100)))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    driver.perform(Collections.singletonList(sequence));
	  }

		
		private void tap(AndroidDriver driver, WebElement element) {
		    Point location = element.getLocation();
		    Dimension size = element.getSize();

		    Point centerOfElement = getCenterOfElement(location, size);

		    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(200)))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    driver.perform(Collections.singletonList(sequence));
		  }

		  private Point getCenterOfElement(Point location, Dimension size) {
		    return new Point(location.getX() + size.getWidth() / 2,
		                     location.getY() + size.getHeight() / 2);
		  }
}
