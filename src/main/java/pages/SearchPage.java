package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private AndroidDriver driver;
    WebDriverWait wait;

    public SearchPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/inputField")
    AndroidElement searchField;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Days of the Week\"))")
    AndroidElement set;

    private void sendText(){
        wait.until(ExpectedConditions.elementToBeClickable(searchField)).sendKeys("Days of the week");
        searchField.click();
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    private void searchSet(){
        set.click();
    }

    public void getSet(){
        sendText();
        searchSet();
    }

}
