package runner.definitions;

import actions.HomePageActions;

import io.cucumber.java.en.*;
import utils.HelperClass;

public class HomePageDefinitions {
    HomePageActions objLogin = new HomePageActions();

    @Given("User is on Beymen home page")
    public void userIsOnBeymenHomePage() {
        HelperClass.openPage("https://www.beymen.com/");
    }

    @When("User clicks button of accept cookies")
    public void userClicksButtonOfAcceptCookies() {
        objLogin.click();
    }

    @And("User clicks close button")
    public void userClicksCloseButton() {
        objLogin.clickClose();
    }

    @When("User search product {string}")
    public void userSearchProduct(String inputVal) {
        objLogin.sendProct(inputVal);
    }

    @When("User search product")
    public void userSearchProduct() {
        objLogin.readAndSendProductName();
    }

    @And("User selects product")
    public void userSelectsProduct() {
        objLogin.selectProduct();
    }

    @Then("System writes information of product's")
    public void systemWritesInformationOfProductS() {
        objLogin.writeInfoTxt();
    }

    @When("User selects information product")
    public void userSelectsInformationProduct() {
        objLogin.selectInfoProduct();
    }
    @When("User clicks button of add basket")
    public void userClicksButtonOfAddBasket() {
        objLogin.clickAddBasket();
    }

    @And("User clicks button of Basket")
    public void userClicksButtonOfBasket() {
        objLogin.clickBasket();
    }

    @And("User checks prices")
    public void userChecksPrices() {
        objLogin.checkPrices();
    }

    @And("User increases product count {string}")
    public void userIncreasesProductCount(String count) {
        objLogin.increaseProduct(count);
    }

    @And("User removes product in basket")
    public void userRemovesProductInBasket() {
        objLogin.removeProducts();
    }
}
