Feature: successful Login
  As a reader of Bookscape
  I want to login into my account
  and I have some requirements to do

  Scenario: successful Login
    Given I am in the Bookscape login page
    When I entered the login details
    And I click on the sign in button
    Then I was able to login into Bookscape home page

  Scenario: first process of changing password
    Given I am in the Bookscape login page
    When I enter the required details
    Then first process of password resetted

  Scenario: second process of changing password
    Given I am in the Bookscape login page
    When I entered into home page
    And I click on the my account and settings
    Then I can change the password

