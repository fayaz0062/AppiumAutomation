package AA.AnumatiCloud;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import AA.Anumati.AAPerfios;
import AA.Anumati.TestData;
import AA.Anumati.Utilities;
import AA.Anumati.Utilities.DIRECTION;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Profile;

public class LoginNLogout extends AAPerfios {

	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
	public void LoginAndLogout(String input1, String input2 , String input3) throws IOException, InterruptedException
	{
		
		service= startServer();
	AndroidDriver<AndroidElement> driver=cloudCapabilities("Anumati");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	LoginPage lp=new LoginPage(driver);
	HomePage hp= new HomePage(driver);
	
	Utilities u= new Utilities(driver);
	
	Profile p= new Profile(driver);
	
//	lp.AllowButton.click();
	Thread.sleep(2200);
	lp.Skip.click();
	lp.MobNoField.click();
	lp.MobNoField.sendKeys(input1);
	driver.hideKeyboard();
	 
	lp.ProceedButton.click();
	Thread.sleep(2000);	
    lp.AnumatiID.sendKeys(input2);
    
    lp.PINField.click();
	lp.PINField.sendKeys(input3);
	
	lp.SignInButton.click();
	Thread.sleep(3000);
	
//	u.swipe(driver, DIRECTION.UP, 2);
	
	p.ProfileButtonC.click();
	
	p.Logout.click();
	
	p.LogOutButton.click();
	
	String s = lp.SignInText.getText();
	Assert.assertEquals(s, "Sign In");
	System.out.println("You are Logged out succesfully!!");
	
	Thread.sleep(3000);
	
	}
	
	
}
