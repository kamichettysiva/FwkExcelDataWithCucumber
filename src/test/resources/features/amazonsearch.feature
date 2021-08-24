Feature: Validate search functionality

  @SanityFlow
  Scenario Outline: Search for a product and validate results
    Given amazon webpage is launched
    When user enters a "<product>" name
    And clicks on search button
    Then search results should be displayed

    Examples:
    |product|
    |something|

  @RegressionFlow
  Scenario: Search for a product and validate results 2
    Given amazon webpage is launched
    When user enters a "product" name
    And clicks on search button
    Then search results should be displayed



