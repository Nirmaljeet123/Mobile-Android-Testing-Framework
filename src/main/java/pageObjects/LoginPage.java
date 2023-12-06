package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basePackage.BaseClass;
import static utils.Utility.*;
import static utils.Waits.*;
import static actions.Actions.*;

public class LoginPage {

	@FindBy(id = "com.box.android:id/loginButton")
	public WebElement loginAppBtn;

	@FindBy(className = "android.widget.EditText")
	private WebElement emailIdTextField;

	@FindBy(className = "android.widget.Button")
	private WebElement nextBtn;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Not you?\"]/android.widget.TextView")
	private WebElement notYouText;

	@FindBy(className = "android.widget.EditText")
	private WebElement passwordTextField;

	@FindBy(className = "android.widget.Button")
	private WebElement loginBtn;
	
//	@AndroidFindBy(accessibility = "com.box.android:id/loginButton")
//	private WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	public void login(String emailId, String password) {
		clickOnElement(loginAppBtn);
		sendKeysOnElement(emailIdTextField, emailId);
		clickOnElement(nextBtn);
		waitForElementDisplayed(notYouText);
		sendKeysOnElement(passwordTextField, password);
		clickOnElement(loginBtn);
	}

	public static String getEmailId() {
		try {
			setExcelFile(SheetName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			return getCellData(1, 0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getPassword() {
		try {
			setExcelFile(SheetName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			return getCellData(1, 1);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getAppActivity() {
		try {
			setExcelFile(SheetName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			return getCellData(1, 2);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getAppPackage() {
		try {
			setExcelFile(SheetName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			return getCellData(1, 3);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getPlatformName() {
		try {
			setExcelFile(SheetName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			return getCellData(1, 4);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getAutomationName() {
		try {
			setExcelFile(SheetName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			return getCellData(1, 5);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean checkIfEmailTextFieldIsDispalyed() {
		//return checkIfDisplayed(emailIdTextField);
		return false;
	}
}
