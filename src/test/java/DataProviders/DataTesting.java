package DataProviders;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataTesting {

    @Test(dataProvider = "static")
    public void TC01(String Uname,String Password)
    {
        System.out.println(Uname);
        System.out.println(Password);
    }

    @DataProvider(name="static")
    public Object[][] testData()
    {
        Object[][] arr={{"Vemuri","Naveen"},{"V","N"}};
        return arr;
    }

    @DataProvider(name="Excel")
    public Object[][] ReadDataFromExcel() throws IOException {
        FileInputStream fs=new FileInputStream("./src/TestData/TestData.xlsx");
        XSSFWorkbook wbook=new XSSFWorkbook(fs);
        XSSFSheet sh=wbook.getSheet("Sheet1");
        int noofrows=sh.getLastRowNum();
        XSSFRow row= sh.getRow(0);
        int noofcolumns=row.getLastCellNum();
        Object[][] testdata=new Object[noofrows][noofcolumns];
        for(int i=0;i<sh.getLastRowNum();i++)
        {
           for(int k=0;k<noofcolumns;k++)
           {
               testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
               testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
               testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
               testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
               testdata[i][k]=sh.getRow(i+1).getCell(k).toString();
           }

        }
        return  testdata;
    }

    @Test(dataProvider ="Excel")
    public  void testdatafromexcel(String sno,String name,String age,String gender,String salary)
    {
        System.out.println(sno);
        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(salary);
    }
}
