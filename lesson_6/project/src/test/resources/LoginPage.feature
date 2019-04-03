Feature: Test mail.ru login page

 @loginPage
  Scenario: Test login page
    Given Main application page is opened
    When Enter correct user login and password
    Then Logout link is displayed
    
    
  Scenario: Default state of saveAuth Checkbox
    Given Main application page is opened
    Then saveAuth Checkbox is selected
    
  Scenario: Default state of saveAuth Checkbox
    Given Main application page is opened
    When I click Forgot Password link
    Then I see Restore Password button