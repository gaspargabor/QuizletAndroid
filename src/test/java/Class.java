import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import pages.ClassCreationPage;
import pages.FolderCreationPage;
import pages.FolderPage;
import pages.HomePage;

import java.net.MalformedURLException;

public class Class {

    private static AndroidDriver<AndroidElement> driver;

    Util util = new Util();

    @Test
    public void classCreation() throws MalformedURLException {
        driver = util.createDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigateToClassCreation();
        ClassCreationPage classCreationPage = new ClassCreationPage(driver);
        classCreationPage.fillFields();
    }
}
