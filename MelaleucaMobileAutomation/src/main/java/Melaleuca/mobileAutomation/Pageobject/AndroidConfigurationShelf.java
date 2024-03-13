package Melaleuca.mobileAutomation.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidConfigurationShelf {

	AndroidDriver driver;
	WebDriverWait wait;
	public AndroidConfigurationShelf(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//@AndroidFindBy(xpath="//android.widget.TextView[text='Your Choice' or@text='Your Choices']")
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Your Choice']")
	private WebElement yourChoiceText;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private WebElement btnAddToCart;
	//Remaining Login Page Locator
	@AndroidFindBy(xpath="//android.widget.TextView[@text='THIS MONTH’S SPECIALS']")
	private WebElement TextMonthsSpecials;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Choose: Peach Cobbler GC Control']")
	private WebElement soapName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").index(0)")
	private WebElement subTotalText;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='VIEW CART']")
	private WebElement btnViewToCart;
	
	public WebElement yourChoiceText() {
		return yourChoiceText;
	}
	public WebElement btnAddCart() {
		return btnAddToCart;
	}
	public WebElement invalidcredentils() {
		return TextMonthsSpecials;
	}
	public WebElement soapName() {
		return soapName;
	}
	public WebElement textSubTotal() {
		return subTotalText;
	}
	public WebElement btnViewToCart() {
		return btnViewToCart;
	}
}
