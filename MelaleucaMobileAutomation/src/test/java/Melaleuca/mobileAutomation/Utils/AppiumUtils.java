package Melaleuca.mobileAutomation.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

	// To start Appium Server
public class AppiumUtils {
	
	public AppiumDriverLocalService service;
	public AppiumDriverLocalService startServer(String ipaddress, int portNumber) {
		 service=new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress(ipaddress).usingPort(portNumber).build();
		 service.start();
		return service;
	}
	
	// get data from loginCredentials. json data
	public List<HashMap<String, String>> getJsondata() throws IOException {
		String jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+
				"//src//test//java//Melaleuca//mobileAutomation//testData//logincredentials.json"), StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){
		});
		return data;
	}
	
	@DataProvider 
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsondata();
		return new Object[][] {{data.get(0)}};
	}
	
	public String getScreenShotPath(String testCaseName,AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+File.separator+"Screenshot"+File.separator+testCaseName+".png";
	//	FileUtils.copyFile(source, null)
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

}
