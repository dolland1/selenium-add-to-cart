package stepDefinitions;

import actions.CommonActions;
import actions.InventoryActions;
import io.cucumber.java.en.When;

public class InventorySteps {

    InventoryActions inventoryActions;
    CommonActions commonActions;

    public InventorySteps(InventoryActions inventoryActions, CommonActions commonActions) {
        this.inventoryActions = inventoryActions;
        this.commonActions = commonActions;
    }

    @When("I add highest price item to cart")
    public void i_add_highest_price_item_to_cart() {
        inventoryActions.addHighestPricedItemToCart();
    }

    @When("highest price item is in the cart")
    public void highest_price_item_is_in_the_cart() {
        commonActions.goToUrl("https://www.saucedemo.com/cart.html");
        inventoryActions.checkItemPriceInCart();
    }
}
