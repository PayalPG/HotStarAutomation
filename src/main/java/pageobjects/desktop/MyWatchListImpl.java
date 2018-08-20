package pageobjects.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testcase.HotStarBaseClass;
import utils.ReadElements;

import java.util.List;

public class MyWatchListImpl extends HotStarBaseClass{

    WebDriver driver;
    JavascriptExecutor js;
    public ReadElements readElements=new ReadElements();
    List<WebElement> list;

    public MyWatchListImpl(WebDriver driver){
        this.driver=driver;
    }


    /*
  * This method is used to verify WatchList added show is present in My WatchList*/
    public void verifyWatchListShow(String actualTitleText) {
        list = driver.findElements(By.xpath(readElements.getProperties("WatchListItems")));
        webDriverWait(5000);
        for (int i = 0; i < list.size(); i++) {
            if (!list.isEmpty()) {
                list.get(i).click();
                if (driver.findElement(By.xpath(readElements.getProperties("LatestEpisodeText"))).isDisplayed()) {
                    String expectedTitleText = driver.findElement(By.xpath(readElements.getProperties("ShowTitle"))).getText();
                    Assert.assertEquals(actualTitleText, expectedTitleText);
                    System.out.println("Title name is matched");
                    break;
                } else {
                    System.out.println("Name is not matched");
                    driver.navigate().back();
                }
            } else {
                System.out.println("List  is empty ");
            }
        }
    }
}
