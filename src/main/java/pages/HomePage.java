package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private AndroidDriver driver;
    WebDriverWait wait;

    public HomePage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/bottom_nav_menu_create")
    AndroidElement plusBtn;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/create_study_set_item")
    AndroidElement createStudySetBtn;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/create_folder_item")
    AndroidElement createFolderBtn;

    @AndroidFindBy(xpath = "hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Frame" +
            "Layout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.Vie" +
            "wGroup/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGrou" +
            "p/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout/androi" +
            "d.widget.TextView")
    AndroidElement viewAllFolder;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/bottom_nav_menu_account")
    AndroidElement profileBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Frame" +
            "Layout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.View" +
            "Group/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGrou" +
            "p/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout")
    AndroidElement viewAllSet;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/bottom_nav_menu_search")
    AndroidElement searchBtn;

    public void navigateToStudySetCreation() {
        plusBtn.click();
        createStudySetBtn.click();
    }

    public void navigateToFolderCreation() {
        plusBtn.click();
        createFolderBtn.click();
    }

    public void clickViewAllFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllFolder)).click();
    }

    public void goToProfile(){
        profileBtn.click();
    }

    public void clickViewAllSets(){
        wait.until(ExpectedConditions.elementToBeClickable(viewAllSet)).click();
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }
}
