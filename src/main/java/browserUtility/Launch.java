//package browserUtility;
//
//import genericUtilities.ReadPropertyFile;
//
//public class Launch {
//	public class LaunchApplication {
//		//get browser name 
//		static String browserName = ReadPropertyFile.loadPropertyFile(
//				System.getProperty("user.dir")+"/resources/basicTestEnviroment", "browser.Name");
//		//get application url
//		static String appUrl = ReadPropertyFile.loadPropertyFile(
//				System.getProperty("user.dir")+"/resources/basicTestEnviroment", "app.Url");
//
//		static {
//			try {
//				//initiate application
//				UIDriver.hitUrl(browserName, appUrl);
//			} catch (Exception e) {
//				System.out.println("Unable to lanch application");
//			}
//
//		}
//
//	}
//
//}
