package eComProject;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;

import org.testng.Assert;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class ProductTest {

	public static void main(String[] args) {
		
		// Login
		RequestSpecification reqbuild = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();
		
		LoginRequest req = new LoginRequest();
		req.setUserEmail("shivtareharsh@gmail.com");
		req.setUserPassword("Harshal@4900");
		
		RequestSpecification reqLogin = given().spec(reqbuild).body(req);
		
		LoginResponse loginResponse =  reqLogin.when().post("/api/ecom/auth/login").then().extract().response().as(LoginResponse.class);
		
		String token = loginResponse.getToken();
		String userId = loginResponse.getUserId();
		
		System.out.println(token);
		System.out.println(userId);
		
		
		// Adding a product
		RequestSpecification addReqbuild = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).build();
		
		// relaxedHTTPSValidation is used to bypass any certification required for the request
		RequestSpecification addReq = given().relaxedHTTPSValidation().log().all().spec(addReqbuild).param("productName", "qwerty")
				.param("productAddedBy", userId).param("productCategory", "fashion")
				.param("productSubCategory", "shirts").param("productPrice", "1500")
				.param("productDescription", "Addias Originals")
				.param("productFor", "women")
				.multiPart("productImage", new File("F:\\harshal\\Testing\\profile-pics\\download.png"));
		
		String addResponse = addReq.when().post("/api/ecom/product/add-product")
		.then().log().all().extract().response().asString();
		
		JsonPath jp = new JsonPath(addResponse);
		String productId = jp.getString("productId");
		
		// Create Order
		RequestSpecification createOrderReqbuild = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		
		OrderDetails odetails = new OrderDetails();
		odetails.setCountry("India");
		odetails.setProductOrderedId(productId);
		
		ArrayList<OrderDetails> al = new ArrayList<OrderDetails>();
		al.add(odetails);
		
		OrdersRequest neworder = new OrdersRequest();
		neworder.setOrders(al);
		
		RequestSpecification orderspec = given().spec(createOrderReqbuild).body(neworder);
		
		String orderResp = orderspec.when().post("/api/ecom/order/create-order").then().extract().response().asString();
		System.out.println(orderResp);
		
		// Delete Product
		RequestSpecification deleteOrderReqbuild = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		
		RequestSpecification delReq = given().spec(deleteOrderReqbuild).pathParam("productId", productId);
		
		String delResp = delReq.when().delete("/api/ecom/product/delete-product/{productId}").then().extract().response().asString();
		System.out.println(delResp);
		JsonPath jp1 = new JsonPath(delResp);
		Assert.assertEquals("Product Deleted Successfully", jp1.getString("message")); 
	}
}
