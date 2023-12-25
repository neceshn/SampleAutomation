package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    public static final By searchBox = By.xpath("//header/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/input[1]");

    public static final By buttonAcceptCookies = By.id("onetrust-accept-btn-handler");
    public static final By buttonClose = By.xpath("//div[@class='o-modal__container']//button");
    public static final By inputSearchBar = By.xpath("//input[@class='o-header__search--input']");
    public static final By inputProductName = By.id("o-searchSuggestion__input");
    public static final By labelProductTitle = By.xpath("//div//h1[@class='o-productDetail__title']//span");
    public static final By labelPrice = By.id("priceNew");
    public static final By buttonAddBasket = By.id("addBasket");
    public static By selectVariation = By.xpath("//body/div[3]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/span");
    public static final By buttonBasket = By.xpath("//button[contains(text(),'Sepete Git')]");
    public static final By labelNewPrice = By.xpath("//div[@class='m-orderSummary__body']//ul//li//span[2]");
    public static final By labelProductName = By.xpath("//div[@class='m-basket__optionHeader']//a/span");
    public static final By selectCount = By.xpath("//select[@id='quantitySelect0-key-0']");
    public static final By buttonRemove = By.id("removeCartItemBtn0-key-0");
    public static final By labelEmptyBasket = By.xpath("//div[@id='emtyCart']//strong");
    public static final By selectCountOption =By.xpath("//select[@id='quantitySelect0-key-0']");

    public static By getProductItem(int randProduct) {
        return By.xpath("//div[@id='productList']//div["+randProduct+"]");

    }

    public static By getSizeElement(int id) {
        return By.xpath("//body/div[3]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/span["+id+"]");
    }
}
