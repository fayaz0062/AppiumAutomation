package AA.Anumati;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {
	
AndroidDriver<AndroidElement> driver;
	
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
	}
	
	
	public void scrollToText(String text) 
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public static void swipe(MobileDriver driver, DIRECTION direction, long duration) {
	    Dimension size = driver.manage().window().getSize();

	    switch (direction) {
	    
	    	//Top to bottom
	        case UP:
	        	
	        	int startX = (int) (size.width * 0.5);
	            int startY = (int) (size.height * 0.2);
	           int endX = (int) (size.width * 0.2);
	            int endY=(int) (size.height * 0.8);
	            new TouchAction(driver)
                .press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX,endY))
                .release()
                .perform();
	            break;

	        //bottom to top   
	        case DOWN:
	        
	        	startX = (int) (size.width * 0.5);
	            startY = (int) (size.height * 0.8);  
	         endX = (int) (size.width * 0.2);
	            endY=(int) (size.height* 0.2);
	            new TouchAction(driver)
                .press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX,endY))
                .release()
                .perform();
	            break;
	            
	        
//    case UP:
//        endY = (int) (size.height * 0.70);
//        startY = (int) (size.height * 0.30);
//        startX = (size.width / 2);
//        new TouchAction(driver)
//                .press(startX, startY)
//                .waitAction(Duration.ofMillis(duration))
//                .moveTo(startX, endY)
//                .release()
//                .perform();
//        break;

//
//    case DOWN:
//        startY = (int) (size.height * 0.70);
//        endY = (int) (size.height * 0.30);
//        startX = (size.width / 2);
//        new TouchAction(driver)
//                .press(startX, startY)
//                .waitAction(Duration.ofMillis(duration))
//                .moveTo(startX, endY)
//                .release()
//                .perform();
//
//        break;

}
}
	
	public enum DIRECTION {
	    DOWN, UP, LEFT, RIGHT;
	}
	
	
}

	    
	    
	    
	    