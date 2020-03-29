Feature: Shopping

  Scenario: Make purchase by "Check payments" changing Quantity, and check Orders
    Given Open Chrome and go to home page
    And Click Shop link
    When Add 3 book to cart
    And Click on Basket
    And Set quantity for 1 -st product equals to "5" and update order
    And Click Proceed to checkout button
    And Fill billing details as new user
    And Select "Check payments" option as payment type
    And Click Place order button
    Then Message "Thank you. Your order has been received." is displayed
    And Payment method "Check payments" is displayed in Order Details
    And Close browser