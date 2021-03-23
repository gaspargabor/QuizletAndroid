package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
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

    public boolean checkNumberOfSets(){
        return numberOfSets.getText().equals("0 sets");
    }

    public boolean checkCreator(){
        return creator.getText().equals("GaborTest");
    }

    public boolean checkTitle(){
        return titleOfFolder.getText().equals("TestFolder");
    }
}
