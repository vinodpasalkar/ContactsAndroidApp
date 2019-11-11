package net.sampletestautomation.pages.mobilePage;

import com.google.common.base.Predicate;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.sampletestautomation.appium.AppiumProperties;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobilePageObject extends PageObject {
    //https://github.com/ricardorlg/serenityappiumbug/issues/1
    //WhenUsingCustomLogicForElementsInit.java, PageObject.java


	//Added this to use drive in this base class
	private final WebDriver driver = ((WebDriverFacade)getDriver()).getProxiedDriver();


	WebDriverWait webDriverwait = new WebDriverWait(driver, 10);
	
	public MobilePageObject(WebDriver driver) {
        super(driver, new Predicate<PageObject>() {
            @Override
            public boolean apply(PageObject page) {

                PageFactory
                        .initElements(new AppiumFieldDecorator(((WebDriverFacade) page.getDriver()).getProxiedDriver()), page);
                return true;
            }

        });

    }

}
