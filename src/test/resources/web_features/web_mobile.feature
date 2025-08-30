Feature: MixedTest

  @MT1 @Smoke @Web @Mobile
  Scenario: Verify successful login with valid credentials
    Given User on web landing page
    Given User on mobile landing page