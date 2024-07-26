package Ex;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
    @BeforeMethod
    public void launchBrowser()
    {
        System.out.println("launch Browser");
    }
    @AfterMethod
    public void closeBrowser()
    {
        System.out.println("close browser");
    }
    @Test(priority = 1)
    public void methd1(){
        System.out.println("firstTestcase");
    }
    @Test(priority = 2)
    public void method2(){
        System.out.println("secondTestcase");
    }
    @Test(priority = 3)
    public void amethod3(){
        System.out.println("thirdtestcase");
    }
    @Test
    public void bmethod4(){
        System.out.println("4thtestcase");
    }
}
