package pageobjects.interfaces;

public interface IHomePage {

    boolean searchItem(String actualShowName) throws InterruptedException;
    boolean login(String email,String password) throws InterruptedException;
}
