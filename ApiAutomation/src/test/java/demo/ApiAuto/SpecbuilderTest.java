package demo.ApiAuto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.io.IOException;
import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.LocationSubclass;

public class SpecbuilderTest {
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

		// RequestSpecBuilder is a class used to combine the methods & build them to
		// create an object of these methods
		// RequestSpecification,ResponseSpecification,Response are an interface 
		RequestSpecification reqbuild = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();

		ResponseSpecification respbuild = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON)
				.expectResponseTime(lessThan(2000L)).build();

		RequestSpecification request = given().spec(reqbuild).body(p);

		Response response = request.when().post("maps/api/place/add/json")
				.then().spec(respbuild).extract().response();

		System.out.println(response.asString());
	}
}
