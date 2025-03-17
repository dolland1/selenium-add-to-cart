Feature: Login

  @test
  Scenario: Login
    Given I am on the login page
    When I login
    Then the inventory page is displayed