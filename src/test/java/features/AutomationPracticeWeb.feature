Feature: Login to AutomationPractice website order T-shirt and update First Name
  As a user
  I want to order T-shirt and update my first name
  So that I can verify my order and first name updated


  Background:
    Given I navigate to AutomationPractice website
    When I login with "tautomation15@gmail.com" and "Password01!"

  Scenario: Navigate to AutomationPractice web store
    When I navigate to Tshirt page
    And I add tshirt to cart
    Then I verify item exist in order history


  Scenario Outline: Login to AutomationPractice website and update personal information
    When I click on my personal information button
    And I update my "<firstName>" in my account with same "Password01"
    Then I verify "<firstName>" field is updated

    Examples:
      | firstName|
      | Smith    |
