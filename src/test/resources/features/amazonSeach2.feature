@Chrome
Feature: Validate Parallel run

  Background: user launches webpage
    Given amazon webpage is launched in "chrome"

  @RegressionFlow
Scenario Outline: Search for a product and validate results
  When user enters a "<product>" name
  And clicks on search button
  Then search results should be displayed

  Examples:
    |product|
    |something|