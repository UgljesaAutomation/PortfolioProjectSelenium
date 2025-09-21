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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import java.time.Duration;


public class SettingsPage {

    public WebDriverWait wait;
    public static MyAnimeList myAnimeList;
    public Actions actions;

    @Before
    public void setup(){
        myAnimeList = new MyAnimeList();
        wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));
        actions = new Actions(Browser.getBrowser());
    }



    // Test 001: Settings in View
    //  loginPageIsOpened
    //  usernameIsEntered
    //  passwordIsEntered
    //  loginButtonIsClicked
    @And("we navigate to settings")
    public void weNavigateToSettings() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='header-right']")));
        myAnimeList.homePage().getPanelSettings().click();
    }

    @Then("settings page will be in view")
    public void settingsPageWillBeInView() {
        Assert.assertEquals("Settings", Browser.getBrowser().findElement(By.xpath("//*[@class='h1']")).getText());
        System.out.println("✅ Test Pass. Settings is loaded and in view.");
    }

    // Test 002: Change and update of Settings
    //  loginPageIsOpened
    //  usernameIsEntered
    //  passwordIsEntered
    //  loginButtonIsClicked
    //  weNavigateToSettings
    @Then("we check value of Announcements")
    public void weCheckValueOfAnnouncements() {
        Select dropDown = new Select(Browser.getBrowser().findElement(By.name("announcements")));
        WebElement selectedOption = dropDown.getFirstSelectedOption();
        Assert.assertEquals("1", selectedOption.getAttribute("value"));
        System.out.println("✅ Test Pass. Value of Announcements is 1.");
    }

    @Then("restore values to Default value")
    public void restoreValuesToDefaultValue() {
        myAnimeList.settingsPage().getRestoreDefault().click();
        wait.until(ExpectedConditions.alertIsPresent());
        Browser.getBrowser().switchTo().alert().accept();
        System.out.println("Value of Announcements restored to default value.");
    }

    // Test 003: Change value of the Announcements
    //  loginPageIsOpened
    //  usernameIsEntered
    //  passwordIsEntered
    //  loginButtonIsClicked
    //  weNavigateToSettings
    @And("after that we change it to new value")
    public void afterThatWeChangeItToNewValue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='announcements']"))).click();
        WebElement dropDownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='announcements']")));
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByValue("9");
    }

    @And("update settings")
    public void updateSettings() {
        myAnimeList.settingsPage().getUpdateSettings().click();
    }

    @And("go back to Panel")
    public void goBackToPanel() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='goodresult']"), "Successfully updated panel settings."));
        myAnimeList.settingsPage().getPanel().click();
    }

    @Then("we check new value of Announcements")
    public void weCheckNewValueOfAnnouncements() {
        Select dropDown = new Select(Browser.getBrowser().findElement(By.name("announcements")));
        WebElement selectedOption = dropDown.getFirstSelectedOption();
        Assert.assertEquals("9", selectedOption.getAttribute("value"));
        System.out.println("✅ Test Pass. Value of Announcements is 9.");
    }
    //  restoreValuesToDefaultValue
}
