package mcmakler.test.helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import mcmakler.test.data.TestConstants.TestData;

public final class APIHelper {

	public static final String apiHelper() {
		RestAssured.baseURI = TestData.AD_API;
		
		Response profileInfo = RestAssured.given().urlEncodingEnabled(true)
				.when().get().then().assertThat().statusCode(200).extract().response();

		String result = profileInfo.asString();
		
		return result;

	}
}
