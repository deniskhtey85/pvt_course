Feature: Test VK wall Rest API

@vkApi
Scenario: Post message to the wall
    When I sent post request to the wall
    Then Message is posted to the wall
   
Scenario: Edit message by post id
    When I edit message on the wall by post id
    Then Message is edited successfully
   
Scenario: Delete message by post id
    When I delete message from the wall by post id
    Then Message is deleted successfully