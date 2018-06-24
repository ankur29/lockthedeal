package browserUtility;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Ankur implements Browsers interface and extends UIDriver
 */
class ChromeBrowser extends UIDriver implements Browsers {

	private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	private static final String chromeDriverPath = "D:/omsAdminTool/omsAdminTool/resources/basicTestEnviroment";
	
	// Instantiates Chrome browser
	public void getEventFireBrowser() {
		File chromeDriver = new File(chromeDriverPath);
		if (chromeDriver.exists()) {
			System.setProperty(WEBDRIVER_CHROME_DRIVER, chromeDriverPath);
			driver = new ChromeDriver();
			System.out.println("Chrome browser is launched successfully");
		}

	}

}
