import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import pages.HomePage;
import pages.StudySetCreatingPage;
import pages.StudySetSettingPage;

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
        Thread.sleep(5000);

    }
}
