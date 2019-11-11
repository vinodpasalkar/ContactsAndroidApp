package net.sampletestautomation.tests.contacts;

import net.sampletestautomation.pages.contacts.ContactsPage;

public class ContactsTests {

    ContactsPage contactsPage;

    public void verifyAppLaunch() {
        contactsPage.checkLaunchedApp();
    }

    public void tapOnPermission(String permissionType) {
        contactsPage.choosePermissionOnUI(permissionType);
    }

    public void verifyAppMessage(String permissionType) {
        contactsPage.checkAppBehaviourForPermission(permissionType);

    }

    public void viewContact(String name) {
        contactsPage.viewContactOnUI(name);
    }
}
