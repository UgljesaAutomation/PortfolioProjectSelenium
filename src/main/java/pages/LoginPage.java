package pages;

import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private String _userName = "//input[@id='loginUserName']";
    private String _password = "//input[@id='login-password']";
    private String _logInButton = "//input[@value='Login']";
    private String _stayLoggedinButton = "//input[@name='cookie']";

    public WebElement getUserName(){
        return findElementXpath(_userName);
    }

    public WebElement getPassword(){
        return findElementXpath(_password);
    }

    public WebElement getLogInButton(){
        return findElementXpath(_logInButton);
    }

    public WebElement getStayLoggedinButton(){
        return findElementXpath(_stayLoggedinButton);
    }


}
