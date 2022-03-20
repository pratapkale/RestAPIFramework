Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline:: Verify if place is being Successfully added using AddPlaceAPI
	Given Add Place Payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "Post" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP" 
	And verify place_Id created maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name	|language	|address		   |
	|AAhouse|English	|World cross center|
#	|BBhouse|Spanish	|Sea cross center  |

@DeletePlace @Regression
Scenario: Verify if Delete place functionality is working
	Given Delete Place Payload
	When user calls "deletePlaceAPI" with "Post" http request
	Then the API call is success with status code 200
	And "status" in response body is "OK"