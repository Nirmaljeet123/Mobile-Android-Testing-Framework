package com.android;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import basePackage.BaseClass;
import io.qameta.allure.Description;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SettingsPage;
import utils.Listener;
import static pageObjects.LoginPage.*;

@Listeners({Listener.class})
public class LogoutTest extends BaseClass{
	
	@Test
	@Description("Test Case Description:Verify Logout Page")
	public void boxLogout() {
		
		new LoginPage().
			login(getEmailId(), getPassword());
		new HomePage().
			clickOnSettingsIcon();
		new SettingsPage().
			logout();
				
		//Assert.assertTrue(new LoginPage().checkIfEmailTextFieldIsDispalyed(), "User is not logged out from application");	
		
		Assert.assertTrue(new LoginPage().checkIfEmailTextFieldIsDispalyed(), "User is out from application");
	}
}