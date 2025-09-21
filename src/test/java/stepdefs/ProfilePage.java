package stepdefs;

import browser.Browser;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MyAnimeList;
import java.time.Duration;

public class ProfilePage {


    public WebDriverWait wait;
    public static MyAnimeList myAnimeList;
    public Actions actions;

    @Before
    public void setup(){
        myAnimeList = new MyAnimeList();
        wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));
        actions = new Actions(Browser.getBrowser());
    }


    //TC_001_Profile
    //  loginPageIsOpened
    //  usernameIsEntered
    //  passwordIsEntered
    //  loginButtonIsClicked
    @And("when page as loaded we click on profile")
    public void whenPageAsLoadedWeClickOnProfile() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='MyAnimeList.net']"))).click();
        myAnimeList.profilePage().getProfileList().click();
        myAnimeList.profilePage().getProfile().click();

    }

    @Then("profile will be in view")
    public void profileWillBeInView() {
        Assert.assertEquals("Cabu4's Profile", Browser.getBrowser().findElement(By.xpath("//*[@class=\"di-ib po-r\"]")).getText());
        System.out.println("✅ Test Pass. User successfully logged in and Profile in view.");
    }


    //TC_002_Friends
    //  loginPageIsOpened
    //  usernameIsEntered
    //  passwordIsEntered
    //  loginButtonIsClicked
    @And("when page is loaded we click on friends")
    public void whenPageIsLoadedWeClickOnFriends() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='MyAnimeList.net']"))).click();
        myAnimeList.profilePage().getProfileList().click();
        myAnimeList.profilePage().getFriends().click();
    }

    @Then("list of friends will be in view")
    public void listOfFriendsWillBeInView() {
        Assert.assertEquals("My Friends", Browser.getBrowser().findElement(By.xpath("//*[@class=\"h1\"]")).getText());
        System.out.println("✅ Test Pass. User successfully logged in and Friends list in view.");
    }


    //TC_003_My_Reviews
    //  loginPageIsOpened
    //  usernameIsEntered
    //  passwordIsEntered
    //  loginButtonIsClicked
    @And("when page is loaded we click on Reviews")
    public void whenPageIsLoadedWeClickOnReviews() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='MyAnimeList.net']"))).click();
        myAnimeList.profilePage().getProfileList().click();
        myAnimeList.profilePage().getMyReviews().click();
    }

    @Then("list of My Reviews will be shown")
    public void listOfMyReviewsWillBeShown() {
        Assert.assertEquals("My Reviews", Browser.getBrowser().findElement(By.xpath("//*[@class=\"h1\"]")).getText());
        System.out.println("✅ Test Pass. User successfully logged in and Profile Review list in view.");
    }


    //Test 004: Statistic of profile
    //  loginPageIsOpened
    //  usernameIsEntered
    //  passwordIsEntered
    //  loginButtonIsClicked
    //  whenPageAsLoadedWeClickOnProfile
    @And("profile is opened click on statistic")
    public void profileIsOpenedClickOnStatistic() {
        myAnimeList.profilePage().getStatistic().click();
    }

    @Then("Statistic will be in view")
    public void statisticWillBeInView() {
        Assert.assertEquals("Cabu4's Profile", Browser.getBrowser().findElement(By.xpath("//*[@class=\"di-ib po-r\"]")).getText());
        System.out.println("✅ Test Pass. Statistic of profile in view.");
    }



}
