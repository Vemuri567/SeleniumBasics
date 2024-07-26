package Ex;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNgAnotations {

    @BeforeSuite
    public void method1(){
        System.out.println("beforesuite");
    }
    @BeforeClass
    public  void method2(){
        System.out.println("beforeclass");
    }
    @BeforeTest
    public  void method3(){
        System.out.println("beforeTest");
    }
    @BeforeMethod
    public  void method4(){
        System.out.println("beforeMethod");
    }
    @Test
    public  void method5(){
        System.out.println("Ex.Test1");
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods = "method5")
    public  void method6(){
        System.out.println("Test2");
    }
    @Test(groups = {"smoke"})
    public  void method7(){
        System.out.println("Test3");
    }

    @AfterMethod
    public  void method8(){
        System.out.println("AfterMethod");
    }
    @AfterClass
    public  void method9(){
        System.out.println("Afterclass");
    }
    @AfterSuite
    public  void method10(){
        System.out.println("Aftersuite");
    }
    @AfterTest
    public  void method11(){
        System.out.println("AfterTest");
    }
}
