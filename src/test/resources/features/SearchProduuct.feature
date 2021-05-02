@SearchProduct
Feature: Validate user is able to add multiple products into cart

	@ProductSearch
	Scenario: User is able to search diffrent products and add each type of product in cart
	Given User navigated to the home page of the application url
	When User search following products and add into cart
	|Item             | Product Name                |Quantity|
	|Dress            | Printed Chiffon Dress 			| 1			 |
	|T-shirts         | Faded Short Sleeve T-shirts | 2			 |
	|Casual           | Printed Dress               | 3      |
	Then User cart is update with product and quantity