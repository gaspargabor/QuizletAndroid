import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.SearchPage;
import pages.StudySetPage;

import java.net.MalformedURLException;

public class Search {
    private static AndroidDriver<AndroidElement> driver;

    Util util = new Util();

    @Test
    public void searchTest() throws MalformedURLException {
        driver = util.createDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickSearchBtn();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.getSet();
        StudySetPage studySetPage = new StudySetPage(driver);
        Assert.assertEquals("7 terms", studySetPage.checkNumberOfTerms());
        Assert.assertEquals("Deborah_Larrauri", studySetPage.checkUsername());
        util.quit(driver);
    }
}
