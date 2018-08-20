package testcase;

import org.openqa.selenium.JavascriptExecutor;
import pageobjects.desktop.HomePageImpl;
import pageobjects.desktop.MyWatchListImpl;
import pageobjects.desktop.TVPageImpl;
import utils.ReadElements;
import utils.ReadExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class HotStarBaseClass {

    static WebDriver driver;
    HomePageImpl homePage;
    TVPageImpl tvPage;
    MyWatchListImpl myWatchList;
    public ReadElements readElements=new ReadElements();;
    public ReadExcel readExcel=new ReadExcel();
    JavascriptExecutor js;

    //Launch browser
    @BeforeSuite
    public  void launchBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\setups\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.hotstar.com/");
        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    }

    @BeforeTest
    public void initializeObjects() throws IOException {
        homePage=new HomePageImpl(driver);
        tvPage=new TVPageImpl(driver);
        myWatchList=new MyWatchListImpl(driver);
    }

    @AfterSuite
    public void quitSession(){
      driver.quit();
    }


    public boolean webDriverWait(int wait){
        System.out.println("Webdriver wait, Waiting for: " + wait);
        try {
            Thread.sleep((long)wait);
            System.out.println("Wait Done");
            return true;
        } catch (InterruptedException e) {
            System.out.println("wait is finished");
            return false;
        }

    }


}
