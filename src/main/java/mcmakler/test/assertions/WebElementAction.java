package mcmakler.test.assertions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import mcmakler.test.base.MainDriver;

public final class WebElementAction extends MainDriver {
	



	public static final boolean getElementisDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public static final void sendKeysElement (WebElement element, String input, String message) {
		
		
		log.info("enter text " + message);

		element.sendKeys(input);
		
		log.trace(message + " text entered");


	}
	
	public static final void waitForElement(WebElement element , String message) {
		
		log.info(message);
		waitobj.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static final void clickElement(WebElement element, String message) {
		
		log.info("click " + message);
		element.click();
		log.trace(message + " clicked");

	}
	
	public static final String getElementText (WebElement element) {
		return element.getText();
	}
}
