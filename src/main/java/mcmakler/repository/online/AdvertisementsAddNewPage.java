package mcmakler.repository.online;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvertisementsAddNewPage {
	WebDriver driver;

	public AdvertisementsAddNewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input [@name='name']")
	WebElement inputAdName;

	public WebElement inputAdName() {
		return inputAdName;
	}

	@FindBy(xpath = "//input [@name='street']")
	WebElement inputAdStreet;

	public WebElement inputAdStreet() {
		return inputAdStreet;
	}

	@FindBy(xpath = "//input [@name='rooms']")
	WebElement inputAdRooms;

	public WebElement inputAdRooms() {
		return inputAdRooms;
	}

	@FindBy(xpath = "//input [@name='price']")
	WebElement inputAdPrice;

	public WebElement inputAdPrice() {
		return inputAdPrice;
	}

	@FindBy(xpath = "//md-checkbox")
	WebElement checkBoxAdStatus;

	public WebElement checkBoxAdStatus() {
		return checkBoxAdStatus;
	}

	@FindBy(xpath = "//advertisement-form/following-sibling::div/button[1]")
	WebElement buttonAdCancel;

	public WebElement buttonAdCancel() {
		return buttonAdCancel;
	}

	@FindBy(xpath = "//advertisement-form/following-sibling::div/button[2]")
	WebElement buttonAdSave;

	public WebElement buttonAdSave() {
		return buttonAdSave;
	}

}
