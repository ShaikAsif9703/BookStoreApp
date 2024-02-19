Feature: As a book reader
  I want to login into my account
  and should see the cart of my account
  and should know about the books

  Scenario: Adding books to the cart
    Given I am in the Bookscape home page
    When I click on the first book
    Then I should be able to see the books in the cart

  Scenario: Checking the items are added to the cart
    Given I am in the Bookscape home page
    When I click on the my cart
    Then I should see the items and total price

  Scenario: Removing of items from the cart
    Given I am in the Bookscape home page
    When I click on the my cart
    Then I remove the item from cart