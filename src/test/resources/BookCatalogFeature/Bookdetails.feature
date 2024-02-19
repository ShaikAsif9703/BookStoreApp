Feature:  As a book reader
  I want to login into my account
  and I was to search some books
  and also made some queries regarding to books

  Scenario: Searching a lot of books
    Given I am in Bookscape home page
    Then I should see some list of books

  Scenario: searching the price and author name of book
    Given I am in Bookscape home page
    When I click on a book
    Then I will get the price and author name

  Scenario:searching books through search input
    Given I am in Bookscape home page
    When I click the search button
    And I enter a book name or author name
    Then I will get the required books