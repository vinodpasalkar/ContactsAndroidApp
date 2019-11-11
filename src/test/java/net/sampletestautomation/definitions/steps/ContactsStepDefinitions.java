package net.sampletestautomation.definitions.steps;

import net.sampletestautomation.tests.contacts.ContactsTests;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ContactsStepDefinitions {

    @Steps
    ContactsTests contactsTests;

    @Given("the contacts App is launched")
    public void launchContactsApp(){ contactsTests.verifyAppLaunch(); }

    @When("I tap $permission")
    public void tapPermissionOption(String permission ){
        contactsTests.tapOnPermission(permission);
    }

    @When("I count the total number of contacts")
    public void countContacts( ){
        contactsTests.countContactNumbers();
    }

    @When("I view a contact $name")
    public void viewContact(String name ){
        contactsTests.viewContact(name);
    }

    @Then("message is displayed accordingly for $permission")
    public void verifyMessage(String permission){
        contactsTests.verifyAppMessage(permission);
    }

    @Then("the contact $name should be shown successfully")
    public void verifyContact(String name){
        contactsTests.viewContact(name);
    }

    @Then("I view a contact one by one")
    public void verifyContact(){
        contactsTests.viewContactInDetail();
    }
}
