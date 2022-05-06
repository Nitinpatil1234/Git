Feature: Test the Login Functionality of OrangeHRM using datatable

  Scenario: Validate Login Function using datatable
    Given user on login page
    When user enter credentails using datatable
      | admin | admin123 |
    And click on login button
    Then login should land on home page
