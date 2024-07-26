package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LaunchBrowser {
    WebDriver driver;
    public  void initDriver(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public  void openUrl(String url){
        driver.get(url);
        

    }

    public boolean verifyElement(By locatorType){
        return driver.findElement(locatorType).isDisplayed();
    }

    public void clickonWebelement(By locator){
        waitUnitllClickable(locator);
        driver.findElement(locator).click();
    }

    public void EnterText(By locator,String text){
        waitUnitllClickable(locator);
        driver.findElement(locator).sendKeys(text);
    }

    //Explicit wait syntax
    public void waitUnitllClickable(By locator){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void javascriptExecutorClickable(By locator){
        WebElement ele=driver.findElement(locator);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", ele);
    }
    public void closeDriver(){
        driver.close();
    }
    public void quitDriver(){
        driver.quit();
    }
    public void CustomxpathforBrandsCheckboxes(String text){
        String xpath="//span[text()='"+text+"']/..//i";
        clickonWebelement(By.xpath(xpath));
    }

    public String clickonResultItem(String text){
        String xpath="//div[@cel_widget_id='MAIN-SEARCH_RESULTS-"+text+"']//h2//span";
        String Actualtext=getText(By.xpath(xpath));
        clickonWebelement(By.xpath(xpath));
        return Actualtext;
    }

    public  String getText(By locator){
        String text=driver.findElement(locator).getText();
        return text;
    }

    public void SwitchtoLastwindow(){
        //String parent=driver.getWindowHandle();
        ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get((int) (windows.stream().count()-1)));
       //driver.switchTo().window(parent);
    }
    public  void Switchtowindowbytitle(String title){
        Set<String> allwindows=driver.getWindowHandles();
        for(String window:allwindows){
            driver.switchTo().window(window);
            if(getTitle().equals(title)){
                break;
            }
        }
    }

    public String getTitle(){
        String title=driver.getTitle();
        return title;
    }

    public void alertshandling(String alertmethod,String text ){
        Alert alert=driver.switchTo().alert();
        switch (alertmethod)
        {
            case "accept":alert.accept();break;
            case "dismiss":alert.dismiss();break;
            case "gettext":String text1=alert.getText();System.out.println(text1);break;
            case "sendkeys":alert.sendKeys(text);break;
            default:throw new RuntimeException("methods are not avalilable");
        }

    }

    public void selectByText(By locator,String text)
    {
        WebElement ele=driver.findElement(locator);
        Select obj=new Select(ele);
        obj.selectByVisibleText(text);
        /*List<WebElement> items=obj.getOptions();
        if(items.contains("India")){
            obj.selectByVisibleText("India");
        }*/
    }

    public void selctitemfromAngulardropdown(By inputLocator,String text)
    {
        clickonWebelement(inputLocator);
        WebElement ele=driver.findElement(By.xpath("//div[text()='"+text+"']"));
        ele.click();
    }

    public void switchtoframe(By locator){
        WebElement ele=driver.findElement(locator);
        driver.switchTo().frame(ele);
    }

    public void switchtodefaultframe(){

        driver.switchTo().defaultContent();
    }

    public void menuitemsselectionusingActionclass(String menu,String submenu,String childmenu)
    {
        WebElement mainmenu=driver.findElement(By.xpath("//a[@data-group='"+menu+"']"));
        mousehover(mainmenu);
        WebElement submenus=driver.findElement(By.xpath("//div[@data-group='"+menu+"']//a[text()='"+submenu+"']/..//following-sibling::li//a[text()='"+childmenu+"']"));
        submenus.click();
    }

    public void mousehover(WebElement ele)
    {
        Actions builder=new Actions(driver);
        builder.moveToElement(ele).build().perform();
    }

    public void RightClick(WebElement ele)
    {
        Actions builder=new Actions(driver);
        builder.contextClick(ele).build().perform();
    }

    public void dragandDrop(WebElement source,WebElement target)
    {
        Actions builder=new Actions(driver);
        builder.dragAndDrop(source,target).build().perform();
    }

    public void doubleClick(WebElement ele)
    {
        Actions builder=new Actions(driver);
        builder.doubleClick(ele).build().perform();
    }
    public void TakeScreenShot(String fileName) throws IOException {
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File srcfile=screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("src/ScreenShots/"+fileName+".png");
        FileUtils.copyFile(srcfile, DestFile);
    }
}
