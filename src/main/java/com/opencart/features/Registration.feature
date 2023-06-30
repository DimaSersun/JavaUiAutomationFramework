Feature: Register Flow Feature Test Suite

  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    And continueButton is clicked
    Then the current url contains the following keyword: "account"

  Scenario: User remains on Register Page when some mandatory fields are not empty
      Given Home Page is accessed
      And RegisterPage is accessed from HomePage menu
      When the registration form is completed with valid random data
      And the privacyToggle is enabled
      Then the current url contains the following keyword: "account"

  Scenario Outline: Error messages are displayed when trying to register with invalid <attribute> date
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    And the registration form is completed with the following data:
      | firstName | <fistName> |
      | lastName  | <lastName> |
      | email     | random     |
      | password  | Random     |

    When continueButton is clicked
    Then the following error message are displayed:
    Examples:
      | Warning: You must agree to the Privacy Policy!   |
      | <attribute> must be between 1 and 32 characters! |
    Examples:
      | attribute  | firstName               | lastName                   |
      | First Name | asdsfsdfsdgrfsdfsdfasdf | random                     |
      | Last Name  | random                  | safsadasdgassfdfaefwefwfsd |


