package payloadData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class requests {

	public static String placeId;

	public String createPlace() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.addPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract()
				.response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response); // for parsing into Json
		String placeId = js.getString("place_id");
		requests.placeId = placeId;
		System.out.println("place_Id is : " + placeId);

		return placeId;
	}

	public static void updateRequest() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String newAddr = "90 Winter walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.updatePlace()).when().put("/maps/api/place/update/json").then().log().all().assertThat()
				.statusCode(200).body("msg", equalTo("Address successfully updated"));
	}

	public static void getRequest() {
		// requests p = new requests();
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String getResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId).when()
				.get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();
	}
}
