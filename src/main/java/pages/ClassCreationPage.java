package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassCreationPage {

    private AndroidDriver driver;
    WebDriverWait wait;

    public ClassCreationPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "CLASS TITLE")
    AndroidElement classTitle;

    @AndroidFindBy(accessibility = "DESCRIPTION")
    AndroidElement classDescription;

    private void addTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(classTitle)).sendKeys("CodeCool Demo Class");
    }

    private void addDescription(){
        classDescription.sendKeys("CodeCool Demo Class Description");
    }

    public void fillFields(){
        addTitle();
        addDescription();
    }

}
