package stepDefinitions;

import actions.LoginActions;
import actions.CommonActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class LoginSteps {

    LoginActions loginActions;
    CommonActions commonActions;

    public LoginSteps(LoginActions loginActions, CommonActions commonActions) {
        this.loginActions = loginActions;
        this.commonActions = commonActions;
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        commonActions.goToUrl("https://www.saucedemo.com/");
    }

    @When("I login")
    public void i_login() {
        loginActions.login();
    }

    @When("the inventory page is displayed")
    public void the_inventory_page_is_displayed() {
        commonActions.waitForVisibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack"), 5);
    }
}
