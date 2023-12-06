package actions;

import org.openqa.selenium.WebElement;
import utils.Waits;

public class Actions {

	public static boolean checkIfDisplayed(WebElement element){
		Waits.waitForElementDisplayed(element);
        return element.isDisplayed();
    }

    public static boolean checkIfEnabled(WebElement element){
    	Waits.waitForElementDisplayed(element);
    	return element.isEnabled();
    }
    
    public static boolean checkIfSelected(WebElement element){
    	Waits.waitForElementDisplayed(element);
    	return element.isSelected();
    }
    
    public static String getText(WebElement element){
    	return element.getText();
    }
    
    public static void clickOnElement(WebElement element){
    	Waits.waitForElementClickable(element);
    	element.click();
    }
    
    public static void sendKeysOnElement(WebElement element, String text){
    	Waits.waitForElementClickable(element);
    	element.sendKeys(text);
    }
    
}
