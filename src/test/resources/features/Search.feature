@Search
Feature: Verify search functionality

  Background: Preconditions
    Given User Opens "Chrome" and the website "https://www.noon.com/egypt-en/"

  @SearchUsingKeyword
  Scenario Outline: User search for a product using keyword
    When User searches for a product like "<Product Name>"
    Then The search result page is displayed
    And The keyword "<Product Name>" appears in the search results bar

    Examples:
      | Product Name |
      | iPhone       |
      | Macbook      |
      | Apple Watch  |

  @SearchUsingPartialKeyword
  Scenario: User search for a product using a partial keyword (As-you-type search suggestions)
    When User types a partial keyword like "Lap"
    Then The Search suggestions is displayed dynamically with matching products for "Lap"

  @SearchUsingOneFilter
  Scenario: User Search for products using one filter
    When User searches for a product like "Laptop"
    And User enter the price range as "60000" to "100000" in price filter
    Then The search result page is updated dynamically
    And The keyword "Laptop" appears in the search results bar
    And  All the results' prices are between "60000" and "100000"

  @SearchUsingCombinedFilter
  Scenario: User Search for products using combined filters
    When User searches for a product like "Laptop"
    And User enter the price range as "60000" to "100000" in price filter
    And User selects "Apple" from the Brand filter
    Then The search result page is updated dynamically
    And All the results' prices are between "60000" and "100000"
    And All the results' names are related to "Apple"