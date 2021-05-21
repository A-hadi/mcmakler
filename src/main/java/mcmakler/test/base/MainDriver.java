package mcmakler.test.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import mcmakler.test.data.TestConstants.TestData;

public class MainDriver extends BaseClass {
	public static WebDriver driver = null;
	public static WebDriverWait waitobj = null;
	public static WebDriverWait mobwaitobj = null;
	public static JavascriptExecutor executor = null;
	public static Actions action = null;
	
	public static Logger log = LogManager.getLogger();


	public static WebDriver setupSafariDriver() throws MalformedURLException {
		driver = new SafariDriver();
		driver.manage().window().maximize();

		waitobj = new WebDriverWait(driver, 50);
		executor = (JavascriptExecutor) driver;
		action = new Actions(driver);

		return driver;
	}

	public static WebDriver setupChromeDriver() throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver", TestData.CHROMEPATH);

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--no-sandbox");

		if (TestData.CHROMEHEADLESS.equals("true")) {
			options.addArguments("--headless");
		}

		options.addArguments("start-maximized");
		options.addArguments("disable-extensions");
		options.addArguments("disable-gpu");
		options.addArguments("window-size=1920,1080");

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		driver = new ChromeDriver(options);

		waitobj = new WebDriverWait(driver, 60);
		executor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		return driver;
	}

	public static WebDriver setupFirefoxDriver() throws MalformedURLException {

		System.setProperty("webdriver.gecko.driver", "/Users/abdelhadijaghbir/Documents/FF/geckodriver");

		driver = new FirefoxDriver();

		waitobj = new WebDriverWait(driver, 50);
		executor = (JavascriptExecutor) driver;
		action = new Actions(driver);

		return driver;
	}

	@BeforeClass
	public static WebDriver setupDriver() throws MalformedURLException {
		// TODO Auto-generated method stub

		System.out.println("------------- test Start -----------------");
		if (TestData.BROWSER.equals("safri")) {
			driver = setupSafariDriver();
		} else if (TestData.BROWSER.equals("chrome")) {
			driver = setupChromeDriver();
		} else if (TestData.BROWSER.equals("firefox")) {
			driver = setupFirefoxDriver();
		}

		return driver;

	}

	@AfterClass(alwaysRun = true)
	public void tearDownDriver() {

		TestData.AD_NAME = TestData.getadname();

		driver.close();
		driver.quit();

		System.out.println("------------------------ Test Complete  ------------------------");

	}

	public void getScreenshot(String[] path) throws IOException {

		File dir = new File("./screenshots");
		dir.mkdirs();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./screenshots/" + path[0] + "/" + path[1] + "screenshot.png"));

	}

}
