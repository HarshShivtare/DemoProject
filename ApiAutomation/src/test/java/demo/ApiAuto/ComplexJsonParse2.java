package demo.ApiAuto;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import payloadData.payload;

public class ComplexJsonParse2 {
	
	@Test
	public void getTotalAmount() {
		JsonPath jp = new JsonPath(payload.CoursePrice());
		
		int courseCount = jp.getInt("courses.size()");
		int sumAmount= 0;
		// Verify the amount of all courses with purchased amount
		for (int i = 0; i < courseCount; i++) {
		
			String title = jp.get("courses[" + i + "].title");
			int price = jp.getInt("courses[" + i + "].price");
			int copies = jp.getInt("courses[" + i + "].copies");
			int totalCoursePrice = price * copies;
			System.out.println(title + " : " + price + " * " + copies + " = " + totalCoursePrice);
			sumAmount = totalCoursePrice + sumAmount ;
			System.out.println("price of all courses : " + sumAmount);
		}
		int purchaseAmount = jp.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sumAmount, purchaseAmount);
		
	}
	

}
