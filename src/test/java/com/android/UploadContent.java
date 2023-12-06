package com.android;

import static pageObjects.LoginPage.getEmailId;
import static pageObjects.LoginPage.getPassword;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import basePackage.BaseClass;
import io.qameta.allure.Description;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Listener;

@Listeners({Listener.class})
public class UploadContent extends BaseClass {

	@Test
	@Description("Test Case Description: Verify Upload Content")
	public void uploadConent() throws InterruptedException {

		new LoginPage()
			.login(getEmailId(), getPassword());
		new HomePage()
			.waitForSettingsIconDisplayed()
			.clickOnPlusIcon();
			//.clickOnUploadContent()
			//.uploadFile();

		Thread.sleep(5000);
	}
}
