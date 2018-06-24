package browserUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
/**
 * 
 * @author Ankur
 * browser selection methods are written.
 */

public class UIDriver {
	public static WebDriver driver,d;
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		launchBrowser("Mozilla");
		driver.get("https://www.google.co.in/");
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		Thread.sleep(20000);
		driver.get("https://www.google.com/gmail/");
		
	}
	
	/**
	 * 
	 * @param browserName
	 */
	//launch requested browser
	private static void launchBrowser(String browserName){		
		browserName=browserName.toLowerCase();
		if(browserName.contains("mozilla")){
			MozillaBrowser mb =new MozillaBrowser();
			mb.getEventFireBrowser();
		}else if(browserName.contains("chrome")){
			ChromeBrowser chromeBrowser =new ChromeBrowser();
			chromeBrowser.getEventFireBrowser();
			System.out.println("launch chrome browser");
		}else if(browserName.contains("internet")){
			System.out.println("launch internet explorer");
		}else{
			System.out.println("No browser is selected");
		}
	
	}
	/**
	 * 
	 * @param browserName
	 * @param appUrl
	 */
	public static void hitUrl(String browserName,String appUrl){
		launchBrowser(browserName);
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	

}
