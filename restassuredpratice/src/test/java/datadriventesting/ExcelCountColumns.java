package datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelCountColumns {
	
	@Test
	public void getCountColumns() throws Exception {
		FileInputStream fis  = new FileInputStream("./example.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		int colCount = wb.getSheet("Sheet1").getRow(1).getLastCellNum();
		
		 
		 System.out.println(colCount);
	}

}
