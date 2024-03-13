package Melaleuca.mobileAutomation.Utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class MelalAppiumACtions extends MelalIOSBaseClass{
	
	public WebElement scrollUptoElement(WebElement elementText) {
	     return driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())"
	            + ".scrollIntoView(new UiSelector().elementText);"));
	}

}
