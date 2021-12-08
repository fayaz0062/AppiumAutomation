package AA.AnumatiCloud;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import AA.Anumati.AAPerfios;
import AA.Anumati.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.AccountsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class RemovingSingleAccount extends AAPerfios {
	
	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
	public void RemoveOneAccounts(String input1, String input2 , String input3) throws IOException, InterruptedException
     {
	
		service= startServer();
	AndroidDriver<AndroidElement> driver=cloudCapabilities("Anumati");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	LoginPage lp=new LoginPage(driver);
	HomePage hp= new HomePage(driver);
	AccountsPage ap= new AccountsPage(driver);
	
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
	
	Thread.sleep(3000);
	
	hp.accounts.click();
	ap.Accounts.click();
	
	Thread.sleep(2000);
	int count=ap.ThreedotsandPopupclose.size();
	
	ap.ThreedotsandPopupclose.get(3).click();
	ap.RemoveAccountButton.click();
	ap.PopupRemoveButton.click();
	String s=ap.PopupAccountRemovalText.getText();
		
	Assert.assertEquals(s, "Account Remove Successfully");
		
	System.out.println("Account Removed Succesfully");
	 
	
  }

}
