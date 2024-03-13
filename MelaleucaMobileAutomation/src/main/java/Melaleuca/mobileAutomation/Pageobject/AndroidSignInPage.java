package Melaleuca.mobileAutomation.Pageobject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AndroidSignInPage {
	
	AndroidDriver driver;
	WebDriverWait wait;
	public AndroidSignInPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	// Login Page Functionality Locator
	@AndroidFindBy(xpath="//android.widget.EditText[@text='' or @resource-id='__VID__10__MelaId_lrq65sa4__usernameId']")
	private WebElement Username;
	@AndroidFindBy(xpath="//*[contains(@text,'Password')]")
	private WebElement password;
	@AndroidFindBy(xpath="//android.widget.Button[@text='SIGN IN']")
	private WebElement btnSignIn;
	//Remaining Login Page Locator
	@iOSXCUITFindBy(accessibility="Invalid Username or Password.")
	private WebElement InvalidCredMessage;
	
	
	public WebElement username() {
		return Username;
	}
	public WebElement password() {
		return password;
	}
	public WebElement btnsignin() {
		return btnSignIn;
	}
	public WebElement invalidcredentils() {
		return InvalidCredMessage;
	}
	
	
	//Login Method
	public void LoginPage(String username,String Password) throws InterruptedException {
		Username.sendKeys(username);
		password.sendKeys(Password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		btnSignIn.click();	
	}
	

}
