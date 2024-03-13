package Melaleuca.mobileAutomation.Pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidHomePage {

	AndroidDriver driver;
	WebDriverWait wait;
	public AndroidHomePage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Login Page Functionality Locator
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Supplements']")
	private WebElement supplementsText;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='QUICK EASY REORDERS']")
	private WebElement quickEasyReordersText;
	@AndroidFindBy(xpath="(//android.widget.TextView[@text=\"\"])[1]")
	private WebElement addCartBtn;
	//Remaining Login Page Locator
	@AndroidFindBy(xpath="//android.widget.TextView[@text='THIS MONTH’S SPECIALS']")
	private WebElement TextMonthsSpecials;
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"GC Control™ Shake: Peach Cobbler\"]")
	private WebElement productName;
	
	public WebElement textSupplements() {
		return supplementsText;
	}
	public WebElement textQuickEasyReorders() {
		return quickEasyReordersText;
	}
	public WebElement btnAddCart() {
		return addCartBtn;
	}
	public WebElement invalidcredentils() {
		return TextMonthsSpecials;
	}
	public WebElement productName() {
		return productName;
	}
	
}
