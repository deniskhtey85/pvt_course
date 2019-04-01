Feature: Test VK wall Rest API

@vkApi
Scenario: Post message to the wall via /method/wall.post
    When I sent post request to the wall
    Then Message is posted to the wall
   
Scenario: Edit message by post id via /method/wall.edit 
    When I edit message on the wall by post id
    Then Message is edited successfully
   
Scenario: Delete message by post id via /method/wall.delete
    When I delete message from the wall by post id
    Then Message is deleted successfully