package AA.Anumati;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class AddingSingleAccount extends AAPerfios{

	
	
	@SuppressWarnings("deprecation")
	@Test(dataProvider="InputDataName",dataProviderClass=TestData.class)
    public void  SingleAccountAdd(String input1, String input2 , String input3) throws IOException, InterruptedException
    {
		service= startServer();
		AndroidDriver<AndroidElement> driver=capabilities("Anumati");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp= new HomePage(driver);	
		
//	List<AndroidElement> abc= driver.findElements(By.xpath("//android.view.View/android.widget.EditText"));
//	System.out.println(abc.size());
				
	Thread.sleep(2200);
	lp.Skip.click();	
	lp.MobNoField.click();
	lp.MobNoField.sendKeys(input1);
	driver.hideKeyboard();
		
	lp.ProceedButton.click();
	Thread.sleep(2000);	
    lp.AnumatiID.sendKeys(input2);
	
//  List<AndroidElement> abcp= driver.findElements(By.xpath("//android.view.View[1]/android.view.View[2]/android.widget.EditText[2]"));
//	System.out.println(abcp.size());
	
	lp.PINField.click();
	lp.PINField.sendKeys(input3);
	driver.hideKeyboard();

	lp.SignInButton.click();
	
	Thread.sleep(3000);
	hp.AddAcountsButton.click();
	
	Thread.sleep(3000);
	hp.Checkbox1.click();
	
	hp.ProceedButton.click();
	
	Thread.sleep(2000);
	
	driver.hideKeyboard();
	
	driver.getKeyboard().sendKeys("812093");
	
	driver.hideKeyboard();
	
	hp.VerifyButton.click();
	
	Thread.sleep(3000);
	
	String s=hp.AccountAddText.getText();
	
	Assert.assertEquals(s, "Account Added Successfully");
	
	System.out.println("Congulations Account added successfully!!");
	
	
}
	
}
