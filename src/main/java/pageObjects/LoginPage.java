package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	public LoginPage(AppiumDriver driver)
	{
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Sign In']")
	public WebElement SignInButton;

	@AndroidFindBy(xpath="//android.view.View/android.widget.EditText[1]")
	public WebElement MobNoField;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Proceed']")
	public WebElement ProceedButton;
	
	@AndroidFindBy(xpath="//android.widget.EditText[1]")
	public WebElement AnumatiID;
	
	@AndroidFindBy(xpath="//android.view.View[1]/android.view.View[3]/android.widget.EditText[@text='Enter 4 digit PIN']")
	public WebElement PINFieldB;
	
	@AndroidFindBy(xpath="(//android.widget.EditText)[2]")
	public WebElement PINField;

	@AndroidFindBy(xpath="//android.view.View[@text='Sign In']")
	public WebElement SignInText;
		
	@AndroidFindBy(xpath="//android.widget.Button[@text='ALLOW']")
	public WebElement AllowButton;
	
	@AndroidFindBy(xpath="//android.view.View[@text='Skip']")
	public WebElement Skip;
	
}
