package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudySetSettingPage {

    AndroidDriver driver;
    WebDriverWait wait;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/edit_set_details_word_lang_value")
    AndroidElement termsLanguage;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/edit_set_details_def_lang_value")
    AndroidElement definitionLanguage;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Hungarian\"))")
    AndroidElement hungarian;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"English\"))")
    AndroidElement english;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    AndroidElement backBtn;

    public StudySetSettingPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void setLanguages() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(termsLanguage)).click();
        hungarian.click();
        definitionLanguage.click();
        english.click();
        Thread.sleep(1000);
        backBtn.click();
    }
}
