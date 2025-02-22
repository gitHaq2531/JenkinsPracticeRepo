package com.clientName.vtiger.generic.excelUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String path,String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisExcel= new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fisExcel);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		//Cell cell = row.getCell(cellnum);
		String data=row.getCell(cellnum).toString();
		//String data=cell.getStringCellValue();
		workbook.close();
		return data;
	}
	public void writeDataInExcel(String sheetname,int rownum,int cellnum,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisExcel= new FileInputStream("./testData/ProjectTestCaseData.xlsx");
		Workbook workbook = WorkbookFactory.create(fisExcel);
		Sheet sheet = workbook.getSheet(sheetname);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./testData/ProjectTestCaseData.xlsx");
		workbook.write(fos);
		workbook.close();
	}
	public int getRowCount(String path,String sheetname) throws IOException
	{
		FileInputStream fisExcel= new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(fisExcel);
		Sheet sheet = workbook.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
		return rowCount;
	}
}
