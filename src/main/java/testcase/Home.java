package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageobjects.desktop.HomePageImpl;
import utils.ReadExcel;

import java.util.concurrent.TimeUnit;

public class Home extends HotStarBaseClass{

    public ReadExcel readExcel=new ReadExcel();

    /*
    * This test case is used to search the item
    * */

    @Test
    public void STC_004() throws InterruptedException {
            homePage.searchItem(readExcel.getData(0,0,0));
    }

}
