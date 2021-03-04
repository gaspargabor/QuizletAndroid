import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import pages.LoginPage;
import pages.StarterPage;

import java.net.MalformedURLException;

public class LoginTest {

    private static AndroidDriver<AndroidElement> driver;

    Util util = new Util();

    @Test
    public void simpleLogin() throws MalformedURLException, InterruptedException {
        driver = util.createDriver();
        StarterPage starterPage = new StarterPage(driver);
        //starterPage.clickSignIn();
    }
}
