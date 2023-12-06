package com.android;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import basePackage.BaseClass;
import io.qameta.allure.Description;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utils.Listener;
import static pageObjects.LoginPage.*;

@Listeners({Listener.class})
public class LoginTest extends BaseClass{
	
	@Test
	@Description("Test case description: Verify Login Page")
	public void boxLogin() {
		
		new LoginPage().
			login(getEmailId(), getPassword());
		
		Assert.assertTrue(new HomePage().checkIfSettingsMenuIconIsDisplayed(), "Settings Menu Icon is not displayed");
	}
}
