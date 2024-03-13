package Melaleuca.mobileAutomation.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ShoppingCartPage {

	AndroidDriver driver;
	WebDriverWait wait;
	public ShoppingCartPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'PROCEED TO CHECKOUT')]")
	private WebElement btnProceedToCheckout;
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, 'CONTINUE TO CHECKOUT')]")
	private WebElement btnContinueToCheckout;
	
	
	
	public WebElement btnProceedToCheckout() {
		return btnProceedToCheckout;
	}
	public WebElement btnContinueToCheckout() {
		return btnContinueToCheckout;
	}
	
}
