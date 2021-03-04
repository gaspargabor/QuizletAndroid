import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Util {
    public AndroidDriver<AndroidElement> createDriver() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        dc.setCapability("appPackage", "com.quizlet.quizletandroid");
        dc.setCapability("appActivity", "com.quizlet.quizletandroid.ui.RootActivity");
        dc.setCapability("noReset", "true");
        return new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
    }

    public void quit(AndroidDriver driver){
        driver.quit();
    }
}
