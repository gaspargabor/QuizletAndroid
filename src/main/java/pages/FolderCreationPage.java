package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FolderCreationPage {

    private AndroidDriver driver;
    WebDriverWait wait;

    public FolderCreationPage(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayou" +
            "t/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Line" +
            "arLayout/android.widget.RelativeLayout[1]/android.widget.EditText")
    AndroidElement folderName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayo" +
            "ut/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Li" +
            "nearLayout/android.widget.RelativeLayout[2]/android.widget.EditText")
    AndroidElement folderDescription;

    @AndroidFindBy(id = "com.quizlet.quizletandroid:id/qalert_positive_button")
    AndroidElement okBtn;

    private void setFolderName(){
        wait.until(ExpectedConditions.elementToBeClickable(folderName)).sendKeys("TestFolder");
    }

    private void setFolderDescription(){
        folderDescription.sendKeys("TestFolderDescription");
    }

    private void clickOKBtn(){
        okBtn.click();
    }

    public void fillFolderCreation(){
        setFolderName();
        setFolderDescription();
        clickOKBtn();
    }


}
