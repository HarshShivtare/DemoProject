package Melaleuca.mobileAutomation.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOSHomePage {
	
	 AndroidDriver driver;
		WebDriverWait wait;
		public IOSHomePage(AndroidDriver driver) {
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		// Login Page Functionality Locator
		@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeOther[`name == 'Orders'`][2]")
		private WebElement btnOrders;

		
		public WebElement btnorders() throws InterruptedException {
			return btnOrders;
		}

}
