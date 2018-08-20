package pageobjects.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcase.HotStarBaseClass;
import utils.ReadElements;
import utils.ReadExcel;

import java.util.List;

public class TVPageImpl extends HotStarBaseClass{
    WebDriver driver;
    JavascriptExecutor js;
    List<WebElement> list;

    public TVPageImpl(WebDriver driver){
        this.driver=driver;
    }

    public void scrollToTheElement(){
        webDriverWait(10000);
      //  boolean isDisplayed =driver.findElement(By.xpath(readElements.getProperties("ComedyTVShow"))).isDisplayed();
        //System.out.println(isDisplayed);
        for(int i=0;i<=3;i++){
            if(!driver.findElement(By.xpath("//*[contains(text(),'Popular in Comedy')]")).isDisplayed()){
                js= (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,300)");
            }else {
                driver.findElement(By.xpath("//*[contains(text(),'Popular in Comedy')]")).click();
                System.out.println("Comedy tv shows is clicked");
                break;
            }
        }

    }

    /*
   * This method is used to select the TV show
   * */
    public void selectTVShow(){
        list=driver.findElements(By.xpath(readElements.getProperties("TVShowsList")));
        if(!list.isEmpty()){
            list.get(3).click();
        }else{
            System.out.println("List is Empty");
        }
    }

    /*
    * This method is used to click on the WatchList Icon
    * */
    public String tapOnWatchList(){
        String title=null;
        if(driver.findElement(By.xpath(readElements.getProperties("WatchListIcon"))).isDisplayed())   {
            System.out.println("WatchList icon is present");
            title=driver.findElement(By.xpath(readElements.getProperties("WatchListAddedShowTitle"))).getText();
            driver.findElement(By.xpath(readElements.getProperties("WatchListIcon"))).click();
            System.out.println("Element is clicked");
        }else{
            System.out.println("Element is not present");
        }
        return title;
    }

}
