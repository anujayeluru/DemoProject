Feature: feature to test login

  Scenario Outline: Check login is successful with valid credentials
    Given user is on login page
    When user enters "<username>" and "<password>"
    And user clicks on login button
    Then user is navigated to home page

    Examples: 
      | username              | password |
      | anujayeluru@gmail.com | anuja    |
