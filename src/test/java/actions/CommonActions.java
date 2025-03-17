package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.BaseTest;

import java.time.Duration;

public class CommonActions {

    private final WebDriver driver;

    public CommonActions(BaseTest baseTest) {
        this.driver = baseTest.getDriver();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void waitForVisibilityOfElementLocated(By locator, Integer seconds) {
        (new WebDriverWait(driver, Duration.ofSeconds(seconds))).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
