package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	public String path;
	Properties fileProps;

	public static void main(String args[]) throws IOException {
//		ReadPropertyFile rpf = new ReadPropertyFile(
//				System.getProperty("user.dir")
//						+ "/resources/environmentConfigurations");
//		System.out.println(rpf.getPropertyValue("browser.Name"));
		// System.out.println(ReadPropertyFile.getPropertyValue("prod.loginPageUrl"));

	}
	/**
	 * 
	 * @param path
	 * @throws IOException
	 */
	public ReadPropertyFile(String path) throws IOException {
		// Add the properties from the file to the properties object passed-in,
		// // if available
		System.out.println("Test");
		fileProps = new Properties();
		this.path = path;
		try (FileInputStream input = new FileInputStream(path)) {
			fileProps.load(input);
		} catch (Exception e) {
			throw new IOException(
					"ERROR: Could not load properties from file [" + path
							+ "]:\n" + e);
		}
	}
	/**
	 * 
	 * @param propTag
	 * @return
	 */
	//get Property Tag
	public String getPropertyValue(String propTag) {
		String st = fileProps.getProperty(propTag);
		return st;
	}

}