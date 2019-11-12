ContactsAppTestcases

This repo consists a customized automation framework for executing the test cases on Contacts app, the framework uses Serenity BDD libraries for integrating Jbehave, REST-Assured, Selenium and Appium

Install java 
Install Maven
Install brew  or home-brew: 
Pre-requisites Installing Appium 
The below commands would install all the appium dependenices to the system

$ brew install node get node.js 
$ npm install -g appium get appium 
$ npm install wd get appium client 
$ appium & start appium 
$ node your-appium-test.js

Set up instructions :
Download and install IntelliJ Idea Community version


Clone the below repository in IntelliJ Idea : https://github.com/vinodpasalkar/testscenerio (Just clone this project in InteliJ idea community Edition and Go to Menu > Build > Build Project Once the build is completed/compiled successfully)


Ensure you have maven installed in your system - command from terminal -> brew install maven


Install below IntelliJ plugins by going to below navigation


IntelliJ Idea > Menu > IntelliJ Idea > Preferences > Plugins > Marketplace


Search below plugins one by one and install them Cucumber for java , Gherkin , Jbehave BDD Plugin , Jbehave Support 7.Ensure 'adb devices' commands works on your terminal and it gives the unique device id , please put it as value for appium.deviceName parameter in the dependecies below 


8.Check android version of your mobile device or emulator and put its value as appium.platformVersion in the dependecies below


Download the .apk from the folder structure and provide the file path as value for appium.app in the dependencies below


Running your first test 
Please update  serenity.properties file with your values .
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
appium.disableWindowAnimation = True```

Connect android device or start emulator

Execution commands
The Build is generated using Maven and The framework supports execution on 3 environments(production, beta(default), staging), the same has been configured as profile.

Go to Terminal in the bottom of the IDE and execute below command to run the test case

mvn clean verify -Dmetafilter="+scenario name"

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



