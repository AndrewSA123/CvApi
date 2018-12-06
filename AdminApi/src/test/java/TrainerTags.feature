Feature:
	As a trainer 
	I want to add tags to users
	So that I can track changes that a user makes to CVs
	
Scenario:
	Given I am logged in 
	When I tag a user
	Then the user should be tagged
	
Scenario:
	Given I am logged in 
	When the user updates/adds/deletes CV
	Then the user should be tagged
	
Scenario:
	Given I am logged in 
	When a tagged user is logged in
	Then the trainer should be updated
	