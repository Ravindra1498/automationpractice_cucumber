@ui @logockeck
Feature: E-commerce Project Web Site logo Check   
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
    