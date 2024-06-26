package excelUtility;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
public void writeinTable(List<String> str, int no_of_col) {
	try
	{
		String file="./src/ExcelFiles/WriteExcel.xlsx";
		XSSFWorkbook wbook=new XSSFWorkbook();
		XSSFSheet sheet=wbook.createSheet("CarLoan");
		FileOutputStream out=new FileOutputStream(new File(file));
		int rowsize=(str.size()/no_of_col);
		int temp=0;
		for (int i=0;i<rowsize;i++)
		{
			XSSFRow row=sheet.createRow(i);
			for (int j=0;j<no_of_col;j++)
			{
			row.createCell(j).setCellValue(str.get(temp));
			temp++;
			}
		}

		wbook.write(out);		
		wbook.close();
		out.close();
	    System.out.println("Output succesfully write in excel file");
	}catch(Exception e)
	{
		System.out.println("Output not writtern in excel file"+e);
	}
	
}
}
