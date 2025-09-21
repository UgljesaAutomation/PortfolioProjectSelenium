package pages;

import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    private String _homeButton = "//*[@class='link-mal-logo']";
    private String _loginButtonHomePage = "//*[@onclick=\"ga_notlogin()\"]";
    private String _searchField = "//*[@id=\"topSearchText\"]";
    private String _searchIcon = "//*[@id=\"topSearchButon\"]";
    private String _hideAds = "//*[@data-ga-impression-type=\"hide-ads\"]";
    private String _iosApp = "//*[@alt=\"App Store\"]";
    private String _androidApp = "//img[@alt=\"Google Play\"]";
    private String _panelSettings = "//a[@class='header-right']";


    public WebElement getHomeButton(){
        return findElementXpath(_homeButton);
    }

    public WebElement getLoginButton(){
        return findElementXpath(_loginButtonHomePage);
    }

    public WebElement getSearchIcon(){
        return findElementXpath(_searchIcon);
    }

    public WebElement getSearchField(){
        return findElementXpath(_searchField);
    }

    public WebElement getHideAds(){
        return findElementXpath(_hideAds);
    }

    public WebElement getIosApp(){
        return findElementXpath(_iosApp);
    }

    public WebElement getAndroidApp(){
        return findElementXpath(_androidApp);
    }

    public WebElement getPanelSettings(){
        return findElementXpath(_panelSettings);
    }

}
