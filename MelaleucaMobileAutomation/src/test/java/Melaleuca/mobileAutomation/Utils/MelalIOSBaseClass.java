package Melaleuca.mobileAutomation.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MelalIOSBaseClass  {
	
	public  AndroidDriver driver;
	AppiumDriverLocalService service;
	@BeforeClass
	public void startMelaluaca() throws MalformedURLException, InterruptedException {
		 service=new AppiumServiceBuilder().withAppiumJS
				(new File("//usr//local//lib//node_modules//appium//build//lib//main.js")).
				withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		Thread.sleep(2000);
		
		XCUITestOptions option=new XCUITestOptions();
		option.clearSystemFiles();
		option.setDeviceName("iPhone 15");
		option.setApp("//Users//apple//Library//Developer//Xcode//DerivedData//MelaleucaApp-gzhzzhrveniiwsdoasjourstrycr//Build//Products//Debug-iphonesimulator//MelaleucaApp.app");
		option.setPlatformVersion("17.2");
		
		option.setWdaLaunchTimeout(Duration.ofSeconds(20));
		 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),option);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
	
	@AfterMethod
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
	

}
