Feature: Video interaction and panic action

  @Android
  Scenario: Like/unlike a video, send a chat message, and perform panic drag-drop
    Given I am logged into the application
    When I like or unlike the video
    And I navigate to the chats screen
    And I enter the message "Hello StoneCircle" in the chat box
    Then I should see the message "Hello StoneCircle" displayed in the chat
    When I tap on the panic option
    And I drag and drop the panic icon onto the available panic target
    Then the panic action should be successfully triggered
