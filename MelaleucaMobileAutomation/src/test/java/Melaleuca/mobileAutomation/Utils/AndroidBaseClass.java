package Melaleuca.mobileAutomation.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseClass extends AppiumUtils{

	public  AndroidDriver driver;
	public AppiumDriverLocalService service;
	public UiAutomator2Options option;
	@BeforeClass
//	public void startMelaluaca() throws MalformedURLException, InterruptedException {
//		 service=new AppiumServiceBuilder().withAppiumJS
//				(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).
//				withIPAddress("127.0.0.1").usingPort(4723).build();
//		service.start();
//		Thread.sleep(2000);
//		
//		UiAutomator2Options option=new UiAutomator2Options();
//		option.setDeviceName("Pixel 6");
//		option.setApp("//Users//apple//eclipse-workspace//MelaleucaMobileAutomation//src//main//java//Melaleuca//mobileAutomation//Resources//mela-10-jan-UAT.apk");
//		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),option);
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));	
//	}
	public void startMelaluaca() throws IOException, InterruptedException {
		Properties property =new Properties();
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Melaleuca//mobileAutomation//Resources//data.properties");
		String ipaddress = System.getProperty("IpAddress")!=null ? System.getProperty("IpAddress"):property.getProperty("IpAddress");
		property.load(file);
		String port = property.getProperty("port");
		service=startServer(ipaddress,Integer.parseInt(port));
		option=new UiAutomator2Options();
		option.setDeviceName(property.getProperty("deviceName"));
		option.setApp(System.getProperty("user.dir")+"//src//main//java//Melaleuca//mobileAutomation//Resources//mela-10-jan-UAT.apk");
		driver=new AndroidDriver(service.getUrl(),option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void swapeElement(WebElement element,String direction) {
	 ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)element).
				getId(),
			    "direction", direction,
			    "percent", 0.1
		));
 }
	
	public WebElement scrollUptoElement(String xpath) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(
	            "new UiScrollable(new UiSelector()."
	                    + "scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + xpath + "\").instance(0))")));
	}
	
	

	// In your test case
	

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	

}
