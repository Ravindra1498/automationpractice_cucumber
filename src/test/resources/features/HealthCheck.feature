#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@ui @healthckeck
Feature: E-commerce Project Web Site

	@UrlRedirection
	Scenario: validate web site redirected to correct url
	Given User navigated to the home page of the application url
	Then  Match the url
	
	@titleCheck
  Scenario: Validate application title is correct
    Given  User navigated to the home page of the application url
    Then Application title is "My Store"
 
  @searchFunction
  Scenario: Validate user is able to search a product from searchbox on landing page
  	Given User navigated to the home page of the application url
    When Search box is displayed
    And User search for "Dress"
    Then Search box shows result containing "Dress"  product is 5   
    
 