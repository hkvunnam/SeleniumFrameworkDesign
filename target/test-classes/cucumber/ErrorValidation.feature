
@tag
Feature: ErrorValidation
  I want to use this template for my feature file



  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with UserName <userName> and password <pass>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | userName 		 | 			pass 				|
      | hk@email.com |     A@S123456789 |
