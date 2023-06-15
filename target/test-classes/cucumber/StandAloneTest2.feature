
@tag
Feature: Purchase Order from ECommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Postive Test of Submiting the Order
    Given Logged in with UserName <userName> and password <pass>
    When I add the product <productName> from cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation page

    Examples: 
      | userName  	 | pass  				| productName  |
      | hk@email.com | A@s123456789 | ZARA COAT 3  |
