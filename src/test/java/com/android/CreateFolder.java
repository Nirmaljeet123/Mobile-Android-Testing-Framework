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
public class CreateFolder extends BaseClass{

	@Test
	@Description("Test Case Description:Verify Create Folder")
	public void createFolder() {
		
		new LoginPage()
			.login(getEmailId(), getPassword());
		new HomePage()
			.waitForSettingsIconDisplayed()
			.clickOnPlusIcon()
			.clickOnNewFolderOption()			
			.createFolder("Folder2")
			.waitForSettingsIconDisplayed();
		
		Assert.assertTrue(new HomePage().checkIfNewFolderIsCreated(),"Folder is not created");
	}
}




// Using TouchAction class

//int screenWidth = getDriver().manage().window().getSize().getWidth();
//int screenHeight = getDriver().manage().window().getSize().getHeight();
//System.out.println(screenWidth);
//System.out.println(screenHeight);
//int x = (int) 88.47;		// (1274/1440)*100
//int y = (int) 91.66;		// (2658/2900)*100
//Thread.sleep(10000);
//TouchAction touchAction = new TouchAction((PerformsTouchActions) getDriver());
//touchAction.tap(PointOption.point((x*screenWidth)/100, (y*screenHeight)/100)).perform();

// 			OR
//TouchAction touchAction = new TouchAction((PerformsTouchActions) getDriver());
//touchAction.tap(PointOption.point(1274, 2658)).perform();

