Feature: Validating Place API's
@AddPlace
Scenario Outline: Vefify if place is being succesfully added using AddPlaceAPI
Given Add Place Payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "POST" http request
Then The API call got is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify  place_Id created maps to "<name>" using "getPlaceAPI"


Examples:
  |name    |language | address            |
  |AAhouse | English | World cross centre |
 |BBhouse | Spanish | Sea cross centre   |   
 |MShouse | Hindi   | Kanhur pathar      | 
 
 @DeletePlace 
  Scenario: Verify if Delete Place functionality is working
    
    Given DeletePlace Payload
    When User calls "deletePlaceAPI" with "POST" http request
    Then The API call got is success with status code 200
    And "status" in response body is "OK"