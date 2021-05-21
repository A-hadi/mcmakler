package mcmakler.test.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import mcmakler.repository.online.AdvertisementsPage;
import mcmakler.test.base.MainDriver;
import mcmakler.test.data.TestConstants.TestData;

public final class FindAdHelper extends MainDriver {

	public static final WebElement findAd(String adname) {
		AdvertisementsPage advertisements = new AdvertisementsPage(driver);

		WebElement adddata = null;

		for (int i = 0; i < advertisements.adsTable().findElements(By.tagName("tr")).size(); i++) {

			if (advertisements.adsTable().findElements(By.tagName("tr")).get(i).findElement(By.tagName("td")).getText()
					.contains(TestData.AD_NAME)) {
				adddata = advertisements.adsTable().findElements(By.tagName("tr")).get(i);
				break;
			}

		}
		return adddata;

	}
}
