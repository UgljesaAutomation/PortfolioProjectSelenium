package stepdefs;

import browser.Browser;
import io.cucumber.java.Before;
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
import java.util.Set;

public class AppsPage {

    public WebDriverWait wait;
    public static MyAnimeList myAnimeList;
    public Actions actions;

    @Before
    public void setup(){
        myAnimeList = new MyAnimeList();
        wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));
        actions = new Actions(Browser.getBrowser());
    }

    // Test 001: iOS App Store
    @Given("home page is opened and we click on App Store new tab is opened")
    public void homePageIsOpenedAndWeClickOnAppStoreNewTapIsOpened() {
        Set<String> tabsBefore = Browser.getBrowser().getWindowHandles();
        WebElement iOSAppButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"copyright\"]")));
        actions.moveToElement(iOSAppButton).perform();
        myAnimeList.homePage().getIosApp().click();
        Set<String> tabsAfter = Browser.getBrowser().getWindowHandles();
        tabsAfter.removeAll(tabsBefore);
        String newTab = tabsAfter.iterator().next();
        Browser.getBrowser().switchTo().window(newTab);
    }

    @Then("page for downloading iOS App will open")
    public void pageForDownloadingIOSAppWillOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='we-localnav__title__product']")));
        Assert.assertEquals("App Store", Browser.getBrowser().findElement(By.xpath("//span[@class='we-localnav__title__product']")).getText());
        System.out.println("✅ Test Pass. Webpage for downloading iOS App is loaded.");
    }

    //Test 002: Google Play Store
    @Given("home page is opened and we click on Google App Store new tab is opened")
    public void homePageIsOpenedAndWeClickOnGoogleAppStoreNewTabIsOpened() {
        Set<String> tabsBefore = Browser.getBrowser().getWindowHandles();
        WebElement androidAppButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"copyright\"]")));
        actions.moveToElement(androidAppButton).perform();
        myAnimeList.homePage().getAndroidApp().click();
        Set<String> tabsAfter = Browser.getBrowser().getWindowHandles();
        tabsAfter.removeAll(tabsBefore);
        String newTab = tabsAfter.iterator().next();
        Browser.getBrowser().switchTo().window(newTab);
    }

    @Then("page for downloading Google App will open")
    public void pageForDownloadingGoogleAppWillOpen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='AfwdI']")));
        Assert.assertEquals("MyAnimeList Official", Browser.getBrowser().findElement(By.xpath("//span[@itemprop='name']")).getText());
        System.out.println("✅ Test Pass. Webpage for downloading Google App is loaded.");
    }
}
