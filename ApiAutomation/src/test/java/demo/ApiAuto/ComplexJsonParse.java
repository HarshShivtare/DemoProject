package demo.ApiAuto;

import io.restassured.path.json.JsonPath;
import payloadData.payload;

public class ComplexJsonParse {

	public static void main(String[] args) {
		JsonPath jp = new JsonPath(payload.CoursePrice());

		// Print the no. of courses present in API
		int courseCount = jp.getInt("courses.size()");
		System.out.println(courseCount);

		// Print the purchase amount
		int purchaseAmount = jp.getInt("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);

		// Print the first title from array of courses
		String firstTitle = jp.get("courses[0].title");
		System.out.println(firstTitle);

		// Print all courses and their prices
		for (int i = 0; i < courseCount; i++) {
			String title = jp.get("courses[" + i + "].title");
			int price = jp.getInt("courses[" + i + "].price");
			int copies = jp.getInt("courses[" + i + "].copies");
			int totalCoursePrice = price * copies;
			System.out.println(title + " : " + price + " * " + copies + " = " + totalCoursePrice);
		}

		// Getting price of a particular course
		for (int i = 0; i < courseCount; i++) {
			String title = jp.get("courses[" + i + "].title");
			if (title.equalsIgnoreCase("RPA")) {
				int copies = jp.getInt("courses[" + i + "].copies");
				System.out.println("Getting price of a particular course");
				System.out.println(title + " no. of copies sold : " + copies);
				break;
			}
		}
	}
}
