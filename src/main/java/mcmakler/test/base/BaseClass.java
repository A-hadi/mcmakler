package mcmakler.test.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import mcmakler.test.data.TestConstants.TestData;

public class BaseClass {
	public static Properties prop;

	@BeforeSuite
	public static  void setupEnvironment () throws IOException {
	prop = new Properties();
		
		String env = "STG";
		//String env = System.getProperty("test.env");

		System.out.println(env);

		InputStream input = null;

		if (env.equals("STG")) {
			System.out.println("Staging");
			input = new FileInputStream("./envvariables/staging.properties");

		} else {
			System.out.println("No Enviroment selected");
		}
		prop.load(input);

		TestData.BROWSER = prop.getProperty("browser");
		System.out.println(TestData.BROWSER);
		
		TestData.WEB_APP_URL = prop.getProperty("web-app-url");
		System.out.println(TestData.WEB_APP_URL);
		
		TestData.AD_API = prop.getProperty("ad-api");
		System.out.println(TestData.AD_API);
		
		TestData.CHROMEPATH = prop.getProperty("chrome-path");
		System.out.println(TestData.CHROMEPATH);
		
		TestData.CHROMEHEADLESS = prop.getProperty("chrome-headless");
		System.out.println(TestData.CHROMEHEADLESS);
	}
	
	
	@AfterSuite
	public void calledAfterTestSuite() {

		System.out.println("----------------- Suite Complete -----------------");


	}


}
