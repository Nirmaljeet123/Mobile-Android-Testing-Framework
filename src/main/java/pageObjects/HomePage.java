package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static actions.FingerGestureActions.*;
import basePackage.BaseClass;
import io.qameta.allure.Step;

import static actions.Actions.*;
import static utils.Waits.waitForElementDisplayed;

import java.util.List;

public class HomePage {

	@FindBy(id = "com.box.android:id/account_settings_menu_item")
	private WebElement settingsMenuIcon;

	@FindBy(xpath = "//*[@class='android.widget.EditText' or @text='Folder Name']")
	private WebElement folderNameField;

	@FindBy(xpath = "//*[@text='CREATE']")
	private WebElement createBtn;

	@FindBy(xpath = "//*[@class='android.widget.TextView' and @text='Folder1']")
	private WebElement newFolderName;

	@FindBy(xpath = "//*[@text='Take Photo']")
	private WebElement takePhotoOption;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement allowPermission;
	
	@FindBy(id = "com.android.camera2:id/shutter_button")
	private WebElement captureBtn;
	
	@FindBy(id = "com.android.camera2:id/done_button")
	private WebElement doneBtn;
	
	@FindBy(xpath = "//*[contains(@text,'IMG')]")
	private List<WebElement> Images;
	
	@FindBy(xpath = "//*[contains(@text,'Select files to upload')]")
	private WebElement selectFileOption;
	
	@FindBy(xpath = "//*[contains(@text, 'devicefarm.pdf')]")
	private WebElement document;
     
	
	public HomePage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
   @Step("Verifying Setting Menu is displayed...")
	public boolean checkIfSettingsMenuIconIsDisplayed() {
		return checkIfDisplayed(settingsMenuIcon);
	}

	public void clickOnSettingsIcon() {
		clickOnElement(settingsMenuIcon);
	}

	public HomePage waitForSettingsIconDisplayed() {
		waitForElementDisplayed(settingsMenuIcon);
		return this;
	}

	public HomePage createFolder(String folderName) {
		waitForElementDisplayed(folderNameField);
		clickOnElement(folderNameField);
		sendKeysOnElement(folderNameField, folderName);
		waitForElementDisplayed(createBtn);
		clickOnElement(createBtn);
		return this;
	}

	public boolean checkIfNewFolderIsCreated() {
		return checkIfDisplayed(newFolderName);
	}
   @Step("Verifying Plus icon is clicked...")
	public HomePage clickOnPlusIcon() {
		clickUsingCoordinates(1274, 2658);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
   @Step("Verifying New folder Option is clicked..")
	public HomePage clickOnNewFolderOption() {
		clickUsingCoordinates(1027, 1697);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public HomePage clickOnCaptureMedia() {
		clickUsingCoordinates(1027, 2276);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public HomePage clickOnTakePhoto() {
		waitForElementDisplayed(takePhotoOption);
		clickOnElement(takePhotoOption);
		clickOnElement(allowPermission);
		return this;
	}
	
	public HomePage capturePhoto() {
		clickOnPlusIcon();
		clickOnCaptureMedia();
		waitForElementDisplayed(takePhotoOption);
		clickOnElement(takePhotoOption);
		waitForElementDisplayed(captureBtn);
		clickOnElement(captureBtn);
		waitForElementDisplayed(doneBtn);
		clickOnElement(doneBtn);
		return this;
	}
	
	public int totalImages() {
		System.out.println(Images.size());
		return Images.size();
	}
	
	public HomePage clickOnUploadContent() {
		clickUsingCoordinates(1027, 2077);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public HomePage uploadFile() {
		waitForElementDisplayed(selectFileOption);
		clickOnElement(selectFileOption);
		waitForElementDisplayed(document);
		clickOnElement(document);
		return this;
	}
}
