package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private AndroidDriver driver;
    WebDriverWait wait;

    public ProfilePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Night Theme\"))")
    AndroidElement nightTheme;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/user_settings_night_mode_switch")
    AndroidElement nightThemeSwitch;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    AndroidElement backArrow;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/user_settings_nightmode_text_indicator")
    AndroidElement themeStatus;

    private void clickNightTheme(){
        wait.until(ExpectedConditions.elementToBeClickable(nightTheme)).click();
    }

    private void clickThemeSwitch(){
        nightThemeSwitch.click();
    }

    private void clickBackArrow() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(backArrow)).click();
    }

    public void switchTheme() throws InterruptedException {
        clickNightTheme();
        clickThemeSwitch();
        clickBackArrow();
    }

    public boolean checkThemeStatus(){
        return themeStatus.getText().equals("On");
    }


}
