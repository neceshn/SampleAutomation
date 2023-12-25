package utils;

import locators.HomePageLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;

public class FormHelper {
    public static WebDriver webDriver = null;
    public static Wait<WebDriver> wait = null;

    public static void click(By by) {
        FormHelper.findElement(by).click();
    }

    public static WebElement findElement(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return webDriver.findElement(by);
        } catch (Exception e) {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            var element = webDriver.findElement(by);
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            return element;
        }
    }

    public static List<WebElement> findElements(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by));
            return webDriver.findElements(by);
        } catch (Exception e) {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            var element = webDriver.findElements(by);
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            return element;
        }
    }

    public static void sendKeys(By by, String text) {
        WebElement element = FormHelper.findElement(by);
        element.sendKeys(text);
    }

    public static final void waitPage(Integer time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getElementValue(By by) {
        WebElement element = FormHelper.findElement(by);
        return element.getText();
    }

    public static String[] readTxt() {
        String words = null;
        try {
            words = IOHelper.readTxt("words.csv");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] splittedWords = words.split(";");
        return splittedWords;
    }

    public static void clearSendKeys(By by, String text) {
        WebElement element = FormHelper.findElement(by);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
    }

    public static void selectVariaton(By by) {
        int id = 1;
        wait.until(ExpectedConditions.elementToBeClickable(HomePageLocators.getSizeElement(1)));
        int maxSize = FormHelper.getChildsCount(HomePageLocators.selectVariation);
        for (int i = 1; i <=  maxSize; i++){
            By sizeElement =  HomePageLocators.getSizeElement(i);
            if(FormHelper.isEnabled(sizeElement)){
                id =i;
                break;
            }
        }
        FormHelper.click(HomePageLocators.getSizeElement(id));
    }
    public static boolean isEnabled(By by){
        WebElement element = FormHelper.findElement(by);
        String classList = element.getAttribute("class");
        if(classList.contains("disabled"))
            return false;
        return true;
    }

    private static int getChildsCount(By by) {
        return webDriver.findElements(by).size();
    }

    public static String getSelectedValue(By by) {
        Select selectValue = new Select(FormHelper.findElement(by));
        String value = selectValue.getFirstSelectedOption().getText();
        return value;
    }
    public static void selectByValue(By by, String count) {
        Select selectValue = new Select(FormHelper.findElement(by));
        selectValue.selectByValue(count);
    }
    public static String getAttribute(By by) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        String text = (String) js.executeScript("return arguments[0].value", findElement(by));
        if(text == null){
            text = (String) js.executeScript("return arguments[0].innerText",findElement(by));
        }
        return text;
    }
}

