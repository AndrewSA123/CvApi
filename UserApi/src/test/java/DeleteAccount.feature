Feature:
	As a user
	I want to delete my user account 
	So that I am no longer in DB

Scenario:
	Given I am on the userpage
	When I delete my user account
	And click submit
	Then I should be successfully removed from the DB