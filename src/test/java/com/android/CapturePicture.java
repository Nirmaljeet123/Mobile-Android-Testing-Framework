package com.android;

import static pageObjects.LoginPage.getEmailId;
import static pageObjects.LoginPage.getPassword;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import basePackage.BaseClass;
import io.qameta.allure.Description;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Listener;

@Listeners({Listener.class})
public class CapturePicture extends BaseClass {

	@Test
	@Description("Test Case Description: Verify Capture Picture")
	public void capturePic() {
		new LoginPage()
			.login(getEmailId(), getPassword());
		new HomePage()
			.waitForSettingsIconDisplayed();
		int imagesCount = new HomePage()
			.totalImages();
		new HomePage()
			.clickOnPlusIcon()
			.clickOnCaptureMedia()
			.clickOnTakePhoto()
			.capturePhoto()
			.waitForSettingsIconDisplayed();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		int newImagesCount = new HomePage()
			.totalImages();
		
		Assert.assertEquals(imagesCount+1, newImagesCount, "Photo is not captured");
	}
}
