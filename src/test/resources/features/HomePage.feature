Feature: Home Page Test

  @HomePage
  Scenario: Test 001: Homepage Test
    Given that user clicks on Home page
    Then  MyAnimeList will open or load Home page

  @TopAnime
  Scenario: Test 002: Top Anime
    Given home page is opened and we hover over Anime node
    And   we click on Top Anime
    Then  page with Top Anime will be shown

  @AnimeReviews
  Scenario: Test 003: Anime Reviews
    Given home page is opened and we hover over Anime node
    And   we click on Reviews
    Then  page with Anime Reviews will be shown

  @MangaAdapted
  Scenario: Test 004: Manga Adapted
    Given home page is opened and we hover over Manga node
    And   we click on Adapted to Anime
    Then  page with Manga Adapted to Anime will be shown

  @About
  Scenario: Test 005: About
    Given home page is opened and we hover over Help node
    And   we click on Adapted to About
    Then  About Help page will be opened

  @Search
  Scenario Outline: Test 006: Search
    Given that user searches for '<Anime Title>'
    And   click on search Icon
    Then  searched '<Anime Title>' will be shown

    Examples:
      | Anime Title   |
      | Dragon Ball   |
      | Bleach        |
      | Naruto        |
      | One Piece     |

  @SeasonAnime
  Scenario: Test 007: Current Season
    Given home is in view and we open Current Season of Anime
    Then  Current Season of Anime will be opened

  @SpecificList
  Scenario Outline: Test 008: Search specific title
    Given that home page is opened and we chose Manga category
    And   enter '<Title>' that we want to search
    And   click on search Icon
    Then  '<Title>' will be displayed

    Examples:
      | Title |
      | Dragon Ball   |
      | Bleach        |
      | Naruto        |
      | One Piece     |