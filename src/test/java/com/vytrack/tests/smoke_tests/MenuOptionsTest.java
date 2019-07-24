package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.Library;
import com.vytrack.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {

    WebDriver driver;
    String driverUserName = "user165";
    String storeManagerUserName = "storemanager99";
    String password = "UserUser123";
    String tabsXpath = "//span[@class='title title-level-1']";
    String modulesXpath = "//span[@class='title title-level-2']";

    @BeforeClass
    public void beforeClass(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

    }
    @BeforeMethod
    public void beforeMethod(){
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(){
        Library.sleep(2);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test////TestCase Driver accessibility verification test
    public  void verifyVehiclesPageName(){
        driver.findElement(By.id("prependedInput")).sendKeys(driverUserName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);

        Library.sleep(3);
        List<WebElement> fleetManagementTabs = driver.findElements(By.xpath(tabsXpath));
        List<WebElement> fleetModules = driver.findElements(By.xpath(modulesXpath));
        fleetManagementTabs.get(0).click();
        fleetModules.get(0).click();

        String expectedPageName = "All Cars";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);
    }

    @Test
    public void verifyVehiclesTitle(){
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    @Test
    public void verifyAccountsPageName(){

        List<WebElement> fleeManagementTabs = driver.findElements(By.xpath(tabsXpath));
        List<WebElement> fleetModules = driver.findElements(By.xpath(modulesXpath));
        fleeManagementTabs.get(1).click();
        fleetModules.get(7).click();
        Library.sleep(3);
        String expectedPageName = "Accounts";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);

    }

    @Test
    public void verifyAccountsTitle(){
        String expectedTitle = "Accounts - Customers";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void verifyContactsPageName(){

        List<WebElement> fleetManagementTabs = driver.findElements(By.xpath(tabsXpath));
        List<WebElement> fleetModules = driver.findElements(By.xpath(modulesXpath));
        fleetManagementTabs.get(1).click();
        fleetModules.get(8).click();
        Library.sleep(3);
        String expectedPageName = "Contacts";
        String actualPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);

    } @Test
    public void verifyCalendarEventsPageNameAndTitle(){
        Library.sleep(3);
        List<WebElement> fleetManagementTabs = driver.findElements(By.xpath(tabsXpath));
        List<WebElement> fleetModules = driver.findElements(By.xpath(modulesXpath));
        fleetManagementTabs.get(2).click();
        fleetModules.get(9).click();
        String expectedPageName="Calendar Events";
        String actualPageName=driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);

        Library.sleep(3);
        String expectedTitle = "Calendar Events - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }
    //TestCase StoreManager accessibility verification test
    @Test
    public void MenuOptionsStoreManagerVerifyTest1() {
        //login as storemanager
        driver.findElement(By.id("prependedInput")).sendKeys(storeManagerUserName);
        driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
        //Dashboard verifying title & page
        String expectedTitle = "Dashboard-Dashboards";
        String actualtitle = driver.getTitle();
        String expectedDashboadPageName = "Dashboard";
        String actualDashboadPagename = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedTitle, actualtitle);
        Assert.assertEquals(expectedDashboadPageName, actualDashboadPagename);
    }
        //FleetTab-Vehicle title & page
        @Test
        public void MenuOptionsStoreManagerVerifyTest2() {
            //login as storemanager
            driver.findElement(By.id("prependedInput")).sendKeys(storeManagerUserName);
            driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
            List<WebElement> fleetManagementTabs = driver.findElements(By.xpath(tabsXpath));
            List<WebElement> fleetModules = driver.findElements(By.xpath(modulesXpath));
            fleetManagementTabs.get(1).click();
            fleetModules.get(2).click();
            Library.sleep(3);
            String expectedTitle = "Car - Entities - System - Car - Entities - System";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle);
            String expectedVehiclePageName = "All Cars";
            String actualVehiclePageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
            Assert.assertEquals(actualVehiclePageName, expectedVehiclePageName);
        }
        //Customer & Accounts title and page verifying
        @Test
        public void MenuOptionsStoreManagerVerifyTest3(){
            //login as storemanager
            SeleniumUtils.waitPlease(3);
            driver.findElement(By.id("prependedInput")).sendKeys(storeManagerUserName);
            driver.findElement(By.id("prependedInput2")).sendKeys(password, Keys.ENTER);
            SeleniumUtils.waitPlease(3);

            List<WebElement> fleetManagementTabs = driver.findElements(By.xpath(tabsXpath));
            List<WebElement> fleetModules = driver.findElements(By.xpath(modulesXpath));
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modulesXpath)));
            fleetManagementTabs.get(2).click();

        fleetModules.get(6).click();
        Library.sleep(3);
        String expectedAccountsTitle = "All-Accounts-Customers";

        String actualAccountsTitle =driver.getTitle();
        String expectedAccountsPageName="All Accounts";
            SeleniumUtils.waitPlease(3);
        String actualAccountsPageName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        System.out.println(driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText());
            SeleniumUtils.waitPlease(3);

        Assert.assertEquals(actualAccountsPageName,expectedAccountsPageName);
        Assert.assertEquals(actualAccountsTitle,expectedAccountsTitle);






    }









}
