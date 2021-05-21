package mcmakler.test.launch.pages;

import org.testng.annotations.BeforeClass;

import mcmakler.test.base.MainDriver;
import mcmakler.test.data.TestConstants.TestData;

public class LaunchAdvertisementsPage extends MainDriver {
	
	@BeforeClass
	public void actionLaunchLoginPage() {

		driver.get(TestData.WEB_APP_URL);

	}
}
