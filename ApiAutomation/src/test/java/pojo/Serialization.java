package pojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;
import java.util.ArrayList;

import io.restassured.RestAssured;
import payloadData.payload;

public class Serialization {
	public static void main(String[] args) throws IOException {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		AddPlace p = new AddPlace();
		p.setAccuracy(45);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shoe");
		myList.add("park");
		p.setTypes(myList);
		
		LocationSubclass loc = new LocationSubclass();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		p.setLocation(loc);
		
// maps/api/place/add/json represents as the resource
// Way 1 to send POST request
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(p).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).time(lessThan(2000L)).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
	
		System.out.println(response);
	}
}
