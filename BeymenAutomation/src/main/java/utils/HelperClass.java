package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class HelperClass {
    private static HelperClass helperClass;

    private static WebDriver driver;
    public static WebDriverWait wait;
    public final static int TIMEOUT = 5;

    private HelperClass() {
        ChromeOptions options = new ChromeOptions();
        String downloadFolder = System.getProperty("user.dir") + File.separator + "Drafts";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory", downloadFolder);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        driver.manage().window().setPosition(new Point(3000,1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        FormHelper.webDriver = driver;
        FormHelper.wait = wait;
    }

    public static void openPage(String url) {
        driver.get(url);
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {

        if (helperClass==null) {

            helperClass = new HelperClass();
        }
    }

    public static void tearDown() {

        if(driver!=null) {
            driver.close();
            driver.quit();
        }

        helperClass = null;
    }

}
