Feature:
	As a user
	I want to delete a CV
	So that the CV is no longer in DB

Scenario: 
	Given I am on the userpage 
	When I delete a CV file
	Then I should have one removed CV on the user account