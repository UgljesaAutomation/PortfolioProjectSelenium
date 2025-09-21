package stepdefs;

import browser.Browser;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import java.time.Duration;

public class TopAnimePage {

    public WebDriverWait wait;
    public static MyAnimeList myAnimeList;
    public Actions actions;

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

}
