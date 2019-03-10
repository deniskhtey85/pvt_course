Feature: Test Search page

  Scenario Outline: Search by conditions
   Given I am on main booking page
   When I execute searching for hotels in "<city>" with "<countRooms>" and "<countAdults>"
   Then I see a list of hotels that match the conditions
   Examples: 
     | city   | countRooms  | countAdults |
     | Moscow |      1      |     2       |
     | Paris  |      2      |     4       |
     | Minsk  |      2      |     6       |
     

  Scenario Outline: Test negative login page
    Given I am on main booking page
    When I execute searching for hotels in "<city>" with "<countRooms>" and "<countAdults>"
    And I execute filtering by rating
    And I go to the first hotel from the result list
    Then I see the hotel with "<rating>"
    Examples: 
            | city   | countRooms  |countAdults| rating |
            | Moscow |      1      |     2     |    9   |
            | Paris  |      2      |     4     |    9   |