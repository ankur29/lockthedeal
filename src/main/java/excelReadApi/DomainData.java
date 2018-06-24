package excelReadApi;

import java.io.File;

import org.testng.annotations.DataProvider;

import jxl.Sheet;
import jxl.Workbook;


public class DomainData {
	static Workbook wb;
	static Sheet sheet;
	static String data;
	static String filePath = "D:/Ankur/ExcelData/DomainTestData.xls";
	static int sheetNumber = 0;

	public static void main(String arg[]) {
		// getTotalRowsCount();
		// getData(0,0);
		dataExtractor();
	}

	// Checking File existence
	public static void loadFile() {
		try {
			if (!filePath.isEmpty()) {
				File file = new File(filePath);
				wb = Workbook.getWorkbook(file);
				sheet = wb.getSheet(sheetNumber);
			} else {
				System.out.println("File Path is not available.");
			}
		} catch (Exception e) {
			System.out.println("loadFile method is throwing:- " + e);
		}
	}

	// count total filled rows in .xls file
	public static int getTotalRowsCount(String filePath, int sheetNumber) {
		try {
			loadFile();
			int rowsCount = sheet.getRows();
			// System.out.println("Rows Count is:- "+rowsCount);
			return rowsCount;
		} catch (Exception e) {
			System.out.println("getTotalRowsCount method is throwing:- " + e);
		}
		return sheetNumber;
	}

	// count total filled columns in .xls file.
	public static Integer getTotalColsCount(String filePath, int sheetNumber) {
		try {
			loadFile();
			int colsCount = sheet.getColumns();
			// System.out.println("Cols Count is:- "+colsCount);
			return colsCount;
		} catch (Exception e) {
			System.out.println("getTotalColsCount method is throwing:- " + e);
		}
		return getTotalColsCount(filePath, sheetNumber);
	}

	// Get CellData from .xls file.
	public static String getData(int column, int row, String filePath, int sheetNumber) {
		try {
			loadFile();
			data = sheet.getCell(column, row).getContents();
			// System.out.println(data);
			return data;
		} catch (Exception e) {
			System.out.println("getData method is throwing:- " + e);
		}
		return filePath;

	}

	// Extract Data from .xls and store in Object[][] type of array.
	@DataProvider(name = "domainData")
	public static Object[][] dataExtractor() {
		try {
			int rowC = getTotalRowsCount(filePath, sheetNumber);
			Object[][] storeData = new Object[rowC - 1][5];

//			for (int i = 1; i < rowC; i++) {
//				
//				int j = 1;
//				domain.setCustomerName(getData(j++, i, filePath, sheetNumber));
//				domain.setDomainName(getData(j++, i, filePath, sheetNumber));
//				domain.setRegion(getData(j++, i, filePath, sheetNumber));
//				domain.setPortPSEnabled(getData(j++, i, filePath, sheetNumber));
//				domain.setGuiNotification(getData(j++, i, filePath, sheetNumber));
//				domain.setRevProxyUrl(getData(j++, i, filePath, sheetNumber));
//				domain.setIsApiEnabled(getData(j++, i, filePath, sheetNumber));
//				domain.setClientTime(getData(j++, i, filePath, sheetNumber));
//				domain.setApiNotification(getData(j++, i, filePath, sheetNumber));
//				storeData[i - 1][0] = domain;
//
//				contactDetails.setFirstName(getData(j++, i, filePath, sheetNumber));
//				contactDetails.setLastName(getData(j++, i, filePath, sheetNumber));
//				contactDetails.setEmail(getData(j++, i, filePath, sheetNumber));
//				contactDetails.setOfficePhone(getData(j++, i, filePath, sheetNumber));
//				storeData[i - 1][1] = contactDetails;
//				storeData[i - 1][2] = getData(j++, i, filePath, sheetNumber);
//				submitDetails.setDesc(getData(j++, i, filePath, sheetNumber));
//				submitDetails.setserviceNowcr(getData(j++, i, filePath, sheetNumber));
//				storeData[i - 1][3] = submitDetails;
//				// updateDetails.setUpdateRegion(getData(j++,i, filePath,
//				// sheetNumber));
//				updateDetails.setUpdateStatus(getData(j++, i, filePath, sheetNumber));
//
//				storeData[i - 1][4] = updateDetails;
//				System.out.println(storeData.length);
//			}

			return storeData;
		} catch (Exception e) {
			System.out.println("dataExtractor method is throwing:- " + e);
		}
		return null;
	}

}

