Feature: Log in web site

  Background:
    Given User is on Beymen home page
    When  User clicks button of accept cookies
    And   User clicks close button

  Scenario Outline: User Log In Successful
    When User search product
    And  User selects product
    Then System writes information of product's
    When User selects information product
    And  User clicks button of add basket
    And  User clicks button of Basket
    And  User checks prices
    And   User increases product count "<count>"
And User removes product in basket
  Examples:
  | count |
  | 2     |
