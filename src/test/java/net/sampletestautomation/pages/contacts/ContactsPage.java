package net.sampletestautomation.pages.contacts;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import net.sampletestautomation.appium.AppiumProperties;
import net.sampletestautomation.pages.mobilePage.MobilePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class ContactsPage extends MobilePageObject {

    private final WebDriver driver;

    public ContactsPage(WebDriver driver) {
        super(driver);
        WebDriver facade = getDriver();
        this.driver = ((WebDriverFacade) facade).getProxiedDriver();
    }

    @iOSFindBy(id = "TBD")
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowButton;

    @iOSFindBy(id = "TBD")
    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
    private WebElement denyButton;

    @iOSFindBy(id = "TBD")
    @AndroidFindBy(id = "com.donato.contactsapp:id/alertTitle")
    private WebElement denyAlertTitle;

    @iOSFindBy(id = "TBD")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"The app needs to access to your contacts to allow you seeing them here.\")]")
    private WebElement denialMessage;

    @iOSFindBy(id = "TBD")
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"ContactsApp\")]")
    private WebElement ContactsAppTitle;

    String contact = "//android.widget.TextView[contains(@text,\"name\")]";

    private WebElement contactView;

    @Step("Step {0}")
    public void generateStep(String s){
    }

    public void choosePermissionOnUI(String permissionType) {
        driver.switchTo();
        switch(permissionType.toUpperCase()){
            case "ALLOW":
                allowButton.click();
            case "DENY":
                denyButton.click();
        }

    }

    public void checkAppBehaviourForPermission(String permissionType) {
        switch(permissionType.toUpperCase()){
            case "ALLOW":
                if(ContactsAppTitle.isDisplayed()) {
                    generateStep("Contacts App is launched successfully and there is no message to check.");
                    System.out.println("Contacts App is launched successfully and there is no message to check.");
                }
                else{
                    generateStep("\"Failed to launch Contacts App.\"");
                    Assert.fail("Failed to launch Contacts App.");
                }
            case "DENY":
                if(denyAlertTitle.isDisplayed() && denialMessage.isDisplayed()) {
                    System.out.println("No Permission pop up is displayed successfully.");
                    System.out.println("Denial message is displayed successfully.");
                }
                else{
                    Assert.fail("No Permission pop up is not displayed.");
                    Assert.fail("Denial message is not displayed.");
                }
        }
    }

    public void checkLaunchedApp() {
        if(ContactsAppTitle.isDisplayed()) {
            generateStep("Contacts App is launched successfully.");
            System.out.println("Contacts App is launched successfully.");
        }
        else{
            Assert.fail("Failed to launch Contacts App.");
        }
    }

    public void viewContactOnUI(String name) {
        contact = contact.replace("name",name);
        contactView = driver.findElement(By.xpath(contact));
        if(contactView.isDisplayed()){
            System.out.println("Contact"+name+"  is visible on the screen successfully.");
        }
        else if (scrollOnScreen(name))
        {
            System.out.println("Contact"+name+"  is visible on the screen successfully.");
        }
        else{
            Assert.fail("Contact" + name + "  is not visible on the screen successfully.");
        }
    }


    public boolean scrollOnScreen(String resourceId) {
        System.out.println("Scrolling to the contact name now");
        generateStep("Scrolling to the contact name now");
        boolean flag = false;
        if(AppiumProperties.getAppiumPlatform().toUpperCase().equals("ANDROID")) {
            driver.findElements(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").instance(0))"));
            flag= true;
        }
        else{
            driver.findElements(MobileBy.IosUIAutomation("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").instance(0))"));
            flag = true;
        }
        return flag;
    }
}
