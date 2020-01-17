import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Excelreadwrit {
 
 public static void main (String [] args) throws IOException {
	 
	 Excelreadwrit t = new Excelreadwrit();
	 t.go();
	// File file = new File(System.getProperty("user.dir")+"//src//test//resources//Excel_Data_Provider//" + "Test_Data.xlsx");
	 
 } 
	 
	 public void go() throws IOException {
	 FileInputStream fis = new FileInputStream("D:\\Test_Data.xlsx");
	 @SuppressWarnings("resource")
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	 
	 XSSFSheet sheet = workbook.getSheet("TestData");
	// .createRow(1);
	 XSSFRow row = sheet.getRow(8);
	 Cell cell = row.createCell(1);
	 
	 cell.setCellType(cell.CELL_TYPE_STRING);
	 cell.setCellValue("SoftwareTestingMaterial.com");
	 FileOutputStream fos = new FileOutputStream("D:\\Test.xlsx");
	 workbook.write(fos);
	 fos.close();
	 System.out.println("END OF WRITING DATA IN EXCEL");
	 
 }
	
	
	
	
 }