package pages;

import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage{

    private String _updateSettings = "//input[@value='Update Settings']";
    private String _panel = "//a[normalize-space()='Panel']";
    private String _restoreDefault = "//input[@value='Reset to default']";


    public WebElement getUpdateSettings(){
        return findElementXpath(_updateSettings);
    }

    public WebElement getPanel(){
        return findElementXpath(_panel);
    }

    public WebElement getRestoreDefault(){
        return findElementXpath(_restoreDefault);
    }
}
