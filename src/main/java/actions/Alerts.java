package actions;

import basePackage.BaseClass;

public class Alerts {
	
	public void alertAccept() {
        BaseClass.getDriver().switchTo().alert().accept();
    }
	
	public void alertDismiss() {
		BaseClass.getDriver().switchTo().alert().dismiss();
    }
	
	public void alertSendKeys(String text) {
		BaseClass.getDriver().switchTo().alert().sendKeys(text);
    }

    public String alertGetText() {
        return BaseClass.getDriver().switchTo().alert().getText();
    }
    
    
}
