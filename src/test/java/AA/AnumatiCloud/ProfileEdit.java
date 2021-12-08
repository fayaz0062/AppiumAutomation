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

public class ProfileEdit extends AAPerfios {
	
	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
	public void EditTheProfile(String input1, String input2 , String input3) throws IOException, InterruptedException
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
		driver.hideKeyboard();
	    
		lp.SignInButton.click();
		
		//u.swipe(driver, DIRECTION.UP, 3);
		p.ProfileButtonC.click();
		
		p.EditDetails.click();
		
		p.FullName.click();
		p.FullName.clear();
		p.FullName.sendKeys("Fayaz");
		driver.hideKeyboard();
		
		p.AnumatiID.click();
		p.AnumatiID.clear();
		p.AnumatiID.sendKeys("7760305049");
		driver.hideKeyboard();
		
		p.EmailID.click();
		p.EmailID.sendKeys("fayaz.a@perfios.com");
		driver.hideKeyboard();
		
		p.SaveButton.click();
		
		String s = p.SavedDetails.getText();
		Assert.assertEquals(s, "Saved Details");
		System.out.print("Details saved successfully!!");
	}
}
