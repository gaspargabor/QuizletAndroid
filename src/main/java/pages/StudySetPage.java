package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudySetPage {
    WebDriverWait wait;
    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/share_set_button")
    AndroidElement shareBtn;
    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/headerTitleText")
    AndroidElement title;
    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/profileUsernameList")
    AndroidElement username;
    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/setPageTermCountTextView")
    AndroidElement numberOfTerms;
    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/contentText")
    AndroidElement turningCard;
    @AndroidFindBy(accessibility = "Navigate up")
    AndroidElement backArrow;
    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/menu_more")
    AndroidElement tripleDot;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Delete set\"))")
    AndroidElement deleteSet;
    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/qalert_positive_button")
    AndroidElement confirmBtn;

    private final AndroidDriver driver;

    public StudySetPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void dismissAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(shareBtn));
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(530, 300)).perform();
    }

    public boolean checkTitle() {
        return title.getText().equals("gyümölcsök");
    }

    public String checkUsername() {
        return username.getText();
    }

    public String checkNumberOfTerms() {
        return numberOfTerms.getText();
    }

    public void turnCard() {
        wait.until(ExpectedConditions.elementToBeClickable(turningCard)).click();
    }

    public String getCardText() {
        return turningCard.getText();
    }

    public void clickBackArrow() {
        wait.until(ExpectedConditions.elementToBeClickable(backArrow)).click();
    }

    private void clickTripleDot(){
        wait.until(ExpectedConditions.elementToBeClickable(tripleDot)).click();
    }
    private void clickDelete(){
        wait.until(ExpectedConditions.elementToBeClickable(deleteSet)).click();
    }

    private void clickConfirm(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
    }
    public void deleteSet(){
        clickTripleDot();
        clickDelete();
        clickConfirm();
    }

}
