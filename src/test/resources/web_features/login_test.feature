Feature: Login

  1. Verify successful login with valid credentials
  2. Verify successful login with valid credentials and pass values
  3. Verify successful login with valid credentials using examples

  @LT1 @Smoke
  Scenario: Verify successful login with valid credentials
    Given User on landing page
    And User save credentials
    When User enter username and password
    And User click on login button
    Then User verify welcome page

  @LT2 @Regression @Bug
  Scenario: Verify successful login with valid credentials and pass values
    Given User on landing page
    When User enter "standard_user" and "secret_sauce"
    And User click on login button
    Then User verify welcome page

  @LT3 @Smoke
  Scenario: Verify successful login with valid credentials using datatable without header
    Given User on landing page
    When User enter credentials
      | performance_glitch_user | secret_sauce |
    And User click on login button
    Then User verify welcome page with username


  @LT5 @Smoke
  Scenario: Verify successful login with valid credentials using datatable with header
    Given User on landing page
    When User enter credentials using header
      | username | password | code |
      | selenium | Test@123 |1234  |
    And User click on login button
    Then User verify welcome page with username


  @LT4 @Regression
  Scenario Outline: Verify successful login with valid credentials using examples
    Given User on landing page
    When User enter "<username>" and "<password>"
    And User click on login button
    Then User verify welcome page

    Examples:
      | password     | username      |
      | secret_sauce | standard_user |
      | secret_sauce | performance_glitch_user |
      | secret_sauce | visual_user |

  @LT6 @Regression
  Scenario Outline: Verify successful login with valid credentials using examples sub tags
    Given User on landing page
    When User enter "<username>" and "<password>"
    And User click on login button
    Then User verify welcome page

    @LT6A
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

    @LT6B
    Examples:
      | password     | username                |
      | secret_sauce | performance_glitch_user |
      | secret_sauce | visual_user             |