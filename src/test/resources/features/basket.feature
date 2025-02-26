Feature: Adding to basket
  Scenario: Adding first Smartwatch from list to basket
    Given The main page is open
    And User accepts cookies
    And User opens Smartwatche
    And User chooses the first item
    When User adds the item to the basket
    Then The basket is shown with correct prices
    And The basket with 1 item is visible on the main page
