package AA.AnumatiCloud;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import AA.Anumati.AAPerfios;
import AA.Anumati.TestData;
import AA.Anumati.Utilities;
import AA.Anumati.Utilities.DIRECTION;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class SearchAccountUsingPhNoAndBank extends AAPerfios {
	

	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
	public void AccountsSearch(String input1, String input2 , String input3) throws IOException, InterruptedException
	{
		service= startServer();
		AndroidDriver<AndroidElement> driver=cloudCapabilities("Anumati");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp= new HomePage(driver);
		
		Utilities u= new Utilities(driver);
		
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
		hp.AddAcountsButton.click();
		
		hp.RegisteredPhoneNo.click();
		
		String a=hp.MsgAccountSearching.getText();
		
		
//	    List<AndroidElement> abcp= driver.findElements(By.xpath("//android.view.View"));
//	    System.out.println(abcp.size());
		
		System.out.println(a);
		
		String b=hp.BankAccountsCount.getText();
		
		System.out.println("Total of " + b + " From Bank Account number search");
		
		System.out.println("Your Accounts are identified");
		
		
    //  driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Link Accounts\"));");
		Thread.sleep(3000);
		hp.BackButton.click();
        hp.AddAcountsButton.click();
		
        u.swipe(driver, DIRECTION.DOWN, 3);
		hp.BankSearch.click();
		
		
		driver.getKeyboard().sendKeys("acme");
		
		hp.AcmeBank.click();
		
		String c = hp.MsgAccountSearching.getText();
		
		System.out.println(c);
		
        String d=hp.BankAccountsCount.getText();
		
		System.out.println("Total of " + d + " From Phone number search");
		
	}	

}
