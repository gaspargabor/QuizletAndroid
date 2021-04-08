package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewAllSetPage {
    private AndroidDriver driver;
    WebDriverWait wait;

    public ViewAllSetPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Spanish, Spanish Basics\"))")
    AndroidElement spanishSet;

    public void clickSpanishSet(){
        spanishSet.click();
    }


}
