package AA.AnumatiCloud;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

public class ChangePIN extends AAPerfios {
	
	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
	public void ChangingPIN(String input1, String input2 , String input3) throws IOException, InterruptedException
	{
		
		service= startServer();
	AndroidDriver<AndroidElement> driver=cloudCapabilities("Anumati");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	LoginPage lp=new LoginPage(driver);
	HomePage hp= new HomePage(driver);
	
	Utilities u= new Utilities(driver);
	
	Profile p= new Profile(driver);
	
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
	
	//u.swipe(driver, DIRECTION.UP, 2);
	
	p.ProfileButtonC.click();
	
	p.ChangePIN.click();
	driver.hideKeyboard();
	driver.getKeyboard().sendKeys("0082");
	
	driver.hideKeyboard();
	
	p.ChangePINContinueButton.click();

	Thread.sleep(3000);
	driver.hideKeyboard();
	driver.getKeyboard().sendKeys("0082");
	
	
	p.ChangePINSaveButton.click();
	Thread.sleep(2000);
	
	 lp.PINField.click();
	 lp.PINField.sendKeys("0082");
	 
	 lp.SignInButton.click();
	 
	 String s = hp.WelcomeText.getText();
	 Assert.assertEquals(s, "Namaste Fayaz");
	 System.out.println(s +" PIN Changed Succesfully");
	
	 service.stop();
    }

}
