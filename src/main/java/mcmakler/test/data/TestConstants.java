package mcmakler.test.data;

import java.util.Random;


public class TestConstants {

	/**
	 * Test Data for tests
	 */
	
	public static final class TestData  {


		public static String WEB_APP_URL = "";
		
		public static String AD_API = "";
	
		public static String BROWSER = "";
		
		public static String CHROMEPATH = "";
		public static String CHROMEHEADLESS = "";
		
		public static String AD_NAME = getadname();

		public static String getadname() {
			return "AD" + Math.abs(new Random().nextInt());
		}
		
		public static String AD_STREET = getadstreet();

		public static String getadstreet() {
			return "Street" + Math.abs(new Random().nextInt());
		}
		
		public static String AD_ROOMS = String.valueOf(getadrooms());

		public static int getadrooms() {
			return Math.abs(new Random().nextInt(100));
		}
		
		public static String AD_PRICE = String.valueOf(getprice());

		public static int getprice() {
			return Math.abs(new Random().nextInt(100));
		}
		
	}
}
