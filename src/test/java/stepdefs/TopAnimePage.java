package stepdefs;

import browser.Browser;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TopAnimePage {

    public WebDriverWait wait;
    public static MyAnimeList myAnimeList;
    public Actions actions;
    List<String> animeList = new ArrayList<>();

    @Before
    public void setup(){
        myAnimeList = new MyAnimeList();
        wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));
        actions = new Actions(Browser.getBrowser());
    }

    // Test 001: Next 50 list
    //  homePageIsOpenedAndWeHoverOverAnim
    //  weClickOnTopAnime
    @And("we click on next fifty")
    public void weClickOnNextFifty() {
        Browser.getBrowser().findElement(By.xpath("//*[@href=\"?limit=50\"]")).click();
    }

    @Then("we will gen list from place fifty one and upwards")
    public void weWillGenListFromPlaceFiftyOneAndUpwards() {
        WebElement lastOnList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='lightLink top-anime-rank-text rank3']")));
        Assert.assertEquals("51", Browser.getBrowser().findElement(By.xpath("//*[@class=\"lightLink top-anime-rank-text rank2\"]")).getText());
        actions.moveToElement(lastOnList).perform();
        Assert.assertEquals("100", Browser.getBrowser().findElement(By.xpath("//*[@class='lightLink top-anime-rank-text rank3']")).getText());
        System.out.println("✅ Test Pass. List of all anime from 51 to 100 will be shown.");
    }

    // Test 002: Top Airing Anime
    //  homePageIsOpenedAndWeHoverOverAnim
    //  weClickOnTopAnime
    @And("we click on Top Airing")
    public void weClickOnTopAiring() {
        Browser.getBrowser().findElement(By.xpath("//*[@href=\"?type=airing\"]")).click();
    }

    @Then("Top Airing anime list will be in view")
    public void topAiringAnimeListWillBeInView() {
        Assert.assertEquals("Top Airing", Browser.getBrowser().findElement(By.xpath("//a[@href=\"?type=airing\"]")).getText());
        System.out.println("✅ Test Pass. Top Airing Anime list in view.");
    }

    //Test 03: Make the list of first 50 Anime
    //  homePageIsOpenedAndWeHoverOverAnim
    //  weClickOnTopAnime
    @When("list of fifty first Anime titles is listed")
    public void listOfFirstAnimeTitlesIsListed() {
        List<WebElement> elements = Browser.getBrowser().findElements(By.cssSelector(".ranking-list .anime_ranking_h3 a"));
        for (int i = 0; i < 50 && i < elements.size(); i++) {
            animeList.add(elements.get(i).getText());
        }
    }

    @Then("print the list of fifty Top Anime")
    public void printTheListOfTopAnime() {
        System.out.println("Top 50 Anime:");
        for (int i = 0; i < animeList.size(); i++) {
            System.out.println((i+1) + ". " + animeList.get(i));
        }
        System.out.println("✅ Test Pass. First 50 All Anime list is printed.");
    }

    //Test 04: Make the list of first 50 Top Airing Anime
    //  homePageIsOpenedAndWeHoverOverAnim
    //  weClickOnTopAnime
    //  weClickOnTopAiring
    //  listOfFirstAnimeTitlesIsListed
    @Then("print the list of fifty Top Airing Anime")
    public void printTheListOfFiftyTopAiringAnime() {
        System.out.println("Top 50 Anime:");
        for (int i = 0; i < animeList.size(); i++) {
            System.out.println((i+1) + ". " + animeList.get(i));
        }
        System.out.println("✅ Test Pass. First 50 Top Airing list is printed.");
    }
}
