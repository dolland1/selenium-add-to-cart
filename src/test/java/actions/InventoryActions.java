package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.CartPage;
import stepDefinitions.BaseTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryActions {

    private final WebDriver driver;

    CartPage cartPage;
    private double highestPrice;

    public InventoryActions(BaseTest baseTest) {
        this.driver = baseTest.getDriver();
        cartPage = new CartPage(driver);
    }

    public void addHighestPricedItemToCart() {
        List<WebElement> productPrices = driver.findElements(By.className("inventory_item_price"));
        this.highestPrice = 0;
        int highestPricedItem = 0;

        for (WebElement priceElement : productPrices) {
            int index = productPrices.indexOf(priceElement);
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);

            if (price > this.highestPrice) {
                this.highestPrice = price;
                highestPricedItem = index;
            }
        }
        int highestPricedItemPosition = highestPricedItem + 1;
        driver.findElement(By.xpath("//div[@class='inventory_list']/div[" + highestPricedItemPosition + "]//button[text()='Add to cart']")).click();
    }

    public void checkItemPriceInCart() {
        String cartItemPrice = cartPage.itemPrice.getText();
        assertEquals("$" + this.highestPrice, cartItemPrice, "cart item price incorrect");
    }
}
