# ContactsAppTestcases

This repo consists a customized automation framework for executing the test cases on Contacts app, the framework uses Serenity BDD libraries for integrating Jbehave, REST-Assured, Selenium and Appium

Pre-requisites
Installing Appium
The below commands would install all the appium dependenices to the system

$ brew install node       get node.js
$ npm install -g appium   get appium
$ npm install wd          get appium client
$ appium &                start appium
$ node your-appium-test.js

Running your first test
The platform details can be updated in serenity.properties file.

Android dependencies
appium.automationName=uiautomator2
appium.platformName = Android
appium.platformVersion = 9
appium.deviceName  = 8ABY0HF2V
appium.app =  /Users/vinod.pasalkar/Downloads/app-debug(1).apk
appium.appActivity = com.donato.contactsapp.ui.list.view.ContactListActivity
appium.appPackage = com.donato.contactsapp
appium.noReset = True
appium.newCommandTimeout = 6000
appium.waitForQuiescence = false
appium.useNewWDA = true
appium.disableWindowAnimation = True



Initial commit for first test case 
Just clone this project in InteliJ idea community Edition
and Go to Menu > Build > Build Project
Once the build is completed/compiled successfully

Execution commands
The Build is generated using Maven and The framework supports execution on 3 environments(production, beta(default), staging), the same has been configured as profile.

Go to Terminal in the bottom of the IDE and execute below command to run the test case

mvn clean verify -Dmetafilter="+scenarios name"

For e.g. 
In our framework to execute the DenyPermissionScenario for ContactsApp
Execute below command
 
mvn clean verify -Dmetafilter="+DenyPermissionScenario"
  
  
Meta filtering the stories/scenario
mvn clean verify -Dmetafilter="+SmokeTest" -- This command will run the scenarios with the tag, "SmokeTest"
This way we can use this on CI-CD by tagging the test case under the different tags like regression , smoke , sanity etc...


  
To see the Results after execution
  
Go to  /ContactsApp testcases/Reports/Today's date time For E.g the folder name will be "report - 09-11-2019_16-06-36"
Every time you run a scenario or scenarios , it will generate the report folder with current date and time
  
Open index.html file in any browser to see the results.
  
I have used serenity framework here.

Serenity documentation
Below can be referred for a further reading on serenity libraries http://thucydides.info/docs/serenity-staging/