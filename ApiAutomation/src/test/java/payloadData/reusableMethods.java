package payloadData;

import io.restassured.path.json.JsonPath;

public class reusableMethods {

	public static JsonPath rawToJson(String response) {
		JsonPath jpath = new JsonPath(response);
		return jpath;
	}
}
