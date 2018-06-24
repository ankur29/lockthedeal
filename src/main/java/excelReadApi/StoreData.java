package excelReadApi;

import org.testng.annotations.DataProvider;

public class StoreData {
	
	public static void main(String[] args) {
		String filePath = "E:/excelFolder/jExcelDemo.xls";

		ReadExcelData readFirstSheetData = new ReadExcelData(filePath, 0);
		int totalRowCount=readFirstSheetData.getTotalRowCount();
		int totalColumnCount=readFirstSheetData.getTotalColumnCount();
		
		for(int i=0;i<totalRowCount;i++){
			for(int j=0;j<totalColumnCount;j++){
				System.out.print("\t"+readFirstSheetData.getCellContent(i, j));
			}
			System.out.println("");
		
		}
	}
	
	// Extract Data from .xls and store in Object[][] type of array.
//	@DataProvider(name = "testData")
//	public static Object[][] dataExtractor(){
//		
//		
//		
//	}

}
