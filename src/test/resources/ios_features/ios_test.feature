Feature: Panic settings and action

  @iOS
  Scenario: Configure panic settings and trigger panic action
    Given I have opened the application
    When I navigate to the profile screen
    And I enter the panic PIN "1234"
    And I go to panic settings
    And I log out of the application
    And I log in to the application
    And I drag and drop the panic icon onto the panic target
    Then the panic action should be successfully triggered
