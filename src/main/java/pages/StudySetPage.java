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
    private AndroidDriver driver;
    WebDriverWait wait;

    public StudySetPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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


    public void dismissAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(shareBtn));
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(530, 300)).perform();
    }

    public boolean checkTitle() {
        return title.getText().equals("gyümölcsök");
    }

    public boolean checkUsername() {
        return username.getText().equals("GaborTest");
    }

    public boolean checkNumberOfTerms() {
        return numberOfTerms.getText().equals("2 terms");
    }

    public void turnCard(){
        wait.until(ExpectedConditions.elementToBeClickable(turningCard)).click();
    }

    public String getCardText(){
        return turningCard.getText();
    }

}
