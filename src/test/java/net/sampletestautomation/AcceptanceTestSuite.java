package net.sampletestautomation;


import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;

import net.sampletestautomation.appium.AppiumServer;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class AcceptanceTestSuite extends SerenityStories {

	
    @Managed(uniqueSession = false)
    public WebDriver webdriver;

    @BeforeStory
    public void beforeStory() {

    	 System.out.println("--- Before Story Ends---");
    }
        
    
    @BeforeStories
    public void startAppium() {
        AppiumServer.stopAppiumServer();
        AppiumServer.startAppiumServer();
    }

    @AfterStory
    public void afterStory() {
    	System.out.println("--- After Story Ends---");
    }
    
    @AfterStories
    public static void stopAppium() {
        AppiumServer.stopAppiumServer();
    }
    
  
        
}
