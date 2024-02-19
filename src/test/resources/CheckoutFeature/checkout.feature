Feature:  As a book reader
  I want to login into my account
  and i want to purchase a book
  and provide details about it
  Scenario:Details of purchasing item
    Given I am on the Bookscape home page
    When I add a book to cart
    Then I should see the details about total price and details

  Scenario: checking the total order value
    Given I am on the Bookscape home page
    When I add a book to cart
    Then I should see the details about total price