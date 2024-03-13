package libraryApi;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payloadData.payload;
import payloadData.reusableMethods;

public class DynamicJson {
	
	@Test(dataProvider = "data")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
		.body(payload.addBook(isbn,aisle))		
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = reusableMethods.rawToJson(response);
		String id = js.getString("ID");
		System.out.println(id);
	}
	
	@DataProvider(name = "data")
	public  Object[][] getData() {
		return new Object [][] {{"qwere","123"},{"asdfs","456"},{"ghjkl","789"}};
	}

}
