import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import pages.HomePage;
import pages.StudySetCreatingPage;

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
        Thread.sleep(5000);
        studySetCreatingPage.fillFields();
        Thread.sleep(3000);

    }
}
