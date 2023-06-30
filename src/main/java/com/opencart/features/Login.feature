Feature: Login Test Suite

  Scenario Outline: The user can not login with invalid data
    Given The "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered into the login form:
      | <email>    |
      | <password> |
    When loginButton is clicked
    Then the following error message are displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | attribute | email             | password     |
      | email     | invalid@gmail.com | notimportant |
      | password  | andrei@email.com  | dfsdfsdf34df |

  Scenario Outline: A valid user is able to log into the system
    Given The "https://andreisecuqa.host/index.php?route=account/login&language=en-gb" is accessed
    And the following data is entered into the login form:
      | <email>    |
      | <password> |
    When loginButton is clicked
    Then the current url contains the following keyword: "account"
    Examples:
      | email             | password     |
      | andrei@email.com  | dfsdfsdf34df |
