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
    
  @LogoDisplay
  Scenario: Validate application logo is displayed
    Given User navigated to the home page of the application url
    Then Application logo is displayed  
    
  @LogoHeight
  Scenario: Validate application logo height
    Given User navigated to the home page of the application url
    When User is on application landing page
    Then Application logo height is "99"  
    
  @LogoWidth
  Scenario: Validate application logo width
  	Given User navigated to the home page of the application url
    When User is on application landing page
    Then Application logo width is "350"  
    
  @searchFunction
  Scenario: Validate user is able to search a product from searchbox on landing page
  	Given User navigated to the home page of the application url
    When Search box is displayed
    And User search for "Dress"
    Then Search box shows result containing "Dress"  product is 5   
    
  @Facebook
  Scenario: Validate facebook social media
  	Given User navigated to the home page of the application url
  	When User clicks on  facebook link  of the bottom landing page and open new tab
    Then User able to see facebook group with name "Selenium Framework" 
   
   #@twitter
  #Scenario: Validate Tiwtter social media
  #	Given User navigated to the home page of the application url
  #	When User clicks on  twitter link  of the bottom landing page and open new tab
    #Then User able to see twitter group with name "Selenium Framework"  
      #
    #@Youtube
  #Scenario: Validate Youtube social media
  #	Given User navigated to the home page of the application url
  #	When User clicks on  Youtube link  of the bottom landing page and open new tab
    #Then User able to see Youtube group with name "Selenium Framework" 
