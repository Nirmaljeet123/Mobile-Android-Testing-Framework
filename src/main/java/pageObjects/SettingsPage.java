package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basePackage.BaseClass;
import static actions.Actions.clickOnElement;

public class SettingsPage {

	@FindBy(id = "com.box.android:id/txtLogout")
	private WebElement logoutOption;

	@FindBy(id = "com.box.android:id/btnOK")
	private WebElement logoutBtn;

	public SettingsPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	public void logout() {
		clickOnElement(logoutOption);
		clickOnElement(logoutBtn);
	}
}
