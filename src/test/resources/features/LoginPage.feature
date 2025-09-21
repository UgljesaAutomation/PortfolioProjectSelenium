Feature: Login Page

  @LoginPage
  Scenario: Test 001: Login Page
    Given login page is loaded
    Then we will check if all login methods exist

  @Login
  Scenario: Test 002: Login
    Given once login page is opened
    And username is entered
    And password is entered
    And login button is clicked
    Then user is Logged in

  @LoginStayLoggedIn
  Scenario: Test 003: Login and stay logged in
    Given once login page is opened
    And username is entered
    And password is entered
    And Stay Logged In box is checked
    And login button is clicked
    Then user is Logged in

  @LoginWithGoogle
  Scenario: Test 004: Login with Google
    Given login page is loaded
    And we click on Log in with Google
    Then Log in with Google will be presented

  @LoginWithApple
  Scenario: Test 005: Login with Apple
    Given login page is loaded
    And we click on Log in with Apple
    Then Log in with Apple will be presented

  @LoginWithFacebook
  Scenario: Test 006: Login with Facebook
    Given login page is loaded
    And we click on Log in with Facebook
    Then Log in with Facebook will be presented

  @LoginWithTwitterX
  Scenario: Test 007: Login with Twitter/X
    Given login page is loaded
    And we click on Log in with Twitter
    Then Log in with Twitter will be presented