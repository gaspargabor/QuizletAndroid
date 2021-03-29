import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import pages.HomePage;
import pages.ProfilePage;

import java.net.MalformedURLException;

public class Settings {

    private static AndroidDriver<AndroidElement> driver;

    Util util = new Util();

    @Test
    public void enableNightTheme() throws MalformedURLException, InterruptedException {
        driver = util.createDriver();
        HomePage homePage = new HomePage(driver);
        homePage.goToProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.switchTheme();
    }
}
