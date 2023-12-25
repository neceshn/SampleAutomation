package runner.definitions;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.HelperClass;

public class Hooks {

    @Before
    public static void setUp() {
        HelperClass.setUpDriver();
    }
    @After
    public static void tearDown(Scenario scenario) {;

        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        HelperClass.tearDown();
    }
}
