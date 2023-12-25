package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


/**
 * Created by Sridhar Bandi on 28/01/19.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"runner/definitions"},
        plugin = {"json:target/cucumber-report.json","html:target/cucumber-html"})
public class JUnitRunnerTest {
}
