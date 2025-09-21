package pages;

import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    private String _profileList = "//a[@class=\"header-profile-link\"]";
    private String _profile     = "//a[@href='https://myanimelist.net/profile/Cabu4' and text()='Profile']";
    private String _friends     = "//a[@href=\"https://myanimelist.net/myfriends.php\" and text()='Friends']";
    private String _myReviews   = "//a[@href=\"https://myanimelist.net/myreviews.php\" and text()='Reviews']";
    private String _statistic   = "//*[@class=\"icon-statistics link\"]";


    public WebElement getProfileList(){
        return findElementXpath(_profileList);
    }
    public WebElement getProfile(){
        return findElementXpath(_profile);
    }

    public WebElement getFriends(){
        return findElementXpath(_friends);
    }
    public WebElement getMyReviews(){
        return findElementXpath(_myReviews);
    }

    public WebElement getStatistic(){
        return findElementXpath(_statistic);
    }
}