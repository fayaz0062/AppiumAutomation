package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountsPage {

	//Constructor
	public AccountsPage(AppiumDriver driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.view.View[@text='Fixed Deposit']")
	public WebElement FixedDeposit;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Recurring Deposit']")
	public WebElement RecurringDeposit;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Accounts']")
	public WebElement Accounts;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Account Details']")
	public WebElement AccountDetails;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Add Account']")
	public WebElement AddAccount;
	
	//index from 2 to n
	@AndroidFindBy(xpath="(//android.widget.Image)[2]")
	public WebElement ThreeDots;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Remove Account']")
	public WebElement RemoveAccountButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Remove']")
	public WebElement PopupRemoveButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Cancel']")
	public WebElement PopupCancelButton;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Account Remove Successfully']")
	public WebElement PopupAccountRemovalText;
	
	@AndroidFindBy(className="android.widget.Image")
	public List<WebElement> ThreedotsandPopupclose;
	
	
}
