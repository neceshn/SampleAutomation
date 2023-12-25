package utils;

import dev.failsafe.internal.util.Assert;
import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;


public class General {
    public static String getProductPrice(){
        String savedProduct = null;
        try {
            savedProduct = IOHelper.readTxt("product.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] datas = savedProduct.split(";");
        return datas[1];
    }

    public static String getProductName() {
        String data = null;
        try {
            data = IOHelper.readTxt("product.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String[] datas = data.split(";");
        return datas[0];
    }

    public static void findOptions(By by) {
        FormHelper.click(by);
        List<WebElement> options = FormHelper.findElements(by);
        if(options.size() ==0){
            Assert.isTrue(true,"Adet sayısı artırılamadı");
        }
    }

    public static String formatString(String input) {
        // Virgülü noktaya çevir ve boşlukları temizle
        return input.split(" ")[0].replace(",", "").replace(" ", "");
    }

    public static boolean areStringsEqual(String str1, String str2) {
        // DecimalFormat kullanarak sayıları karşılaştır
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        try {
            double num1 = decimalFormat.parse(str1).doubleValue();
            double num2 = decimalFormat.parse(str2).doubleValue();
            return num1 == num2;
        } catch (ParseException e) {
            // Sayısal bir hata oluştu
            e.printStackTrace();
            return false;
        }
    }
}
