Feature: Profile Page

  @Profile
  Scenario: Test 001: Profile
    Given once login page is opened
    And username is entered
    And password is entered
    And login button is clicked
    And when page as loaded we click on profile
    Then profile will be in view

  @Friends
  Scenario: Test 002: Friends
    Given once login page is opened
    And username is entered
    And password is entered
    And login button is clicked
    And when page is loaded we click on friends
    Then list of friends will be in view

  @MyReviews
  Scenario: Test 003: My Reviews
    Given once login page is opened
    And   username is entered
    And   password is entered
    And   login button is clicked
    And   when page is loaded we click on Reviews
    Then  list of My Reviews will be shown

  @Statistic
  Scenario: Test 004: Statistic of profile
    Given once login page is opened
    And   username is entered
    And   password is entered
    And   login button is clicked
    And   when page as loaded we click on profile
    And   profile is opened click on statistic
    Then  Statistic will be in view