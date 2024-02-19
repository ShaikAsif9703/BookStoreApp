Feature: As a book reader
  I want to login into my account
  and I want to check my orders

  Scenario: checking the orders
    Given I am on Bookscape home page
    When I click on account button and click on order button
    Then I want to see the orders

  Scenario: checking the details of order
    Given I am on Bookscape home page
    When I click on account button and click on order button
    Then I can get the order details