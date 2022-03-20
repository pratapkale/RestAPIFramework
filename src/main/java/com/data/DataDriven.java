package com.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testCaseName, String sheetName) {
		ArrayList<String> aList = new ArrayList<String>();
		FileInputStream fis;
		XSSFWorkbook workbook = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\testdata.xlsx");
			workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Testcase column by scanning the entire 1st row
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next(); // sheet is a collection of rows
				Iterator<Cell> cell = firstRow.cellIterator(); // row is a collection of cell
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {
					Cell cellVal = cell.next();
					if (cellVal.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}

				System.out.println("Column===>::" + column);
				// once column is identified then scan entire testcases column to identify
				// purchase testcase row.
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						// After grab purchase tescase row pull all the data of that row and feed into
						// test
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell cellV = cv.next();
							if (cellV.getCellType() == CellType.STRING) {
								aList.add(cellV.getStringCellValue());
							} else if (cellV.getCellType() == CellType.NUMERIC) {
								
								aList.add(NumberToTextConverter.toText(cellV.getNumericCellValue()));
							}

						}
					}
				}
			}
		}
		return aList;
	}
}
