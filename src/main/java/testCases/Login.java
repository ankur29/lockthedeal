package testCases;

import genericUtilities.ReadPropertyFile;

import java.io.IOException;
import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import browserUtility.UIDriver;

public class Login {	
	 Logger logger = Logger.getLogger(Login.class.getName());
	@BeforeClass
	public void launchAppication() throws IOException{
		ReadPropertyFile rpf =new ReadPropertyFile(System.getProperty("user.dir")+"/resources/environmentConfigurations");
//		get browser name 
		 String browserName = rpf.getPropertyValue("browser.Name");
		//get application url
		String appUrl = rpf.getPropertyValue("prod.loginPageUrl");
		UIDriver.hitUrl(browserName, appUrl);
	}
	
	@Test
	void TestRun(){
//		System.out.println("Test");
//		PerformAction.clickButton("APPROVE_BTN_CHANGELIST_XPATH", "Value");
		
	}

}
