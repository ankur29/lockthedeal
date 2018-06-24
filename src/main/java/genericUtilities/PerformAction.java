package genericUtilities;

import genericConstants.DropdownConstatnts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import browserUtility.UIDriver;

public final class PerformAction extends UIDriver {

	private PerformAction() {

	}
	/**
	 * 
	 * @param domKey
	 * @param domValue
	 * @return
	 */
	//get WebElement
	public static WebElement getLocator(String domKey, String domValue) {
		String locatorType = domKey.split("_")[3];
		System.out.println("locatorType :-" + locatorType);
		WebElement locator = null;
		if (locatorType.equalsIgnoreCase("XPATH")) {
			locator = driver.findElement(By.xpath(domValue));
		} else if (locatorType.equalsIgnoreCase("ID")) {

			locator = driver.findElement(By.id(domValue));

		} else if (locatorType.equalsIgnoreCase("NAME")) {

			locator = driver.findElement(By.name(domValue));

		} else if (locatorType.equalsIgnoreCase("CSS")) {

			locator = driver.findElement(By.cssSelector(domValue));

		} else if (locatorType.equalsIgnoreCase("LINKTEXT")) {

			locator = driver.findElement(By.linkText(domValue));
		}
		return locator;

	}
	/**
	 * 
	 * @param domKey
	 * @param domValue
	 */
	public static void clickButton(String domKey, String domValue) {

		String name = domKey.split("_")[0];
		// System.out.println("name :-" + name);
//		WebElement locator = getLocator(domKey, domValue);

		try {

//			if (locator.isEnabled() && locator.isDisplayed()) {
//				locator.click();

				System.out.println("Clicked on " + "'" + name + "'" + " button");
//			}

//			else {
				System.out.println("'" + name + "'" + " : Button is not enabled");

//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param domKey
	 * @param domValue
	 * @param text
	 */
	public static void sendText(String domKey, String domValue, String text) {
		String name = domKey.split("_")[0];
		// System.out.println("name :-" + name);
		WebElement locator = getLocator(domKey, domValue);

		try {
			if (locator.isDisplayed()) {
				System.out.println(name + " is displayed");
				locator.clear();
				locator.sendKeys(text);
				System.out.println("'" + text + "'" + " value is inserted in " + name + " field");

			} else {
				System.out.println("'" + name + "'" + " : TextField is not displayed");
			}
		} catch (Exception e) {
			System.out.println("'" + name + "'" + " : fillTextField method is throwing:- " + e);
		}
	}
	/**
	 * 
	 * @param domKey
	 * @param domValue
	 * @param Index
	 * @param selectionType
	 */
	public static <T> void dropdownSelection(String domKey, String domValue, T Index, String selectionType) {
		String name = domKey.split("_")[0];
		// System.out.println("name :-" + name);
		WebElement locator = getLocator(domKey, domValue);

		try {

			if (locator.isDisplayed()) {
				//locator.clear();
				Select select = new Select(locator);
				switch (selectionType) {
				case DropdownConstatnts.KEY_SELECT_BY_INDEX:
					select.selectByIndex(Integer.parseInt((String) Index));
					break;
				case DropdownConstatnts.KEY_DESELECT_BY_INDEX:
					select.deselectByIndex(Integer.parseInt((String) Index));
					break;
				case DropdownConstatnts.KEY_SELECT_BY_VALUE:
					select.selectByValue(String.valueOf(Index));
					break;
				case DropdownConstatnts.KEY_DESELECT_BY_VALUE:
					select.deselectByValue(String.valueOf(Index));
					break;
				case DropdownConstatnts.KEY_SELECT_BY_VISIBLE_TEXT:
					select.selectByVisibleText(String.valueOf(Index));
					System.out.println(Index);
					break;
				case DropdownConstatnts.KEY_DESELECT_BY_VISIBLE_TEXT:
					select.deselectByVisibleText(String.valueOf(Index));
					break;
				default:
					throw new Exception("Selection Type mismatch..!!");

				}
				System.out.println(name + " dropdown item is selected.");
			} else {
				System.out.println(name + " is not displayed");
			}
		} catch (Exception e) {
			System.out.println(selectionType + " method is throwing:- " + e);
		}
	}
	/**
	 * 
	 * @param domKey
	 * @param domValue
	 */
	public static void selectCheckbox(String domKey, String domValue) {
		String name = domKey.split("_")[0];
		// System.out.println("name :-" + name);
		WebElement locator = getLocator(domKey, domValue);

		try {
			if (locator.isDisplayed()) {
				if (locator.isSelected()) {
					System.out.println("Checkbox: " + locator + "is already selected");
				} else {
					// Select the checkbox
					locator.click();
					System.out.println("Checkbox: " + name + "is selected");

				}
			} else {
				System.out.println(locator + " is not displayed");
			}
		} catch (Exception e) {
			System.out.println("Unable to select the checkbox: " + locator);
		}

	}
	/**
	 * 
	 * @param domKey
	 * @param domValue
	 */
	public static void deSelectCheckbox(String domKey, String domValue) {
		String name = domKey.split("_")[0];
		// System.out.println("Name :-"+name);
		WebElement locator = getLocator(domKey, domValue);

		try {
			if (locator.isDisplayed()) {
				if (locator.isEnabled()) {
					// De-select the checkbox
					locator.click();
					System.out.println("Checkbox: " + name + "is deselected");

				} else {
					System.out.println("Checkbox: " + name + "is already deselected");
				}
			} else {
				System.out.println(name + " is not displayed");
			}
		} catch (Exception e) {
			System.out.println("Unable to deselect checkbox: " + name);
		}
	}
	/**
	 * 
	 * @param position
	 */
	public static void selectCheckboxByPosition(int position){
		String xpath="(//input[@type='checkbox'])[position()="+position+"]";

		driver.findElement(By.xpath(xpath)).click();
	}
	public static void scrollUp(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}
	public static void scrollDown(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}
}
