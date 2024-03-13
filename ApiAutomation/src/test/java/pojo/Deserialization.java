package pojo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

public class Deserialization {

	// Generating access token for the next request to hit
	public static void main(String[] args) throws IOException {
		
		String[] courseTitles = {"Selenium Webdriver Java","Cypress","Protractor"};
		List<String> expList = Arrays.asList(courseTitles);

		RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi";

		String response = given().log().all()
				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
				.formParams("scope", "trust").when().post("/oauth2/resourceOwner/token").asString();

		System.out.println(response);

		JsonPath jp = new JsonPath(response);
		String accessToken = jp.getString("access_token");
		System.out.println(accessToken);

		// Using the access token received from first endpoint to use it in another
		// endpoint
		// Storing the response in the java object >> deserialization
		GetCourseDetails gcd = given().log().all().queryParam("access_token", accessToken).when()
				.get("/getCourseDetails").as(GetCourseDetails.class);

		System.out.println(gcd.getLinkedIn());
		System.out.println(gcd.getInstructor());
		System.out.println(gcd.getCourses().getWebAutomation().size());
		
		//When we want to use dynamic arrays we use arraylist as it allows to add element to it dynamically
		ArrayList<String> arr = new ArrayList<String>();
				
		for (int i = 0; i < gcd.getCourses().getWebAutomation().size(); i++) {
			String courseTitle = gcd.getCourses().getWebAutomation().get(i).getCourseTitle().toString();
			if (courseTitle.equalsIgnoreCase("Selenium Webdriver Java")) {
				System.out.println(gcd.getCourses().getWebAutomation().get(i).getPrice());
			}
			arr.add(courseTitle);
		}

		Assert.assertTrue(arr.equals(expList));
	}

}
