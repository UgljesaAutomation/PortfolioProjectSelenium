package stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import browser.Browser;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import java.time.Duration;

public class LogInPage {

    public WebDriverWait wait;
    public static MyAnimeList myAnimeList;
    public Actions actions;

    @Before
    public void setup(){
        myAnimeList = new MyAnimeList();
        wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));
        actions = new Actions(Browser.getBrowser());
    }

    //TC_001_Login_Page
    @Given("login page is loaded")
    public void loginPageIsLoaded() {
        myAnimeList.homePage().getLoginButton().click();
    }

    @Then("we will check if all login methods exist")
    public void weWillCheckIfAllLoginMethodsExist() {
        Assert.assertEquals("Google", Browser.getBrowser().findElement(By.xpath("//a[@class='icon-social-login icon-gp']")).getText());
        Assert.assertEquals("Apple", Browser.getBrowser().findElement(By.xpath("//a[@class='icon-social-login icon-ap']")).getText());
        Assert.assertEquals("Facebook", Browser.getBrowser().findElement(By.xpath("//a[@class='icon-social-login icon-fb']")).getText());
        Assert.assertEquals("X", Browser.getBrowser().findElement(By.xpath("//a[@class='icon-social-login icon-tw']")).getText());
        System.out.println("✅ Test Pass. All login methods present.");
    }


    //TC_002_Login
    @Given("once login page is opened")
    public void loginPageIsOpened() {
        myAnimeList.homePage().getLoginButton().click();
    }

    @And("username is entered")
    public void usernameIsEntered() {
        myAnimeList.loginPage().getUserName().sendKeys("Cabu4");
    }

    @And("password is entered")
    public void passwordIsEntered() {
        myAnimeList.loginPage().getPassword().sendKeys("Cabulani3306!");
    }

    @And("login button is clicked")
    public void loginButtonIsClicked() {
        myAnimeList.loginPage().getLogInButton().click();
    }

    @Then("user is Logged in")
    public void userIsLoggedIn() {
        Assert.assertEquals("MyAnimeList.net", Browser.getBrowser().findElement(By.xpath("//*[@class='link-mal-logo']")).getText());
        System.out.println("✅ Test Pass. User successfully logged in.");
    }


    //TC_003_Login_Stay_Logged_In
    //  Step loginPageIsOpened
    //  usernameIsEntered
    //  passwordIsEntered
    @And("Stay Logged In box is checked")
    public void stayLoggedInBoxIsChecked() {
        myAnimeList.loginPage().getStayLoggedinButton().click();
        myAnimeList.loginPage().getStayLoggedinButton().click();
    }
    //  loginButtonIsClicked
    //  userIsLoggedIn


    //TC_004_Login_with_Google
    //  loginPageIsLoaded
    @And("we click on Log in with Google")
    public void weClickOnLogInWithGoogle() {
        Browser.getBrowser().findElement(By.xpath("//a[@class='icon-social-login icon-gp']")).click();
    }

    @Then("Log in with Google will be presented")
    public void logInWithGoogleWillBePresented() {
        Assert.assertEquals("Sign in", Browser.getBrowser().findElement(By.xpath("//h1[@id=\"headingText\"]")).getText());
        System.out.println("✅ Test Pass. Possible to login with Google.");
    }


    //TC_004_Login_with_Apple
    //  loginPageIsLoaded
    @And("we click on Log in with Apple")
    public void weClickOnLogInWithApple() {
        Browser.getBrowser().findElement(By.xpath("//a[@class='icon-social-login icon-ap']")).click();
    }

    @Then("Log in with Apple will be presented")
    public void logInWithAppleWillBePresented() {
        Assert.assertEquals("Apple Account", Browser.getBrowser().findElement(By.xpath("//*[@class=\"ac-localnav-title\"]")).getText());
        System.out.println("✅ Test Pass. Possible to login with Apple.");
    }



    //TC_006_Login_with_Facebook
    //  loginPageIsLoaded
    @And("we click on Log in with Facebook")
    public void weClickOnLogInWithFacebook() {
        Browser.getBrowser().findElement(By.xpath("//a[@class='icon-social-login icon-fb']")).click();
    }

    @Then("Log in with Facebook will be presented")
    public void logInWithFacebookWillBePresented() {
        Assert.assertEquals("Log Into Facebook", Browser.getBrowser().findElement(By.xpath("//*[@class=\"_9axz\"]")).getText());
        System.out.println("✅ Test Pass. Possible to login with Facebook.");
    }


    //TC_007_Login_with_Twitter/X
    //  loginPageIsLoaded
    @And("we click on Log in with Twitter")
    public void weClickOnLogInWithTwitter() {
        Browser.getBrowser().findElement(By.xpath("//a[@class='icon-social-login icon-tw']")).click();
    }

    @Then("Log in with Twitter will be presented")
    public void logInWithTwitterWillBePresented() {
        Assert.assertEquals("Help Center", Browser.getBrowser().findElement(By.xpath("//*[@target=\"_blank\"]")).getText());
        System.out.println("✅ Test Pass. Possible to login with Twitter/X.");
    }

}