Feature: Login

  
  Scenario: Successful login with valid credintials
    Given user launch chrome browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then page title should be "Dashboard / nopcommerce administration"
    When user click on logout link
    Then page title should be "Your Store. Login"
    And close browser

     Scenario Outline: login data driven
    Given user launch chrome browser
    When user open url "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then page title should be "Dashboard / nopcommerce administration"
    When user click on logout link
    Then page title should be "Your Store. Login"
    And close browser
    
    Examples:
    |email|password|
    |admin@yourstore.com|admin|
    |admin1@yourstore.com|admin123|