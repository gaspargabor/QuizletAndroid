package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private AndroidDriver driver;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/bottom_nav_menu_create")
    AndroidElement plusBtn;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/create_study_set_item")
    AndroidElement createStudySetBtn;

    public void navigateToStudySetCreation(){
        plusBtn.click();
        createStudySetBtn.click();
    }
}
