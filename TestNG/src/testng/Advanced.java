package testng;

import org.testng.annotations.Test;

public class Advanced {

	@Test(groups={"Smoke"})
	public void test11() {
		System.out.println("test11 executed");
	}
	
	@Test
	public void test12() {
		System.out.println("test12 executed");
	}
}
