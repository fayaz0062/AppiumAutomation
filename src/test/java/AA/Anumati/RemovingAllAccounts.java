package AA.Anumati;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.AccountsPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class RemovingAllAccounts extends AAPerfios{
	
	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
	public void RemoveAllAccounts(String input1, String input2 , String input3) throws IOException, InterruptedException
	{
		service= startServer();
		AndroidDriver<AndroidElement> driver=capabilities("Anumati");
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
		
//		ap.ThreeDots.click();
//		
//		ap.RemoveAccountButton.click();
//		
//		ap.PopupRemoveButton.click();
		
		
		
//		List<AndroidElement> abcp= driver.findElements(By.xpath("//android.view.View/android.widget.Image"));
//		System.out.println(abcp.size());
//		
//		List<AndroidElement> abcd= driver.findElements(By.xpath("//android.widget.Image"));
//		System.out.println(abcd.size());
		
		
	    int count=ap.ThreedotsandPopupclose.size();
		System.out.println(count);
		
			  
		 
		for(int i=1;i<count-2;i++)
		{
			
			ap.ThreedotsandPopupclose.get(3).click();
			ap.RemoveAccountButton.click();
			ap.PopupRemoveButton.click();
			Thread.sleep(2000);
			 int count1=ap.ThreedotsandPopupclose.size();
			System.out.println(count);
			String s=ap.PopupAccountRemovalText.getText();
			
			Assert.assertEquals(s, "Account Remove Successfully");
			
			System.out.println("Account Removed Succesfully");
			
			ap.ThreedotsandPopupclose.get(count-i).click();
		}
	
	}

}
