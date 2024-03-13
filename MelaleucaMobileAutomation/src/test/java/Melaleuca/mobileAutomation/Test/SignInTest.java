package Melaleuca.mobileAutomation.Test;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import Melaleuca.mobileAutomation.Pageobject.AndroidConfigurationShelf;
import Melaleuca.mobileAutomation.Pageobject.AndroidHomePage;
import Melaleuca.mobileAutomation.Pageobject.AndroidSignInPage;
import Melaleuca.mobileAutomation.Pageobject.CheckoutPage;
import Melaleuca.mobileAutomation.Pageobject.ShoppingCartPage;
import Melaleuca.mobileAutomation.Utils.AndroidBaseClass;

public class SignInTest extends AndroidBaseClass {
	
	AndroidSignInPage login;
	AndroidHomePage homepage;
	
	@Test(dataProvider="getData")
	public void AndroidLogin(HashMap<String, String> Input) throws InterruptedException {
		//Login Functionality
		login=new AndroidSignInPage(driver);
		login.LoginPage(Input.get("username"), Input.get("password"));
		//Thread.sleep(80);
		
		//HomePage
		homepage=new AndroidHomePage(driver);
		String text = homepage.textSupplements().getText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		Assert.assertEquals(text.contains("Supplements"), true);
		//scrollUptoElement("GC Control™ Shake: Peach Cobbler");
		scrollUptoElement("Points");

		homepage.btnAddCart().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Configuration Shelf
		AndroidConfigurationShelf shelf=new AndroidConfigurationShelf(driver);
		boolean shelfresult = shelf.yourChoiceText().isDisplayed();
		//System.out.println("Result======" +shelfresult);
		Assert.assertEquals(true, shelfresult);
		String nameOfSoap=shelf.soapName().getText();
		Assert.assertTrue(nameOfSoap.contains("Peach Cobbler GC Control"));
		shelf.btnAddCart().click();
		
		String subTotal=shelf.textSubTotal().getText().substring(1);
		System.out.println(subTotal);
		shelf.btnViewToCart().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		ShoppingCartPage shoppingPage=new ShoppingCartPage(driver);
		shoppingPage.btnProceedToCheckout().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		shoppingPage.btnContinueToCheckout().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//scrollUptoElement("Qty 26");
		
		
		CheckoutPage checkout=new CheckoutPage(driver);
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		WebElement element = checkout.addedProductText();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		checkout.addedProductText().isDisplayed();
	}

}		