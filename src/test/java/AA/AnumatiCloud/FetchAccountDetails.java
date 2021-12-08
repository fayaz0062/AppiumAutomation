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

public class FetchAccountDetails extends AAPerfios {

	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
	public void AccountDetailsFetch(String input1, String input2 , String input3) throws IOException, InterruptedException
	{
		service= startServer();
		AndroidDriver<AndroidElement> driver=cloudCapabilities("Anumati");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
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
		
		ap.AccountDetails.click();
		Thread.sleep(2000);
		 String d=hp.BankAccountsCount.getText();
			
		System.out.println("Hi Total of " + d + " !");
		
		int count=hp.AccountNumber.size();
		int count1=hp.AccountType.size();
		int j=0;
		for(int i=9;i<count;i++)
		{
			
		String accountNum=hp.AccountNumber.get(i).getText();
		String accountType = hp.AccountType.get(j).getText();
		
		
		if(accountNum.equalsIgnoreCase("Search accounts using") || accountNum.equalsIgnoreCase("Registered phone number") || accountNum.equalsIgnoreCase("") ) 
			{
			System.out.println();
			}
		else {
			
			System.out.println(accountNum+ ":" + accountType);
			j++;
		     }
		if( j>=count1 ) 
            break;
         
			
		}
		
	}
}
