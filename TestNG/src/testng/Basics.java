package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Basics {

	@BeforeSuite
	public void test1() {
		System.out.println("test1 before suite executed");
	}

	@AfterSuite
	public void test2() {
		System.out.println("test2 after suite executed");
	}

	@BeforeTest
	public void test3() {
		System.out.println("test3 before test executed");
	}

	@AfterTest
	public void test4() {
		System.out.println("test4 after test executed");
	}

	@BeforeMethod
	public void test5() {
		System.out.println("test5 before method executed");
	}

	@AfterMethod
	public void test6() {
		System.out.println("test6 after method executed");
	}

	@BeforeClass
	public void test7() {
		System.out.println("test7 before class executed");
	}
	
	@AfterClass
	public void test8() {
		System.out.println("test8 after class executed");
	}
	
	@Test(groups={"Smoke"})
	public void test09() {
		System.out.println("test09 executed");
	}
	
	@Test
	public void test10() {
		System.out.println("test10 executed");
	}
}
