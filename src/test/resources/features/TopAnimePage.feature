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