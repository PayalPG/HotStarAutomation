package testcase;

import org.testng.annotations.Test;
import utils.ReadExcel;

public class Login extends HotStarBaseClass{

    @Test
    public void runLogin() throws InterruptedException {
        homePage.login(readExcel.getData(0,1,0),readExcel.getData(0,2,0));
    }
}
