Feature: Register Flow Feature Test Suite


  Scenario: Access the Account Page after successful registration
    Given Home Page is accessed
    And RegisterPage is accessed from HomePage menu
    When the registration form is completed with valid random data
    And the privacyToggle is enabled
    And continueButton is clicked
    Then the new url contains "success" keyword


    Scenario: User remains on Register Page when some mandatory fields are not empty
      Given Home Page is accessed
      And RegisterPage is accessed from HomePage menu
      When the registration form is completed with valid random data
      And the privacyToggle is enabled
      Then the new url contains "register" keyword
