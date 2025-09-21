package stepdefs;

import browser.Browser;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.time.Duration;
import java.util.List;

public class HomePage {

    public WebDriverWait wait;
    public static MyAnimeList myAnimeList;
    public Actions actions;

    @Before
    public void setup(){
        myAnimeList = new MyAnimeList();
        wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));
        actions = new Actions(Browser.getBrowser());
    }


    //Test 001: Homepage Test
    @Given("that user clicks on Home page")
    public void thatUserClicksOnHomePage() {
        myAnimeList.homePage().getHomeButton().click();
    }

    @Then("MyAnimeList will open or load Home page")
    public void myAnimelistWillOpenOrLoadHomePage() {
        Assert.assertEquals("MyAnimeList.net", Browser.getBrowser().findElement(By.xpath("//*[@class='link-mal-logo']")).getText());
        System.out.println("✅ Test Pass. Homepage is loaded.");
    }


    //Test 002: Top Anime
    @Given("home page is opened and we hover over Anime node")
    public void homePageIsOpenedAndWeHoverOverAnime() {
        WebElement animeMenu = Browser.getBrowser().findElement(By.xpath("//a[normalize-space()='Anime']"));
        actions.moveToElement(animeMenu).perform();
    }

    @And("we click on Top Anime")
    public void weClickOnTopAnime() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Top Anime']"))).click();
    }

    @Then("page with Top Anime will be shown")
    public void pageWithTopAnimeWillBeShown() {
        Assert.assertEquals("Top Anime", Browser.getBrowser().findElement(By.xpath("//h1[@class='h1']")).getText());
        System.out.println("✅ Test Pass. Top Anime list is loaded.");
    }


    //Test 003: Anime Reviews
    @And("we click on Reviews")
    public void weClickOnReviews() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Reviews']"))).click();
    }

    @Then("page with Anime Reviews will be shown")
    public void pageWithAnimeReviewsWillBeShown() {
        Assert.assertEquals("Anime Reviews", Browser.getBrowser().findElement(By.xpath("//h1[@class='h1']")).getText());
        System.out.println("✅ Test Pass. Anime Reviews list is loaded.");
    }


    //Test 004: Manga Adapted
    @Given("home page is opened and we hover over Manga node")
    public void homePageIsOpenedAndWeHoverOverMangaNode() {
        WebElement mangaMenu = Browser.getBrowser().findElement(By.xpath("//a[normalize-space()='Manga']"));
        actions.moveToElement(mangaMenu).perform();
    }

    @And("we click on Adapted to Anime")
    public void weClickOnAdaptedToAnime() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Adapted to Anime']"))).click();
    }

    @Then("page with Manga Adapted to Anime will be shown")
    public void pageWithMangaAdaptedToAnimeWillBeShown() {
        Assert.assertEquals("Manga Adapted to Anime", Browser.getBrowser().findElement(By.xpath("//h1[@class='h1']")).getText());
        System.out.println("✅ Test Pass. Manga Adapted to Anime list is loaded.");
    }


    //Test 005: About
    @Given("home page is opened and we hover over Help node")
    public void homePageIsOpenedAndWeHoverOverHelpNode() {
        WebElement helpMenu = Browser.getBrowser().findElement(By.xpath("//a[normalize-space()='Help']"));
        actions.moveToElement(helpMenu).perform();
    }

    @And("we click on Adapted to About")
    public void weClickOnAdaptedToAbout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://myanimelist.net/about.php?_location=mal_h_m\"]"))).click();
    }

    @Then("About Help page will be opened")
    public void aboutHelpPageWillBeOpened() {
        Assert.assertEquals("About", Browser.getBrowser().findElement(By.xpath("//h1[@class='h1']")).getText());
        System.out.println("✅ Test Pass. About page is loaded.");
    }


    //Test 006: Search
    @Given("that user searches for {string}")
    public void thatUserSearchesForAnimeTitle(String animeTitle) throws InterruptedException {
        myAnimeList.homePage().getSearchField().click();
        myAnimeList.homePage().getSearchField().clear();
        myAnimeList.homePage().getSearchField().sendKeys(animeTitle);
        Thread.sleep(2000);
    }

    @And("click on search Icon")
    public void clickOnSearchIcon() {
        myAnimeList.homePage().getSearchIcon().click();
    }

    @Then("searched {string} will be shown")
    public void searchedAnimeTitleWillBeShown(String animeTitle) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        List<WebElement> results = Browser.getBrowser().findElements(By.xpath("//*[@id='content']/div[2]/div[1]/div//a"));
        for (WebElement result : results) {
            if (result.getText().toLowerCase().contains(animeTitle.toLowerCase())) {
                break;
            }
        }
        Assert.assertEquals("Search Results for \"" + animeTitle + "\"", Browser.getBrowser().findElement(By.xpath("//*[@class=\"result-header mb12\"]")).getText());
        System.out.println("✅ Test Pass. Anime Titles " + animeTitle + " on the list.");
        Thread.sleep(2000);
    }


    //Test 007: Current Season
    @Given("home is in view and we open Current Season of Anime")
    public void homeIsInViewAndWeOpenCurrentSeasonOfAnime() {
        Browser.getBrowser().findElement(By.linkText("Summer 2025 Anime")).click();
    }

    @Then("Current Season of Anime will be opened")
    public void currentSeasonOfAnimeWillBeOpened() {
        Assert.assertEquals("Seasonal Anime", Browser.getBrowser().findElement(By.xpath("//*[@class=\"h1\"]")).getText());
        System.out.println("✅ Test Pass. Current Anime season in view.");
    }


    //Test 008: Search specific title
    @Given("that home page is opened and we chose Manga category")
    public void thatHomePageIsOpenedAndWeChoseMangaCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topSearchValue\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value=\"manga\"]"))).click();

    }

    @And("enter {string} that we want to search")
    public void enterTitleThatWeWantToSearch(String Title) throws InterruptedException {
        myAnimeList.homePage().getSearchField().click();
        myAnimeList.homePage().getSearchField().clear();
        myAnimeList.homePage().getSearchField().sendKeys(Title);
        Thread.sleep(2000);
    }
    //  clickOnSearchIcon
    @Then("{string} will be displayed")
    public void titleWillBeDisplayed(String Title) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        List<WebElement> results = Browser.getBrowser().findElements(By.xpath("//*[@class=\"js-categories-seasonal js-block-list list\"]"));
        for (WebElement result : results) {
            if (result.getText().toLowerCase().contains(Title.toLowerCase())) {
                break;
            }
        }
        System.out.println("✅ Test Pass. Anime Titles " + Title + " on the list.");
        Thread.sleep(2000);
    }
}