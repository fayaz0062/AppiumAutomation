
package AA.Anumati;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.HomePage;
import pageObjects.LoginPage;


public class AAPerfios {
	
	
	public static AppiumDriverLocalService service;
	public static  AndroidDriver<AndroidElement> driver;
	public AppiumDriverLocalService startServer()
	{
		boolean flag=checkIfServerIsRunning(4723);
		if(!flag)
		{
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	public static boolean checkIfServerIsRunning(int port) {
		
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try {
			serverSocket=new ServerSocket(port);
			serverSocket.close();

		}
		
		catch(IOException e) {
			//if control come here, then it means port is already in use
			isServerRunning=true;
		}
		finally {
			
			serverSocket=null;
		}
		return isServerRunning;
	}
	
	//To start emulator
		public static void startEmulator() throws IOException, InterruptedException
		{
			//C:\Users\Fayaz\Appium\AppiumFrameWork\src\main\java\resources\startEmulator.bat
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\startEmulator.bat");
			//Once emulator opens it take some time to boost up hence provide some sleep
			Thread.sleep(6000);
		}
		
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException
	{
		
		//Making the App global across the framework and to get the global.properties path
		//To get the project path
		String projPath= System.getProperty("user.dir");
     	System.out.println(projPath);
		FileInputStream fis= new FileInputStream(projPath+"\\src\\main\\java\\AA\\Anumati\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		//To open app from src file
		File appDir = new File("src");
		File app=new File(appDir , (String) prop.get(appName));
		
		
		//To get the device name
		//Name of devvice=Fayaz_Emulator2
		String device=(String) prop.get("device");
		
		//Logic to run only emulator device instead real device and skip the automatic running of emulator device incase want to real device
		
		if(device.contains("Emulator"))
		{
			startEmulator();
		}
		
		DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
				
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        
        cap.setCapability("autoGrantPermissions", "true");
		
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Fayaz_Emulator2");
		
		//Incase of APK file
//		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		
//		cap.setCapability("appPackage", "com.android.chrome");			
//		cap.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
			
		//port no.
		driver=new AndroidDriver<>(new URL("http://192.168.22.92:4723/wd/hub"),cap);
		
		
		Thread.sleep(3000);
		return driver;
	}
	
	public static AndroidDriver<AndroidElement> cloudCapabilities(String appName) throws IOException, InterruptedException
	{
		
		//Making the App global across the framework and to get the global.properties path
		//To get the project path
		String projPath= System.getProperty("user.dir");
     	System.out.println(projPath);
		FileInputStream fis= new FileInputStream(projPath+"\\src\\main\\java\\AA\\Anumati\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		//To get the device name
		//Name of devvice=Fayaz_Emulator2
		//String device=(String) prop.get("device");
		
		//Logic to run only emulator device instead real device and skip the automatic running of emulator device incase want to real device
		
//		if(device.contains("Emulator"))
//		{
//			startEmulator();
//		}
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		// Set your access credentials
	    cap.setCapability("browserstack.user", "manjunath75");
	    cap.setCapability("browserstack.key", "6q8ewtUndjpYJ994dJeE");
				    
	    // Specify device and os_version for testing
	      cap.setCapability("device", "Google Pixel 3");
	      cap.setCapability("os_version", "9.0");
	        
          
	      cap.setCapability("app", "bs://4d85444a7bb3af6b0e82483f274ba133b1e0b79a");
        cap.setCapability("autoGrantPermissions", "true");
	
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
			
		//port no.
		driver=new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"),cap);
		
		
		Thread.sleep(3000);
		return driver;
	}
	
	//Capturing screen  shot of failed test cases.
		public static  void getScreenshot(String s) throws IOException
		{
		    File scrShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrShotFile, new File(System.getProperty("user.dir")+"\\"+s+".png"));
		}
	
	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException
	{
		//taskkill /F /IM node.exe
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}

}
