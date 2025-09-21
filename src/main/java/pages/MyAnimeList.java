package pages;

public class MyAnimeList {

    private HomePage _homePage;
    private LoginPage _loginPage;
    private ProfilePage _profilePage;
    private SettingsPage _settingsPage;


    public HomePage homePage (){
        if (_homePage == null){
            _homePage = new HomePage();
        }
        return _homePage;
    }

    public LoginPage loginPage (){
        if (_loginPage == null){
            _loginPage = new  LoginPage();
        }
        return _loginPage;
    }

    public ProfilePage profilePage(){
        if (_profilePage == null){
            _profilePage = new ProfilePage();
        }
        return _profilePage;
    }

    public SettingsPage settingsPage(){
        if (_settingsPage == null){
            _settingsPage = new SettingsPage();
        }
        return _settingsPage;
    }

}
