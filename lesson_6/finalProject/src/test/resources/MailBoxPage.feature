Feature: Test mail.ru mailbox page

  @mailboxPage
  Scenario: Move letter to spam
    Given I am an authorized user on the mail page
    When I navigate to incoming folder
    When I move letter to a spam folder
    And I navigate to the spam folder
    Then I see this letter in spam folder
    
    
  Scenario: Extract letter from spam
    Given I am an authorized user on the mail page
    When I navigate to the spam folder
    And I extract letter from spam
    And I navigate to incoming folder
    Then I see this letter in incoming folder
    
  Scenario: Mark three latters by Flag
    Given I am an authorized user on the mail page
    When I navigate to incoming folder
    When I mark latters by flag
    Then I see Latters are marked 
    
  Scenario: Remove all flags from letters
    Given I am an authorized user on the mail page
    When I navigate to incoming folder
    When I remove all flags from letters
    Then I see latters are unmarked
    
   Scenario Outline: Sent mail to the group of users
    Given I am an authorized user on the mail page
    When I sent mail to the group of users
    Then I see "<copy>" notification
    Examples:
    |copy|
    |Ваше письмо отправлено. Перейти во Входящие|