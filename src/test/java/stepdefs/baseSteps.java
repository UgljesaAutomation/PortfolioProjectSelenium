package stepdefs;

import browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class baseSteps {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        Browser.getBrowser().get("https://myanimelist.net/");
        Browser.getBrowser().manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), Duration.ofSeconds(10));
        // Waiting for pop-up to appear so we can click on it and continue.
        WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='accept-btn']")));
        cookieButton.click();
        System.out.println("✅ We clicked on 'Agree' for cookie popup.");
    }

    @After
    public void cleanup(){
        Browser.getBrowser().manage().deleteAllCookies();
        Browser.quit();
    }

    @And("wait for {int} milliseconds")
    public void waitForMilliseconds(int arg0) throws InterruptedException {
        Thread.sleep(arg0);
    }

}