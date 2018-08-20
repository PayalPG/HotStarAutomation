package pageobjects.desktop;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pageobjects.interfaces.IHomePage;
import testcase.HotStarBaseClass;
import utils.ReadElements;
import utils.ReadExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePageImpl extends HotStarBaseClass implements IHomePage {

    WebDriver driver;
    Actions actions;
    JavascriptExecutor js;
    List<WebElement> list;

    public HomePageImpl(WebDriver driver){
        this.driver=driver;
    }

    public boolean searchItem(String actualShowName) throws InterruptedException {
        boolean isSearched=true;
        boolean search=driver.findElement(By.xpath(readElements.getProperties("SearchIcon"))).isDisplayed();
        driver.findElement(By.xpath(readElements.getProperties("SearchIcon"))).isDisplayed();
        Thread.sleep(8000);
        System.out.println(search);
        driver.findElement(By.xpath("//div[@class='search']")).click();
        Thread.sleep(8000);
        boolean isDisplayed=driver.findElement(By.xpath("//input[@placeholder='Search for shows, movies, sports and TV channels']")).isDisplayed();
        System.out.println(isDisplayed);
        driver.findElement(By.xpath("//input[@placeholder='Search for shows, movies, sports and TV channels']")).sendKeys(actualShowName);
        List<WebElement> list=driver.findElements(By.xpath("//*[@class='search-wrap']"));
        list.get(0).click();
        String showTitleName=driver.findElement(By.xpath("//*[@class='toptitle clear-both']")).getText();
        Assert.assertEquals(showTitleName,actualShowName,"Searched Show is same" );
        System.out.println("Same show is searched");
        return isSearched;
    }

    public boolean login(String email,String password) throws InterruptedException {
        boolean isLogin=false;
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(readElements.getProperties("SignInText"))).click();
        driver.findElement(By.id(readElements.getProperties("Email"))).sendKeys(email);
        driver.findElement(By.id(readElements.getProperties("Password"))).sendKeys(password);
        driver.findElement(By.xpath(readElements.getProperties("SignInButton"))).click();
        Thread.sleep(2000);
        WebElement element=driver.findElement(By.xpath(readElements.getProperties("UserPicElement")));
        actions=new Actions(driver);
        actions.moveToElement(element).build().perform();
        driver.findElement(By.xpath(readElements.getProperties("MyAccount"))).click();
        Thread.sleep(5000);
        String userName=driver.findElement(By.xpath(readElements.getProperties("ProfileName"))).getText();
        if(userName==(email)){
            System.out.println("testcase passed");
            isLogin=true;
        }
        return isLogin;
    }

    /*
   * This method is used to navigate to your preferred menu item
   * */
    public void navigateToPreferredMenu(String menuName){
        driver.findElement(By.xpath(readElements.getProperties("MenuIcon"))).click();
        webDriverWait(5000);
        List<WebElement> menuItemList=driver.findElements(By.xpath(readElements.getProperties("MenuItemList")));
        System.out.println("List size="+menuItemList.size());
        for (int i=0;i<menuItemList.size();i++){
            if(menuItemList.get(i).getText().contains(menuName)){
                menuItemList.get(i).click();
                System.out.println("TV element is found");
                break;
            }
        }
        webDriverWait(5000);
    }

    /*
    * This method is used to navigate to My WatchList Page*/
    public void navigateToMyWatchListPage(){
        webDriverWait(3000);
        boolean isDisplayed=driver.findElement(By.xpath(readElements.getProperties("MyWatchList"))).isDisplayed();
        System.out.println(isDisplayed);
        for(int i=0;i<=3;i++){
            if(!isDisplayed){
                driver.findElement(By.xpath(readElements.getProperties("MyWatchList"))).click();
                break;
            }else {
                js.executeScript("window.scrollBy(0,300)");
            }
        }
    }




}
