package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ReadExcel(){
        try {
            //specify the path of file
            File src=new File("E:\\ProjectNotes\\TestDataSheet.xlsx");
            //load file
            FileInputStream fis=new FileInputStream(src);
            //load workbook
            wb=new XSSFWorkbook(fis);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetNum,int row,int col){
        //load sheet -here we are loading first sheet only
        sheet=wb.getSheetAt(sheetNum);
        //getRow() specify which row we want to use
        //getCell() specify which column we are reading data
        String data=sheet.getRow(row).getCell(col).getStringCellValue();
        return data;
    }
}
