package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    public WebElement findElementXpath (String xpath){
        return Browser.getBrowser().findElement(By.xpath(xpath));
    }
}
