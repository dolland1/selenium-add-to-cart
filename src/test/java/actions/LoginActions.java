package actions;

import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import stepDefinitions.BaseTest;

public class LoginActions {

    LoginPage loginPage;

    public LoginActions(BaseTest baseTest) {
        WebDriver driver = baseTest.getDriver();
        loginPage = new LoginPage(driver);
    }

    public void login() {
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.loginButton.click();
    }
}
