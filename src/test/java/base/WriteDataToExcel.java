package base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteDataToExcel {
    public static void main(String[] args) throws IOException {
        writeDate("src/test/resources/ProductData.xlsx","Sheet1", "User1","Output", "Test Output");
    }

    public static void writeDate(String FileName, String SheetName, String UserName, String OutputCol, String OutputValue) throws IOException {
        FileInputStream file = new FileInputStream(new File(FileName));
        XSSFWorkbook Workbook = new XSSFWorkbook(file);
        XSSFSheet Worksheet = Workbook.getSheet(SheetName);

        for (int i=0; i<Worksheet.getLastRowNum(); i++){
            if(Worksheet.getRow(i).getCell(0).toString().equalsIgnoreCase(UserName)){
                Row row = Worksheet.getRow(i);
                for (Cell cell:Worksheet.getRow(0)){
                    if (cell.toString().equalsIgnoreCase(OutputCol)){
                        int cellNum = cell.getColumnIndex();
                        Cell cellToBeUpdated = row.createCell(cellNum);
                        cellToBeUpdated.setCellValue(OutputValue);
                    }
                }
            }
            file.close();
            FileOutputStream output = new FileOutputStream(new File(FileName));
            Workbook.write(output);
            output.close();
        }

    }
}
