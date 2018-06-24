package excelReadApi;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class ReadExcelData {
	Workbook wb;
	Sheet sheet;

	public ReadExcelData(String filePath, int sheetNumber) {
		try {
			File file = new File(filePath);
			wb = Workbook.getWorkbook(file);
			sheet = wb.getSheet(sheetNumber);
		} catch (Exception e) {
			System.out.println("Read Excel Data is throwing:- " + e);
		}
	}

	/**
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	// get cell data
	public String getCellContent(int row, int col) {
		String data = null;
		try {
			data = sheet.getCell(col, row).getContents();
		} catch (Exception e) {
			System.out.println("get Cell Content is throwing:- " + e);
		}
		return data;
	}

	/**
	 * 
	 * @return
	 */
	// return total rowCount
	public int getTotalRowCount() {
		int totalRowCount = 0;
		try {
			totalRowCount = sheet.getRows();
		} catch (Exception e) {
			System.out.println("get Total Row Count is throwing:- " + e);
		}
		return totalRowCount;
	}

	/**
	 * 
	 * @return
	 */
	// return total Column Count
	public int getTotalColumnCount() {
		int totalColumnCount = 0;
		try {
			totalColumnCount = sheet.getColumns();
		} catch (Exception e) {
			System.out.println("get Total Column Count is throwing:- " + e);
		}
		return totalColumnCount;
	}

//	public static void main(String[] args) {
//		String filePath = "E:/excelFolder/jExcelDemo.xls";
//		ReadExcelData readData = new ReadExcelData(filePath, 0);
//
//		// System.out.println(readData.getCellContent(0, 0));
//		// System.out.println(readData.getTotalRowCount());
//		// System.out.println(readData.getTotalColumnCount());
//
//	}

}
