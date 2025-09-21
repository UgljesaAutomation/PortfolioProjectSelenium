Feature: Top Anime

  @TopAnimeNext50
  Scenario: Test 001: List from 50 to 100
    Given home page is opened and we hover over Anime node
    And   we click on Top Anime
    And   we click on next fifty
    Then  we will gen list from place fifty one and upwards


  @TopAiring
  Scenario: Test 002: Top Airing Anime
    Given home page is opened and we hover over Anime node
    And   we click on Top Anime
    And   we click on Top Airing
    Then  Top Airing anime list will be in view

  @ListOfFirst50TopAllAnime
  Scenario: Test 03: Make the list of first 50 Top All Anime
    Given home page is opened and we hover over Anime node
    And   we click on Top Anime
    When  list of fifty first Anime titles is listed
    Then  print the list of fifty Top Anime


  @ListOfFirst50TopAiringAnime
  Scenario: Test 04: Make the list of first 50 Top Airing Anime
    Given home page is opened and we hover over Anime node
    And   we click on Top Anime
    And   we click on Top Airing
    When  list of fifty first Anime titles is listed
    Then  print the list of fifty Top Airing Anime

  @ListOfFirst50MostPopularAnime
  Scenario: Test 05: Make the list of first 50 Most Popular Anime
    Given home page is opened and we hover over Anime node
    And   we click on Top Anime
    And   we click on Most Popular
    When  list of fifty first Anime titles is listed
    Then  print the list of fifty Most Popular Anime