package utils;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import basePackage.BaseClass;

public class Waits {
	
	static WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(40));
	
	public static void implicitWait() {
		BaseClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	public static void waitForElementClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementDisplayed(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementSelected(WebElement element) {
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	
}
