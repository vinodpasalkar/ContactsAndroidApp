Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Note : I am using an emulator device which does not have any contacts stored in it.

Scenario: User denies the permission.
!-- Permission values can be Deny/Allow
!-- Pre-requisites - To run/rerun this scenario , please ensure that the app is not installed ,script will install during the execution
Meta:
@DenyPermissionScenario
Given the contacts App is launched
When I tap <permission>
Then message is displayed accordingly for <permission>
Examples:
|permission |
|Deny       |


Scenario: User allows the permission.
!-- Permission values can be Deny/Allow
!-- Pre-requisites - To run/rerun this scenario , please ensure that the app is not installed ,script will install during the execution
Meta:
@AllowPermissionScenario
Given the contacts App is launched
When I tap <permission>
Then message is displayed accordingly for <permission>
Examples:
|permission |
|Allow      |

Scenario: User adds a new contact.
!-- This scenarios is not automated as when we tap on + button , it says coming soon ( feature not yet implemented)
Meta:
@AddNewContact
Given the contacts App is launched
When I add a new contact <Name> <Number>
Then the contact should be added successfully
Examples:
|Name  |Number        |
|Vinod | 07440449447 |

Scenario: User views a contact.
!-- This scenarios is not automated as create contact feature is not available
Meta:
@AddNewContact
Given the contacts App is launched
When I view a contact <Name>
Then the contact should be shown successfully
Examples:
|Name  |
|Vinod |

Scenario: User views a contact by scrooling to it.
!-- This scenarios is not automated as create contact feature is not available but scrolling logic is written inside the step definition
Meta:
@AddNewContact
Given the contacts App is launched
When I view a contact <Name>
Then the contact <Name> should be shown successfully
Examples:
|Name   |
|Pramod |

Scenario: User counts the total number of contacts and views them one by one.
!-- This scenarios is not automated as create contact feature is not available but scrolling logic is written inside the step definition
Meta:
@AddNewContact
Given the contacts App is launched
When I count the total number of contacts
Then I view a contact one by one

Scenario: User checks whether the contact has imgae or not
!-- This scenarios is not automated as create contact feature is not available
Meta:
@AddNewContact
Given the contacts App is launched
When I view a contact <Name>
Then I identify whether it has image or not
Examples:
|Name   |
|Pramod |









