package ReadDataFromExcel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Excel {
    @Test
    public void ReadData() throws IOException {
        FileInputStream fs=new FileInputStream("./src/TestData/TestData.xlsx");
        //xlsx extension -xssfworkbook
        //xls - HSSF
        XSSFWorkbook wb=new XSSFWorkbook(fs);
        XSSFSheet sh=wb.getSheet("Sheet1");
        XSSFRow r1=sh.getRow(0);
        XSSFCell c1=r1.getCell(0);
        System.out.println(c1.getStringCellValue());
        System.out.println(sh.getPhysicalNumberOfRows());
        System.out.println(sh.getLastRowNum());
        System.out.println(r1.getPhysicalNumberOfCells());
    }

    @Test
    public void ReadCompleteExcelData() throws IOException {
        FileInputStream fs=new FileInputStream("./src/TestData/TestData.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fs);
        XSSFSheet sh=wb.getSheet("Sheet1");
        int noofrows=sh.getPhysicalNumberOfRows();
        for(int i=0;i<noofrows;i++)
        {
            XSSFRow row= sh.getRow(i);
            int noofcells=row.getPhysicalNumberOfCells();
            for(int j=0;j<noofcells;j++)
            {
                XSSFCell cell=row.getCell(j);
                if(cell.getCellType()== CellType.STRING)
                {
                    System.out.print(cell.getStringCellValue()+" ");
                }
                else if(cell.getCellType()==CellType.NUMERIC)
                {
                    System.out.print((int)cell.getNumericCellValue()+" ");
                }
                else if(cell.getCellType()==CellType.BOOLEAN)
                {
                    System.out.print(cell.getBooleanCellValue()+" ");
                }
                else if (cell.getCellType()==CellType.ERROR)
                {
                    System.out.print(i+" ");
                }

            }
            System.out.println();
        }
    }
}
