Feature: Settings

  @SettingsPage
  Scenario: Test 001: Settings in View
    Given once login page is opened
    And   username is entered
    And   password is entered
    And   login button is clicked
    And   we navigate to settings
    Then  settings page will be in view

  @ValueCheck
  Scenario: Test 002: Value of the Announcements
    Given once login page is opened
    And   username is entered
    And   password is entered
    And   login button is clicked
    And   we navigate to settings
    Then  we check value of Announcements
    Then  restore values to Default value

  @SettingsChange
  Scenario: Test 003: Change value of the Announcements
    Given once login page is opened
    And   username is entered
    And   password is entered
    And   login button is clicked
    And   we navigate to settings
    And   after that we change it to new value
    And   update settings
    And   go back to Panel
    Then  we check new value of Announcements
    Then  restore values to Default value