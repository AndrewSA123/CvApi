Feature:
	As a user
	I want to login to my account
	So that I can access my userpage

Scenario:
	Given I am on the homepage
	When I enter my login details 
	And click submit
	Then I should be on the userpage