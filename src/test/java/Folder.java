import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import pages.AllFolderPage;
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
        Assert.assertEquals("0 sets",folderPage.checkNumberOfSets());
        Assert.assertTrue(folderPage.checkCreator());
        Assert.assertTrue(folderPage.checkTitle());
        util.quit(driver);
    }

    @Test
    public void addSetToFolder() throws MalformedURLException {
        driver = util.createDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickViewAllFolder();
        AllFolderPage allFolderPage = new AllFolderPage(driver);
        allFolderPage.clickFreeTimeFolder();
        FolderPage folderPage = new FolderPage(driver);
        folderPage.addSetToFolder();
        Assert.assertEquals("1 set",folderPage.checkNumberOfSets());
        util.quit(driver);
    }
}
