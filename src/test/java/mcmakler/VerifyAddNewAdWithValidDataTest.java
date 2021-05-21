package mcmakler;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import mcmakler.repository.online.AdvertisementsAddNewPage;
import mcmakler.repository.online.AdvertisementsPage;
import mcmakler.test.actios.WebElementAction;
import mcmakler.test.data.TestConstants.TestData;
import mcmakler.test.helpers.APIHelper;
import mcmakler.test.helpers.FindAdHelper;
import mcmakler.test.helpers.JSONHelper;
import mcmakler.test.launch.pages.LaunchAdvertisementsPage;

@Listeners(mcmakler.test.base.listeners.class)



public class VerifyAddNewAdWithValidDataTest extends LaunchAdvertisementsPage {

	@BeforeClass
	public void addNewAd() {

		log.info("START: " + VerifyAddNewAdWithValidDataTest.class.getName());

		AdvertisementsPage advertisements = new AdvertisementsPage(driver);

		WebElementAction.waitForElement(advertisements.addNewAdLink(), "add new ad link");

		WebElementAction.clickElement(advertisements.addNewAdLink(), "add new ad link");

		AdvertisementsAddNewPage add = new AdvertisementsAddNewPage(driver);

		WebElementAction.waitForElement(add.inputAdName(), "Ad Name input");

		WebElementAction.sendKeysElement(add.inputAdName(), TestData.AD_NAME, "Ad Name input");

		WebElementAction.sendKeysElement(add.inputAdStreet(), TestData.AD_STREET, "Ad Street input");

		WebElementAction.sendKeysElement(add.inputAdRooms(), TestData.AD_ROOMS, "Ad Rooms input");

		WebElementAction.sendKeysElement(add.inputAdPrice(), TestData.AD_PRICE, "Ad Price input");

		WebElementAction.clickElement(add.checkBoxAdStatus(), "ad Status checkbox");

		WebElementAction.clickElement(add.buttonAdSave(), "ad save button");

	}

	@Test
	public void verify001AddisSavedAndAppearOnList() {

		AdvertisementsPage advertisements = new AdvertisementsPage(driver);

		WebElementAction.waitForElement(advertisements.addNewAdLink(), "add new ad link");

		String textStr[] = FindAdHelper.findAd(TestData.AD_NAME).getText().split("\\s+");

		assertEquals(textStr[0], TestData.AD_NAME);
		log.trace("Ad name is displayed");

		assertEquals(textStr[1], TestData.AD_STREET);
		log.trace("Ad street is displayed");

		assertEquals(textStr[2], TestData.AD_ROOMS);
		log.trace("Ad rooms is displayed");

		assertEquals(textStr[3], TestData.AD_PRICE + ",00");
		log.trace("Ad price is displayed");

		assertEquals(textStr[4], "€");
		log.trace("Ad currency is displayed");

		assertEquals(textStr[5], "Active");
		log.trace("Ad active is displayed");
	}

	@Test
	public void verify002AddisSavedAgainstAPI() {

		JSONHelper.jsonHelperFindAd(APIHelper.apiHelper());

		JSONHelper.jsonHelperFindAd(APIHelper.apiHelper()).getString("name");

		assertEquals(JSONHelper.jsonHelperFindAd(APIHelper.apiHelper()).getString("name"), TestData.AD_NAME);
		log.trace("Ad name is saved");
		
		assertEquals(JSONHelper.jsonHelperFindAd(APIHelper.apiHelper()).getString("street"), TestData.AD_STREET);
		log.trace("Ad street is saved");
		
		assertEquals(String.valueOf(JSONHelper.jsonHelperFindAd(APIHelper.apiHelper()).getInt("rooms")), TestData.AD_ROOMS);
		log.trace("Ad rooms is saved");
		
		assertEquals(String.valueOf(JSONHelper.jsonHelperFindAd(APIHelper.apiHelper()).getInt("price")), TestData.AD_PRICE);
		log.trace("Ad price is saved");
		
		assertEquals(String.valueOf(JSONHelper.jsonHelperFindAd(APIHelper.apiHelper()).getBoolean("status")), "true");
		log.trace("Ad status is saved");

	}

}
