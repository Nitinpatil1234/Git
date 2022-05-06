 Feature: Test the Login Functionality of OrangeHRM
 
 Scenario Outline: Validate Login Function
 
 Given user on login page
 When user enter username and Password
 And click on login button
 Then login should land on home page
 
 Examples:
 
 |username|Password|
 |admin   |admin123|
 |admin   |admin1234|