#Author: your.email@your.domain.com
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: All mobiles
    Given user launches flipkart application
    And user login into flipkart
    When user search mobile "<phones>"
      | phones  |
      | SAMSUNG |
      | iphone  |
      | realme  |
    And user choose the mobile and doing payments
    Then user receive order confirmation message

    Examples: 
      | phones  |
      | SAMSUNG |
      | iphone  |
      | realme  |
