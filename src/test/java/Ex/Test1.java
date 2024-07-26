package Ex;

import Selenium.LaunchBrowser;
import Selenium.ReadConfigProperties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test1 {
    LaunchBrowser obj;
    @BeforeSuite(alwaysRun = true)
    public void launchbrowser(){
        obj =new LaunchBrowser();
    }


    @BeforeMethod(alwaysRun = true)
    public void initBrowser(){

        obj.initDriver();
    }

    @Test
    public void DemoopencartLogin() {

        obj.openUrl("https://demo.opencart.com");
        obj.verifyElement(By.xpath("//a[text()='Desktops']"));
        obj.clickonWebelement(By.xpath("//span[text()='My Account']/..//i[@class='fa-solid fa-user']"));
        obj.clickonWebelement(By.xpath("//a[text()='Register']"));
        obj.EnterText(By.xpath("//input[@id='input-firstname']"),"Vemuri");
        obj.EnterText(By.xpath("//input[@id='input-lastname']"),"Naveen");
        obj.EnterText(By.xpath("//input[@id='input-email']"),"naveenchowdaryvemuri@gmail.com");
        obj.EnterText(By.xpath("//input[@id='input-password']"),"Naveen@123");
        obj.javascriptExecutorClickable(By.xpath("//label[text()='Yes']//preceding-sibling::input"));
        //obj.verifyElement(By.xpath("//label[text()='Yes']//preceding-sibling::input"));
        //obj.clickonWebelement(By.xpath("//label[text()='Yes']//preceding-sibling::input"));
        obj.javascriptExecutorClickable(By.xpath("//input[@name='agree']"));
        obj.javascriptExecutorClickable(By.xpath("//button[text()='Continue']"));
        //obj.clickonWebelement(By.xpath("//input[@name='agree']"));
        //obj.clickonWebelement(By.xpath("//button[text()='Continue']"));
        obj.quitDriver();
    }


    @Test
    public void opencartLogin() {

        obj.openUrl("https://www.opencart.com/");
        boolean flag=obj.verifyElement(By.xpath("//a[text()='Login' and @class='btn btn-link navbar-btn']"));

        Assert.assertTrue(flag,"Home Page displayed");
        obj.clickonWebelement(By.xpath("//a[text()='Login' and @class='btn btn-link navbar-btn']"));
        obj.EnterText(By.xpath("//input[@id='input-email']"),"naveenchowdaryvemuri@gmail.com");
        obj.EnterText(By.xpath("//input[@id='input-password']"),"Naveen@143");
        obj.clickonWebelement(By.xpath("//button[text()='Login']"));
        boolean accountbtn=obj.verifyElement(By.xpath("//a[text()='Account' and @class='btn btn-link navbar-btn']"));
        Assert.assertTrue(accountbtn,"User successfully login to application");
        obj.EnterText(By.cssSelector("#input-pin"),"6699");
        obj.clickonWebelement(By.xpath("//button[text()='Continue']"));
        obj.quitDriver();
    }


    @Test
    public void Amazon_Mobiles() throws IOException {
        obj.openUrl("https://www.amazon.in");
        obj.clickonWebelement(By.xpath("//a[text()='Mobiles']"));
        obj.CustomxpathforBrandsCheckboxes("OnePlus");
        String Actual=obj.clickonResultItem("2");
        obj.SwitchtoLastwindow();
        String expected=obj.getText(By.cssSelector("#productTitle"));
        Assert.assertEquals(Actual,expected,"Selected product is not displaying");
        obj.TakeScreenShot("amazon");
    }

    @Test
    public void HandleAlertPopups()
    {
        obj.openUrl("http://demo.guru99.com/test/delete_customer.php");
        obj.waitUnitllClickable(By.xpath("//input[@name='cusid']"));
        obj.EnterText(By.xpath("//input[@name='cusid']"),"53920");
        obj.clickonWebelement(By.xpath("//input[@name='submit']"));
        obj.alertshandling("gettext","");
    }
    @Test
    public void dropdownshandling() throws IOException {
        String Url= ReadConfigProperties.fetchProperties("ApplicationUrl");
        String registerxpath=ReadConfigProperties.fetchProperties("Registerxpath");
        obj.openUrl(Url);
        obj.waitUnitllClickable(By.xpath(registerxpath));
        obj.clickonWebelement(By.xpath(registerxpath));
        obj.selectByText(By.xpath("//select[@id='input-country']"),"Afghanistan");
    }

    @Test
    public void frameshandling()
    {
        obj.openUrl("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        obj.clickonWebelement(By.cssSelector("#imageTemplateContainer"));
        obj.switchtoframe(By.xpath("//iframe[contains(@id,'frame-one')]"));
        obj.EnterText(By.cssSelector("#RESULT_TextField-1"),"1234");
        obj.switchtodefaultframe();
    }

    @Test(groups = {"smoke"})
    public void myntraApp()
    {
        obj.openUrl("https://www.myntra.com/");
        obj.menuitemsselectionusingActionclass("kids","Boys Clothing","T-Shirts");

    }


}
