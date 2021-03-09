package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudySetCreatingPage {

    private AndroidDriver driver;
    WebDriverWait wait;

    public StudySetCreatingPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "TITLE")
    AndroidElement titleField;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc=\"TERM\"])[1]")
    AndroidElement firstTerm;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc=\"DEFINITION\"])[1]")
    AndroidElement firstDefinition;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc=\"TERM\"])[2]")
    AndroidElement secondTerm;

    @AndroidFindBy(xpath = "(//android.widget.EditText[@content-desc=\"DEFINITION\"])[2]\n")
    AndroidElement secondDefinition;

    @AndroidFindBy(accessibility = "Done")
    AndroidElement doneBtn;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/qalert_positive_button")
    AndroidElement popupAccept;

    @AndroidFindBy(accessibility = "Done")
    AndroidElement confirmBtn;

    public void fillTitleField() {
        wait.until(ExpectedConditions.elementToBeClickable(titleField)).sendKeys("gyümölcsök");
    }

    public void fillFirstTerm() {
        firstTerm.sendKeys("alma");
    }

    public void fillFirstDefinition() {
        firstDefinition.sendKeys("apple");
    }

    public void fillSecondTerm() {
        secondTerm.sendKeys("mangó");
    }

    public void fillSecondDefinition() {
        secondDefinition.sendKeys("mango");
    }

    public void acceptPopup() {
        popupAccept.click();
    }

    public void clickDone() {
        doneBtn.click();
    }

    public void clickConfirm(){
        confirmBtn.click();
    }

    public void fillFields() {
        fillTitleField();
        fillFirstTerm();
        fillFirstDefinition();
        fillSecondTerm();
        fillSecondDefinition();
        clickDone();
        acceptPopup();
    }


}
