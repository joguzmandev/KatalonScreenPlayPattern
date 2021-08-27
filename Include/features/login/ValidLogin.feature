Feature: Facebook Login
  I want to login to OragenHRM

  Scenario Outline: Login to OragenHRM with Valid Credentials
    Given I want to sign in to go home page
    When I type username and password with rol <rol type>
    Then I should be able to access home page

    Examples: 
      | rol type |
      | User    |
