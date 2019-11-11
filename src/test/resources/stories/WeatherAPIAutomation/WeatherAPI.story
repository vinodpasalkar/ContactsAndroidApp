Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

!-- This scenario can be reused to get the past week weather and hottest day in the respective city
Scenario: Get Past week weather and calculate hottest day
Meta:
@HottestDayInCity
Given I have a weather API
When I get weather for past week for <city>
Then the hottest day for <city> was
Examples:
|city  |
|London |

!-- This scenario can be reused to see the maximum and minimum temperature for any city
Scenario: Get maximum and minimum temperature in the city
Meta:
@MaxMinTemperatureInCity
Given I have a weather API
When I get weather for <city>
Then the maximum and minimum temperature are shown for <city>
Examples:
|city  |
|Los Angeles |