package testcase;

import org.testng.annotations.Test;

public class TVShows extends HotStarBaseClass{

    /*
    * This test case is used to click on TV and then from comedy tv shows click on 3rd TV comedy tv show and add it in the
     * watchlist and verify that it is present in the my watch list
    * */
    @Test
    public void STC_006(){
        homePage.navigateToPreferredMenu("TV");
        tvPage.scrollToTheElement();
        tvPage.selectTVShow();
        String actualShowTitleText=tvPage.tapOnWatchList();
        homePage.navigateToPreferredMenu("Home");
        homePage.navigateToMyWatchListPage();
        myWatchList.verifyWatchListShow(actualShowTitleText);
    }
}
