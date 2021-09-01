package base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataReader {
    XSSFWorkbook Workbook = null;
    XSSFSheet Worksheet = null;

    public String getCellData(String file, String sheet, int row, int col) throws IOException {
        Workbook = new XSSFWorkbook(file);
        Worksheet = Workbook.getSheet(sheet);
        return Worksheet.getRow(row).getCell(col).toString();
    }

    public List<List<String>> getSheetDataToList(String file, String sheet) throws IOException {
        Workbook = new XSSFWorkbook(file);
        Worksheet = Workbook.getSheet(sheet);
        Iterator<Row> rowIterator = Worksheet.rowIterator();
        List<List<String>> SheetData = new ArrayList<>();
        List<String> rowData = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                rowData.add(cell.toString());
            }
            SheetData.add(new ArrayList<>(rowData));
            rowData.clear();
        }
        return SheetData;
    }

    public static void writeDataToExcel(String filePath, String sheet, String Row, String Column, String Value) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        XSSFWorkbook Workbook = new XSSFWorkbook(file);
        XSSFSheet Worksheet = Workbook.getSheet(sheet);
        for (int i = 0; i<=Worksheet.getLastRowNum(); i++){
            if(Worksheet.getRow(i).getCell(0).toString().equalsIgnoreCase(Row)){
                for (Cell cell : Worksheet.getRow(0)){
                    if(cell.toString().equalsIgnoreCase(Column)){
                        Row row = Worksheet.getRow(i);
                        int colNum = cell.getColumnIndex();
                        Cell cellToBeUpdated = row.createCell(colNum);
                        cellToBeUpdated.setCellValue(Value);
                    }
                }
            }
        }
        file.close();
        FileOutputStream outFile = new FileOutputStream(new File(filePath));
        Workbook.write(outFile);
        outFile.close();
    }

 /*   public static void main (String[] args) throws IOException {
        writeDataToExcel("src/test/ProductData1.xlsx", "Sheet1", "User2", "Output", "Test");

    }*/

    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(new File( "src/test/ProductData1.xlsx"));
        XSSFWorkbook Workbook = new XSSFWorkbook(file);
        XSSFSheet Worksheet = Workbook.getSheet("Sheet1");
        Row row = Worksheet.getRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("FirtString");
        file.close();
        FileOutputStream Outile = new FileOutputStream(new File("src/test/ProductData1.xlsx"));
        Workbook.write(Outile);
        Outile.close();
    }

}