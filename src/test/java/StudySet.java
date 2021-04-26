import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import pages.*;

import java.net.MalformedURLException;

public class StudySet {

    private static AndroidDriver<AndroidElement> driver;

    Util util = new Util();

    @Test
    public void createNewStudySet() throws MalformedURLException, InterruptedException {
        driver = util.createDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigateToStudySetCreation();
        StudySetCreatingPage studySetCreatingPage = new StudySetCreatingPage(driver);
        studySetCreatingPage.fillFields();
        StudySetSettingPage studySetSettingPage = new StudySetSettingPage(driver);
        studySetSettingPage.setLanguages();
        studySetCreatingPage.clickConfirm();
        StudySetPage studySetPage = new StudySetPage(driver);
        studySetPage.dismissAlert();
        Assert.assertTrue(studySetPage.checkTitle());
        Assert.assertEquals("GaborTest",studySetPage.checkUsername());
        Assert.assertEquals("2 terms", studySetPage.checkNumberOfTerms());
        studySetPage.clickBackArrow();
        homePage.clickViewAllSets();
        ViewAllSetPage viewAllSetPage = new ViewAllSetPage(driver);
        viewAllSetPage.clickGyumolcsokSet();
        studySetPage.deleteSet();
        util.quit(driver);
    }

    @Test
    public void cardTurningInSet() throws MalformedURLException {
        driver = util.createDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickViewAllSets();
        ViewAllSetPage viewAllSetPage = new ViewAllSetPage(driver);
        viewAllSetPage.clickSpanishSet();
        StudySetPage studySetPage = new StudySetPage(driver);
        studySetPage.turnCard();
        Assert.assertEquals("how are you?",studySetPage.getCardText());
        util.quit(driver);
    }
}
