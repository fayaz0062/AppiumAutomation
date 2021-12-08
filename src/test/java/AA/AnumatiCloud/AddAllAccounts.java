package AA.AnumatiCloud;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import AA.Anumati.AAPerfios;
import AA.Anumati.TestData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class AddAllAccounts extends AAPerfios {
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
	public void AllAccountsAdd(String input1, String input2 , String input3) throws IOException, InterruptedException
	{
		service= startServer();
		AndroidDriver<AndroidElement> driver=cloudCapabilities("Anumati");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp= new HomePage(driver);
		
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
		
		hp.LinkAllButton.click();
		
        hp.ProceedButton.click();
        
		Thread.sleep(2000);
		
   	    driver.hideKeyboard();
		
//		driver.getKeyboard().sendKeys("0082");
		
//		driver.hideKeyboard();
		
		//driver.findElement(By.xpath("(//android.view.View)[5]/android.widget.EditText[1]")).click();
     	driver.findElement(By.xpath("(//android.widget.EditText[1]")).sendKeys("0082");
		
		hp.VerifyButton.click();
		
		Thread.sleep(3000);
		
		String s=hp.AccountAddText.getText();
		
		Assert.assertEquals(s, "Account Added Successfully");
		
		System.out.println("Congulations Account added successfully!!");
	}

}
