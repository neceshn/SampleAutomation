package actions;

import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.FormHelper;
import utils.General;
import utils.HelperClass;
import utils.IOHelper;
import java.io.IOException;

import static org.junit.Assert.*;

public class HomePageActions {

    public void sendProct(String inputVal) {
        FormHelper.sendKeys(HomePageLocators.searchBox, inputVal);
    }

    public void click() {
        FormHelper.click(HomePageLocators.buttonAcceptCookies);
    }

    public void clickClose() {
        FormHelper.click(HomePageLocators.buttonClose);
    }

    public void readAndSendProductName() {
        String[] productName = FormHelper.readTxt();
        FormHelper.click(HomePageLocators.inputSearchBar);
        FormHelper.sendKeys(HomePageLocators.inputProductName, productName[0]);
        FormHelper.clearSendKeys(HomePageLocators.inputProductName, productName[1]);


    }

    public void selectProduct() {
        int randProduct = (int) ((Math.random() * 49) + 1);
        By product = HomePageLocators.getProductItem(randProduct);
        HelperClass.wait.until(ExpectedConditions.elementToBeClickable(product));
        FormHelper.click(product);
        FormHelper.waitPage(1000);

    }

    public void writeInfoTxt() {
        String productName = FormHelper.getElementValue(HomePageLocators.labelProductTitle);
        String productPrice = FormHelper.getElementValue(HomePageLocators.labelPrice);
        try {
            IOHelper.writeTxt("product.txt", productName + ";" + productPrice);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void selectInfoProduct() {
        FormHelper.selectVariaton(HomePageLocators.selectVariation);
    }

    public void clickAddBasket() {
        FormHelper.click(HomePageLocators.buttonAddBasket);
    }

    public void clickBasket() {
        FormHelper.click(HomePageLocators.buttonBasket);
    }

    public void checkPrices() {

        String orPrice = General.getProductPrice();
        String newPrice = General.formatString(FormHelper.getElementValue(HomePageLocators.labelNewPrice));
        orPrice = General.formatString(orPrice.split("TL")[0] + "TL");
        String orProductName = General.getProductName();
        String productName = FormHelper.getElementValue(HomePageLocators.labelProductName);
        assertEquals(General.areStringsEqual(orPrice, newPrice),true);
        assertEquals(orProductName, productName);
    }

    public void increaseProduct(String count) {
        try {
            FormHelper.selectByValue(HomePageLocators.selectCount, count);
            String readValue = FormHelper.getSelectedValue(HomePageLocators.selectCount).split("\\s+")[0];
            assertEquals(count, readValue);
        } catch (Exception e) {
            General.findOptions(HomePageLocators.selectCount);
            FormHelper.selectByValue(HomePageLocators.selectCount, "1");
            String readValue = FormHelper.getSelectedValue(HomePageLocators.selectCount).split("\\s+")[0];
            assertEquals(1, readValue);
        }
    }

    public void removeProducts() {
        FormHelper.click(HomePageLocators.buttonRemove);
        FormHelper.waitPage(2000);
        String message = "SEPETİNİZDE ÜRÜN BULUNMAMAKTADIR";
        assertEquals("sepet boşaltılmadı", message, FormHelper.getAttribute(HomePageLocators.labelEmptyBasket));
    }
}
