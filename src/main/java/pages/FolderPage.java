package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FolderPage {

    private AndroidDriver driver;
    WebDriverWait wait;

    public FolderPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/setCountLabel")
    AndroidElement numberOfSets;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/header_username_textview")
    AndroidElement creator;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/folderTitle")
    AndroidElement titleOfFolder;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/view_empty_add_sets_button")
    AndroidElement addSetBtn;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"STUDIED\"]/android.widget.TextView")
    AndroidElement studiedSets;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true))" +
            ".scrollIntoView(new UiSelector().text(\"Spanish, Spanish Basics\"))")
    AndroidElement spanishSet;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/menu_add_set_to_folder_complete")
    AndroidElement doneBtn;


    public boolean checkNumberOfSets(){
        return numberOfSets.getText().equals("0 sets");
    }

    public boolean checkCreator(){
        return creator.getText().equals("GaborTest");
    }

    public boolean checkTitle(){
        return titleOfFolder.getText().equals("TestFolder");
    }

    private void clickAddBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(addSetBtn)).click();
    }

    private void clickStudiedBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(studiedSets)).click();
    }

    private void clickSpanishSet(){
        spanishSet.click();
    }

    private void clickDoneBtn(){
        doneBtn.click();
    }

    public void addSetToFolder(){
        clickAddBtn();
        clickStudiedBtn();
        clickSpanishSet();
        clickDoneBtn();
    }
}
