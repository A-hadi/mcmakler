package mcmakler.test.helpers;

import org.json.JSONArray;
import org.json.JSONObject;

import mcmakler.test.data.TestConstants.TestData;

public final class JSONHelper {

	public static final JSONObject jsonHelperFindAd(String response) {

		JSONObject jsonObj = null;

		JSONArray arr = new JSONArray(response);

		for (int i = 0; i < arr.length(); i++) {

			if (arr.getJSONObject(i).getString("name").contains(TestData.AD_NAME)) {
				jsonObj = arr.getJSONObject(i);
				break;
			}
		}

		return jsonObj;

	}

}
