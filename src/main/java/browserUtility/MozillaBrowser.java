package browserUtility;

import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * 
 * @author Ankur
 *implements Browsers interface and extends UIDriver
 */
 class MozillaBrowser extends UIDriver implements Browsers  {

	private static final String GECKODRIVER_PATH = "E:/driver/geckodriver-v0.17.0-win64/geckodriver.exe";
	private static final String WEBDRIVER_GECKO_DRIVER = "webdriver.gecko.driver";
	
//	Instantiates firefox browser
	public void getEventFireBrowser() {
		System.setProperty(WEBDRIVER_GECKO_DRIVER, GECKODRIVER_PATH);
		driver =new FirefoxDriver();		
	}

}
