package oAuth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.GetCourseDetails;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class OAuthValidation {

	// Generating access token for the next request to hit
	public static void main(String[] args) throws IOException {
//		FileReader reads = new FileReader("C:\\Users\\Lenovo\\eclipse-workspace\\ApiAutomation\\credentials.properties");
//		Properties prop = new Properties();
//		prop.load(reads);
		RestAssured.baseURI = "https://rahulshettyacademy.com/oauthapi";

		String response = given().log().all()
				.formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").formParams("grant_type", "client_credentials")
				.formParams("scope", "trust").when().post("/oauth2/resourceOwner/token").asString();
			
		System.out.println(response);

		JsonPath jp = new JsonPath(response);
		String accessToken = jp.getString("access_token");
		System.out.println(accessToken);

		// Using the access token received from first endpoint to use it in another endpoint
		given().log().all().queryParam("access_token", accessToken)
		.when().get("/getCourseDetails").then().log().all().time(lessThan(2000L));
	}

}
