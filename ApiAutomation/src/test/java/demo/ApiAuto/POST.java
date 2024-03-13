package demo.ApiAuto;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadData.payload;
import payloadData.reusableMethods;

public class POST {

	public static void main(String[] args) throws IOException {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
// maps/api/place/add/json represents as the resource
// Way 1 to send POST request
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.addPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract()
				.response().asString();

// Way 2 Using json file we can add the body to the request
// Initially we need to convert the json file into byte format & then the byte is converted to string

		 String data = new String
		 (Files.readAllBytes(Paths.get("C:\\Users\\Lenovo\\eclipse-workspace\\ApiAutomation\\src\\main\\java\\resources\\addPlace.json")));
				
		 String response2 = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(data)
				.when().post("maps/api/place/add/json")
				.then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract()
				.response().asString();

		System.out.println(response2);

		JsonPath js = reusableMethods.rawToJson(response2); // for parsing into Json
		String placeId = js.getString("place_id");

		System.out.println("place_Id is : " + placeId);


//////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		
		// 2.Update the place using put request

		
			String newAddr = "90 Winter walk, USA";
			given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").body(payload.updatedPlace(placeId))
			.when().put("/maps/api/place/update/json")
			.then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

			
////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
		// 3.Verify the updated place using get request

			
			String getResponse = given().log().all().queryParam("key","qaclick123").queryParam("place_id", placeId)
			.when().get("/maps/api/place/get/json")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
			JsonPath js1 = reusableMethods.rawToJson(getResponse);
			String actualAddr = js1.get("address");

			Assert.assertEquals(actualAddr, newAddr);
	}
}
