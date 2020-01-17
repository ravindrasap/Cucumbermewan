package Utility;


import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelRead {
	
	private static final String ExcelUtils = null;

	@DataProvider(name = "create")
	public static Object[][] returnExcelData()
	{
		File file = new File(System.getProperty("user.dir")+"//src//test//resources//Excel_Data_Provider//" + "Test_Data.xlsx");
		FileInputStream fis;
		Object[][] userData = null;
		
		try {
			fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("Basic_Details");
			int totalNumberofRows = sheet.getPhysicalNumberOfRows();
			System.out.println("Total number of rows " + totalNumberofRows);
			userData =  new Object[totalNumberofRows][8];
			
			for (int i = 0; i < totalNumberofRows; i++)
			{
				int totalNumberOfCells = sheet.getRow(i).getPhysicalNumberOfCells();
				
				for (int j = 0; j <totalNumberOfCells; j++) 
				{
					if (sheet.getRow(i).getCell(j).getCellType() == XSSFCell.CELL_TYPE_STRING) 
					{
						userData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					}
					else if(sheet.getRow(i).getCell(j).getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
					{	
						int intCellData = (int) sheet.getRow(i).getCell(j).getNumericCellValue();
										
						userData[i][j] =  String.valueOf(intCellData);
						System.out.println("Test Data From Excel"+intCellData);
						
					}
				}				
							}
			((Closeable) wb).close();
					
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return userData;
	}

}
