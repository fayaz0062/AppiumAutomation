
package AA.Anumati;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class AAPerfiosViaBrower {
	
	
	public static  AndroidDriver<AndroidElement> driver;
	
	public static AndroidDriver<AndroidElement> capabilities() throws IOException, InterruptedException
	{
		
		//Making the App global across the framework and to get the global.properties path
		//To get the project path
		String projPath= System.getProperty("user.dir");
     	System.out.println(projPath);
		FileInputStream fis= new FileInputStream(projPath+"\\src\\main\\java\\AA\\Anumati\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		//To open app from src file
		//File appDir = new File("src");
		//File app=new File(appDir , (String) prop.get(appName));
		
		
		//To get the device name
		//Name of devvice=Fayaz_Emulator2
	//	String device=(String) prop.get("device");
		
		
				
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Fayaz_Emulator1");
		
		//Incase of APK file
//		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		
		cap.setCapability("appPackage", "com.android.chrome");			
		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
			
		//port no.
		driver=new AndroidDriver<>(new URL("http://192.168.22.92:4723/wd/hub"),cap);
		
		driver.findElementByXPath("//android.widget.EditText[@text='Search or type web address']").sendKeys("http://qa.anumati.co.in/anumati-aa/");
        Actions act=new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		return driver;
	}

}
