package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"gyümölcsök\"))")
    AndroidElement gyumolcsokSet;

    public void clickSpanishSet(){
        spanishSet.click();
    }

    public void clickGyumolcsokSet(){
        wait.until(ExpectedConditions.elementToBeClickable(gyumolcsokSet)).click();
    }

    public boolean checkDeletedSet(){
        try {
            gyumolcsokSet.isDisplayed();
            System.out.println("not working");
            return false;
        }
        catch (NoSuchElementException e){
            System.out.println("working");
            return true;
        }
    }
}
