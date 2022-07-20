 #Author: your.email@your.domain.com
@tag
Feature: Tvpurchase
  I want to use this template for my feature file

  @tag1
  Scenario: Tvpurchase
    Given user launches flipkart application
    And user login into flipkart
    When user search tv
    And user choose the tv and doing payments
    Then user receive order confirmation message
  Scenario: tv one dimensional list
    Given user launches flipkart application
    And user login into flipkart
    When user search tv by using one dim list
      | SAMSUNG |  | redmi |  | realme |
    And user choose the mobile and doing payments
    Then user receive order confirmation message

  Scenario: mobile one dimensional map
    Given user launches flipkart application
    And user login into flipkart
    When user search tv by using one dim map
      | phone1 | SAMSUNG |
      | phone2 | redmi  |
      | phone3 | realme  |
    And user choose the tv and doing payments
    Then user receive order confirmation message
    