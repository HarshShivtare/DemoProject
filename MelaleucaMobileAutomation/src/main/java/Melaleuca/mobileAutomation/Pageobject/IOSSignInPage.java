package Melaleuca.mobileAutomation.Pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class IOSSignInPage {
	
	 AndroidDriver driver;
	WebDriverWait wait;
	public IOSSignInPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	// Login Page Functionality Locator
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`name == 'Allow'`]")
	private WebElement NotificationPopup;
	@iOSXCUITFindBy(className="XCUIElementTypeTextField")
	private WebElement Username;
	@iOSXCUITFindBy(iOSNsPredicate="value == 'Enter Password'")
	private WebElement password;
	@iOSXCUITFindBy(accessibility="SIGN IN")
	private WebElement btnSignIn;
	
	//Remaining Login Page Locator
	@iOSXCUITFindBy(accessibility="Invalid Username or Password.")
	private WebElement InvalidCredMessage;
	
	@iOSXCUITFindBy(xpath="//android.widget.ImageView")
	private WebElement melaleucaLobo;
	@iOSXCUITFindBy(className="android.widget.TextView")
	private WebElement Privacy_Terms;
	@iOSXCUITFindBy(accessibility="GET TO KNOW MELALEUCA")
	private WebElement textGetKnowMela;
	@AndroidFindBy(xpath="//android.view.View[@text='BECOME A MEMBER!']")
	private WebElement textBecomeADoctor;
	
	
	public void clickOnBtnAccess() throws InterruptedException {
		NotificationPopup.click();
		Thread.sleep(2000);
	}
	public WebElement username() {
		return Username;
	}
	public WebElement password() {
		return password;
	}
	public WebElement btnsignin() {
		return btnSignIn;
	}
	public void LoginPage() throws InterruptedException {
		//btnSignIn.click();	
		Username.sendKeys("MSATestUA25");
		password.sendKeys("Password1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		btnSignIn.click();	
	}
	public WebElement lobo() {
		return melaleucaLobo;
	}
	public WebElement privacy_termsText() {
		return Privacy_Terms;
	}
	public WebElement invalidcredentils() {
		return InvalidCredMessage;
	}
	public WebElement textGetKnowMela() {
		return textGetKnowMela;
	}
	public WebElement textBecomeADoctor() {
		return textBecomeADoctor;
	}

}
