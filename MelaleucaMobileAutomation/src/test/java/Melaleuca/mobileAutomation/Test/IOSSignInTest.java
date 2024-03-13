package Melaleuca.mobileAutomation.Test;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import Melaleuca.mobileAutomation.Pageobject.IOSHomePage;
import Melaleuca.mobileAutomation.Pageobject.IOSSignInPage;
import Melaleuca.mobileAutomation.Utils.MelalAppiumACtions;

public class IOSSignInTest extends MelalAppiumACtions {
	IOSSignInPage melalogin;
	@Test
	public void loginPage() throws InterruptedException {
		 melalogin=new IOSSignInPage(driver);
		melalogin.clickOnBtnAccess();
		melalogin.LoginPage();
		Thread.sleep(80);
		IOSHomePage dashboard=new IOSHomePage(driver);
		dashboard.btnorders().click();
		Thread.sleep(80);
	}
	@Test
	public void wrongCredentials() throws InterruptedException {
		melalogin=new IOSSignInPage(driver);
		melalogin.clickOnBtnAccess();
		melalogin.username().sendKeys("New User");
		melalogin.password().sendKeys("1234455667");
		melalogin.btnsignin().click();
		Thread.sleep(80);
		String text=melalogin.invalidcredentils().getText();
		AssertJUnit.assertEquals(text.contentEquals("Invalid Username or Password."),true);
	}
	

}
