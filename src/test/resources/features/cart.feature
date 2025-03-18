Feature: Cart

  @test
  Scenario: Add highest price item to cart
    Given I am on the login page
    And I login
    When I add highest price item to cart
    Then highest price item is in the cart
