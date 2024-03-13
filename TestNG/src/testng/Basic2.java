package testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Basic2 {

	@Test(groups = { "Regression" }, dependsOnMethods = { "test14" })
	public void test13() {
		System.out.println("test13 executed");
	}

	@Parameters({ "beforTest" ,"withinTest"})
	@Test(alwaysRun = true, enabled = true)
	public void test14(String param, String par) {
		System.out.println("test14 executed");
		System.out.println(param);
		System.out.println(par);
	}
	
	@Test(dataProvider="data")
	public void daata(String user, String passw) {
		System.out.println(user);
		System.out.println(passw);
	}

	@Test(alwaysRun = true, timeOut = 5000)
	public void test15() {
		System.out.println("test15 executed");
	}
	
	@Test
	public void fail() {
		System.out.println("test case failed");
		Assert.assertTrue(false);
	}
	
	@DataProvider(name="data")
	public Object[][] getData() {
		Object[][] data = new Object[3][2] ;
		data[0][0] = "user1" ;
		data[0][1] = "passw1";
		data[1][0] = "user2" ;
		data[1][1] = "passw2";
		data[2][0] = "user3" ;
		data[2][1] = "passw3";
		return data;
	}
}
