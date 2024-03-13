package Melaleuca.mobileAutomation.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage {

	AndroidDriver driver;
	WebDriverWait wait;
	public CheckoutPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='GC Control™ Shake: Peach Cobbler']")
	private WebElement addedProductText;
	
	public WebElement addedProductText() {
		return addedProductText;
	}
	
}
