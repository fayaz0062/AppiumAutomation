package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Profile {
	
	public Profile(AppiumDriver driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	
	}
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]")
	public WebElement ProfileButtonB;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View[3]/android.view.View[1]/android.view.View[1]")
	public WebElement ProfileButton;
	
	@AndroidFindBy(xpath="(//android.view.View)[11]")
	public WebElement ProfileButtonC;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Edit Details']")
	public WebElement EditDetails;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Change PIN']")
	public WebElement ChangePIN;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Terms and conditions']")
	public WebElement TermsAndConditions;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Privacy Policy']")
	public WebElement PrivacyPolicy;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Activity Log']")
	public WebElement HelpNFeedBack;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Help and Feedback']")
	public WebElement ActivityLog;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Log Out']")
	public WebElement Logout;
	
	@AndroidFindBy(xpath="//android.widget.EditText[1]")
	public WebElement FullName;
	
	@AndroidFindBy(xpath="//android.widget.EditText[2]")
	public WebElement AnumatiID;
	
	@AndroidFindBy(xpath="//android.widget.EditText[5]")
	public WebElement EmailID;

	@AndroidFindBy(xpath="//android.widget.Button[@text='Save']")
	public WebElement SaveButton;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Saved Details']")
	public WebElement SavedDetails;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue']")
	public WebElement ChangePINContinueButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Save']")
	public WebElement ChangePINSaveButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Log Out']")
	public WebElement LogOutButton;
	
}
