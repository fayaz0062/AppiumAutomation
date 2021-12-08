package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	public HomePage(AppiumDriver driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	
	}
	
	
	@AndroidFindBy(xpath="//android.view.View[@text='Add Accounts']")
	public WebElement AddAcountsButton;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View[3]/android.view.View[1]/android.view.View[2]")
	public WebElement ProfileButton;
	
	//For acme we have it from 5 to 9
	@AndroidFindBy(xpath="//android.view.View[5]")
	public WebElement Checkbox1;
	
	@AndroidFindBy(xpath="//android.view.View[6]")
	public WebElement Checkbox2;
	
	@AndroidFindBy(xpath="//android.view.View[7]")
	public WebElement Checkbox3;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Proceed']")
	public WebElement ProceedButton;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.widget.EditText[1]")
	public WebElement OTP;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Verify']")
	public WebElement VerifyButton;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Account Added Successfully']")
	public WebElement AccountAddText;
	
	
	@AndroidFindBy(xpath="//android.view.View[@text='Link All']")
	public WebElement LinkAllButton;
	
	@AndroidFindBy(xpath="//android.view.View[@text='accounts']")
	public WebElement accounts;
	
	@AndroidFindBy(xpath="//android.view.View[@text='dashboard']")
	public WebElement dashBoard;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Registered phone number']")
	public WebElement RegisteredPhoneNo;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Bank Search']")
	public WebElement BankSearch;
	
	@AndroidFindBy(xpath="//android.view.View[3]")
	public WebElement MsgAccountSearching;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View[2]/android.view.View[3]")
	public WebElement BankAccountsCountB;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Accounts found')]")
	public WebElement BankAccountsCount;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Link Accounts']")
	public WebElement BackButton;
	
	@AndroidFindBy(xpath="//android.widget.Image[@text='acme...']")
	public WebElement AcmeBank;
	

	@AndroidFindBy(xpath="//android.view.View[contains(@text,'Namaste')]")
	public WebElement WelcomeText;
	
	@AndroidFindBy(xpath="//android.view.View")
	public List<WebElement> AccountNumber;
	
	@AndroidFindBy(xpath="//android.widget.TextView")
	public List<WebElement> AccountType;
}
