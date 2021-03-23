import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import pages.FolderCreationPage;
import pages.FolderPage;
import pages.HomePage;

import java.net.MalformedURLException;

public class Folder {

    private static AndroidDriver<AndroidElement> driver;

    Util util = new Util();

    @Test
    public void folderCreation() throws MalformedURLException {
        driver = util.createDriver();
        HomePage homePage = new HomePage(driver);
        homePage.navigateToFolderCreation();
        FolderCreationPage folderCreationPage = new FolderCreationPage(driver);
        folderCreationPage.fillFolderCreation();
        FolderPage folderPage = new FolderPage(driver);
        Assert.assertTrue(folderPage.checkNumberOfSets());
        Assert.assertTrue(folderPage.checkCreator());
        Assert.assertTrue(folderPage.checkTitle());
    }
}
